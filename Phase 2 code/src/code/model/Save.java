package code.model;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Save {
	private Board _b;
	private Inventory _inv;
	
	public Save(Board b){
		_b = b;
	}

	public void saveToFile(String filename) {
		PrintStream stream = null;
		try {
			stream = new PrintStream(filename);
			int lengthOfTheBoard = _b.getLength();
			int widthOfTheBoard = _b.getWidth();
			String lengthOfBoard = Integer.toString(lengthOfTheBoard);
			String widthOfBoard = " " +Integer.toString(widthOfTheBoard);
			stream.format(lengthOfBoard);
			stream.format(widthOfBoard);
		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
		}
		finally {
			stream.close();
		}
	}
	
}
