package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Dictionary_055 {
	/**
	 * Instance Variable of the path of the dictionary
	 */
	private String _path;
	/**
	 * Instance Variable of all the words in the dictionary put into an ArrayList of Strings
 	 */
	private ArrayList<String> _knownWords;
	/**
	 * Constructor for a new dictionary
	 * @param path The path for the dictionary file
	 * @author jhe8 (Jonathan He)
	 * @navigator adhishch (Adhish Chugh)
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
	 * @param word String of the word that needs to be checked
	 * @return true if it exists, false otherwise
	 * @author driver: jhe8 (Jonathan He)
     * @author navigator: adhishch (Adhish Chugh)
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
	 * @return a string which has the path to the dictionary file
	 * @author adhishch (Adhish Chugh)
	 */
	public String getFilePath(){
		return _path;
	}
	}	
	
