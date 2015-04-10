package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Dictionary {
	private String _path;
	private ArrayList<String> _knownWords;
	public Dictionary(String path){
		_path = path;
		_knownWords = new ArrayList<String>();
		Scanner scanner = null;
		try {
			
			File dictionary = new File(_path);
			scanner = new Scanner(dictionary);
			while(scanner.hasNextLine()){
				String next = scanner.nextLine().toUpperCase();
				_knownWords.add(next);
				
			}
				
			}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		finally {
			scanner.close();
		}
	}
	
	
	public boolean isAWord(String word){
		long index = Collections.binarySearch(_knownWords, word.toUpperCase());
		
		if(index>-1){
			return true;
		}
		else{
			return false;
		}
		
		

	}	
	public String getFilePath(){
		return _path;
	}
	}	
	
