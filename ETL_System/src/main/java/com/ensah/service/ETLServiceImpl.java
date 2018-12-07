package com.ensah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ensah.bo.Fichier;
import com.ensah.bo.FileContent;
import com.ensah.dao.FichierRepository;

@Service
@Transactional
public class ETLServiceImpl implements ETLService{
	@Autowired
	private FichierRepository fichierRep;
	
	private FileContent f;
	
	public void affich(List<String> list) {
		for (Iterator iter =  list.iterator(); iter.hasNext();)
	    {
	     String  ch2= (String)iter.next();
	      System.out.println(ch2)  ;
	    }
	}
	
	
	public void loadColums(String  fileName) throws IOException {
		String readLine="";
		
		File file = ResourceUtils.getFile(fileName);
				 
				//File is found
				System.out.println("File Found : " + file.exists());
			
				
				//Read File first line
				
				BufferedReader b = new BufferedReader(new FileReader(file));
				
				System.out.println("**********************************Reading first line of the file************************");

	            readLine = b.readLine();
	            System.out.println(readLine);
	            
	            //split line to list of colums
	            List<String> colums = Arrays.asList(readLine.split("\\s*;\\s*"));
				System.out.println("**********************************Colums : ************************");

	            affich(colums);
	            //save colums
	            
	            f=new FileContent();
	            f.setColums(colums);
				
	}
	

	@Override
	public void loadData(String fileName) throws IOException {
		//get first line
		File file = ResourceUtils.getFile(fileName);
		String readLine="";
		BufferedReader b = new BufferedReader(new FileReader(file));
		
		System.out.println("**********************************Reading first line of the file************************");

        readLine = b.readLine();
		Path wiki_path = Paths.get(fileName);

	    Charset charset = Charset.forName("ISO-8859-1");
	    
	      List<String> lines = Files.readAllLines(wiki_path, charset);
	      
	      String subString;
	      

	      for (String line : lines) {
	    	  List<String> cnt=new ArrayList<String>();
	    	  if(line!=readLine) {
	       
	    		  int iend=0,iend2=-1,iend1;
	    		  
	    		 while(iend<line.length()) {
	    			   
	    			   iend1 = line.indexOf(";",iend2+1);
	    			   iend2=iend;
	    			   
	    			   subString= line.substring(iend2 , iend1);
	    			   
	    			   
		            	cnt.add(subString);
	    		  }
	    			   for(String s:f.getColums()) {
	    		  f.getColumsFileContent().put(s, cnt);
	    		  }
	        
	            } 
	        }
	        
	        
	    	 
	      Iterator iterator = f.getColumsFileContent().entrySet().iterator();
          while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
            System.out.println("clé: "+mapentry.getKey()
                              + " | valeur: " + mapentry.getValue()+"\n");
          }
	     
		
	}
	
	
	

	public void loadDataFirstColumn(String fileName) throws IOException {
		//get first line
		File file = ResourceUtils.getFile(fileName);
		String readLine="";
		BufferedReader b = new BufferedReader(new FileReader(file));
		
		System.out.println("Reading first line of the file");

        readLine = b.readLine();
		Path wiki_path = Paths.get(fileName);

	    Charset charset = Charset.forName("ISO-8859-1");
	    
	      List<String> lines = Files.readAllLines(wiki_path, charset);
	      
	      String subString,subString1;
	      
	      List<String> cnt=new ArrayList<String>();
	      for (String line : lines) {
	    	  
	    	  if(line!=readLine) {
	        
	    		  int iend = line.indexOf(";");
                  int second = line.indexOf(";", iend + 1);
                  
                  if (iend != -1) 
      	            {
      	            subString= line.substring(0 , iend);
      	            subString1= line.substring(iend+1 , second);
		            	
	    		  
		            	cnt.add(subString);
	            
	        }
	        
	    	  }
	    	 
	      
	
          f.getColumsFileContent().put(f.getColums().get(0), cnt);
	
	      }
	      Iterator iterator = f.getColumsFileContent().entrySet().iterator();
          while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
            System.out.println("clé: "+mapentry.getKey()
                              + " | valeur: " + mapentry.getValue()+"\n");
          }
	     
		
	}
	

}
