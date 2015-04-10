package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Dictionary_055 {
	/**
	 * This returns the dictionary path
	 */
	private String _path;
	/**
	 * This returns an ArrayList of type string consisting of all the words in a Dictionary
	 * @author    driver:
	 * @author navigator: 
 	*
 	*/
	private ArrayList<String> _knownWords;
	/**
	 * Constructor for a new dictionary
	 * @param path The path for the dictionary
	 */
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
	 * Checks if the word exists in the dictionary file
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
	 * gets the filepath of dictionary
	 * @return the FilePath
	 */
	public String getFilePath(){
		return _path;
	}
	}	
	
