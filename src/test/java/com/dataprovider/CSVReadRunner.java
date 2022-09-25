package com.dataprovider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVReadRunner {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir")+"\\testdata\\sampledata.csv";
		
     File myfile = new File(path);
     Reader read = new FileReader(myfile);
     CSVReader myCSV = new CSVReader(read);
    List<String []> mydatalist = myCSV.readAll();
    for (String [] data :mydatalist) {
    	for (String d :data) {
    		System.out.print(d +"  ");
    	}
    	System.out.println(" ");
    }
   myCSV.close();

	}

}
