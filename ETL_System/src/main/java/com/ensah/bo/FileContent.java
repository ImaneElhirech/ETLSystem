package com.ensah.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileContent {
	
	private Map<String,List<String>> columsFileContent;
	private List<String> colums;
	
	public FileContent() {
		super();
		columsFileContent=new HashMap<String,List<String>>();  
		colums=new ArrayList<String>();
	}

	
	

	public List<String> getColums() {
		return colums;
	}




	public void setColums(List<String> colums) {
		this.colums = colums;
	}




	public void setColumsFileContent(HashMap<String, List<String>> columsFileContent) {
		this.columsFileContent = columsFileContent;
	}



	public Map<String, List<String>> getColumsFileContent() {
		return columsFileContent;
	}




	



}
