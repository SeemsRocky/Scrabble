package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// I don't know where to put this so I'm just going to write it here and we can work on where to put it when we meet.
public class Dictionary {
	File dictionary = new File("src/code/model/Dictionary.txt");
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
	}	
	