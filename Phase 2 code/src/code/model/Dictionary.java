package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Dictionary {
	private String _path = "src/code/model/Dictionary.txt";
	File dictionary = new File(_path);
	public boolean isAWord(String word){
		try {
			Scanner scanner = new Scanner(dictionary);
			while(scanner.hasNextLine()){
				String next = scanner.next();
				if(next.equals(word)){
					return true;
				}
				else{
					return false;
				}
			}
				
			}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		finally{
			//cleanup code
		}
		
		
		return true;

	}	
	public String getFilePath(){
		return _path;
	}
	}	
	