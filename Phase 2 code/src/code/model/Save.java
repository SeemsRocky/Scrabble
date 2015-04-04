package code.model;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Save {
	private Board _b;
	private Inventory _inv;
	
	public Save(Board b, Inventory inv){
		_b = b;
		_inv = inv;
	}

	public void saveToFile(String filename) {
		PrintStream stream = null;
		try {
			stream = new PrintStream(filename);
			int lengthOfTheBoard = _b.getLength();
			int widthOfTheBoard = _b.getWidth();
			String lengthOfBoard = Integer.toString(lengthOfTheBoard);
			String widthOfBoard = " " +Integer.toString(widthOfTheBoard);
			String filePathOfDictionary = "\nsrc/code/model/Dictionary.txt";
			
			stream.format(lengthOfBoard);
			stream.format(widthOfBoard);
			stream.format(filePathOfDictionary);
		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
		}
		finally {
			stream.close();
		}
	}
	
}
