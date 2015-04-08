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
		try {
			File dictionary = new File(_path);
			Scanner scanner = new Scanner(dictionary);
			while(scanner.hasNextLine()){
				String next = scanner.next().toUpperCase();
				_knownWords.add(next);
			}
				
			}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
	}
	
	
	public boolean isAWord(String word){
		int index = Collections.binarySearch(_knownWords, word.toUpperCase());
		if(index!=-1){
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
	