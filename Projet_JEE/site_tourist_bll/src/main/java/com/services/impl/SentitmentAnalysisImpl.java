package com.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Commentaire;
import com.bo.Destination;
import com.bo.WordPolarity;
import com.dao.DestinationDao;
import com.dao.WordPolarityDao;
import com.services.SentimentAnalysis;
import com.utils.Porter;

@Service
@Transactional
public class SentitmentAnalysisImpl implements SentimentAnalysis {

	@Autowired
	private WordPolarityDao wordPolDao;

	@Autowired
	private DestinationDao destinationDao;


	
	
	@Scheduled(fixedRate = 10000)
	public void destinationRating() {

		System.out.println("destinationRating...");

		List<Destination> destinations = destinationDao.getAll();

		double note = 0.0;

		for (Destination it : destinations) {

			System.out.println("dest. " + it);

			note = 0.0;

			// On récupère les commentaires de la destination
			List<Commentaire> comments = it.getCommentaires();

			// On clacule la polarité de chaque commentaire
			for (Commentaire itc : comments) {
				note+=getTextPolarity(itc.getText());

			}

			if (comments.size() != 0) {
				
				it.setNote(note);
				
			}
			
			if(note>0) {
				it.setScore("positive");
			}
			else if(note<0) {
				it.setScore("négative");
			}
			else {
				it.setScore("neutre");
			}

			destinationDao.update(it);

		}

	}

//segmenter
	public static List<String> segmenter(String text) {
		
	    List<String> words = new ArrayList<String>();
	    
	    BreakIterator breakIterator = BreakIterator.getWordInstance();
	    
	    breakIterator.setText(text);
	    
	    int lastIndex = breakIterator.first();
	    
	    while (BreakIterator.DONE != lastIndex) {
	    	
	        int firstIndex = lastIndex;
	        lastIndex = breakIterator.next();
	        if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
	            words.add(text.substring(firstIndex, lastIndex));
	        }
	    }

	    return words;
	}
	public static String[] stopwords(List<String> mots) {
		int k = 0, i, j;
		ArrayList<String> wordsList = new ArrayList<String>();

		String sCurrentLine;

		String[] stopwords = new String[2000];
		

		try {
			Porter p= new Porter();
			FileReader fr = new FileReader("C:\\Users\\ima\\Desktop\\stopwords.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((sCurrentLine = br.readLine()) != null) {
				stopwords[k] = sCurrentLine;
				k++;
			}
			for (String w : mots) {
				StringBuilder builder = new StringBuilder(w);
				String[] words = builder.toString().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
				for (String word : words) {
					p.stripSuffixes(word);
					p.stripAffixes(word);
					wordsList.add(word);
				}
				for (int ii = 0; ii < wordsList.size(); ii++) {
					for (int jj = 0; jj < k; jj++) {
						if (stopwords[jj].contains(wordsList.get(ii).toLowerCase())) {
							wordsList.remove(ii);
							ii -= 1;
							break;
						}
					}
				}

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		String[] wordsListArr = wordsList.toArray(new String[wordsList.size()]);
		
		return wordsListArr;
	}
	
	public double getTextPolarity(String ptext) {

		// tockenize

		String[] tokens = stopwords(segmenter(ptext));
		int cmposi=0;int cmpneg=0;
		int res;

		if (tokens.length == 0) {
			return 0;
		}

		double val = 0.0;

		for (String it : tokens) {
			val=getWordPolarity(it);
			if(val==1) {
				cmposi++;
			}
			if(val==-1) {
				cmpneg++;
			}
		}
		
		if(cmposi>tokens.length/2) {
			res=1;
		}
		else { 
			res=-1;
		}
		
		if(cmpneg>tokens.length/2) {
			res=-1;
		}
		else { 
			res=1;
		}

		return res;
	}

	private double getWordPolarity(String pWord) {

		List<WordPolarity> words = wordPolDao.getAll();

		for (WordPolarity it : words) {

			if (it.getWord().equals(pWord)) {
				return it.getPolarity();
			}
		}

		return 0;
	}

	public void addWord(WordPolarity word) {

		wordPolDao.create(word);

	}

}
