package com.ensah.service;

import java.io.IOException;

public interface ETLService {
	public void loadColums(String  fileName) throws IOException;
	public void loadData(String  fileName) throws IOException;
	public void loadDataFirstColumn(String  fileName) throws IOException;
	
}
