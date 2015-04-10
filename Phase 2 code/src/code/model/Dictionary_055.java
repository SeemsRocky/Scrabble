package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This returns an ArrayList of type string consisting of all the words in a Dictionary
 * @author    driver:
 * @author navigator: 
 *
 */
public class Dictionary_055 {
	private String _path;
	private ArrayList<String> _knownWords;
	public Dictionary_055(String path){
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
	/**
	 * 
	 * @param word the String that is to be checked if it is a word that exists in the dictionary or not
	 * @return true if it exists, false otherwise
	 * @author    driver:
     * @author navigator: 
	 */
	
	public boolean isAWord(String word){
		long index = Collections.binarySearch(_knownWords, word.toUpperCase());
		
		if(index>-1){
			return true;
		}
		else{
			return false;
		}
		
		

	}	
	/**
	 * 
	 * @return the FilePath
	 */
	public String getFilePath(){
		return _path;
	}
	}	
	
