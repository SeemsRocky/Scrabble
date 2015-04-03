package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.model.Board;
import code.model.Save;

public class SaveTests {

	@Test
	public void test() {
		Board b = new Board();
		
		Save s = new Save(b);
		s.saveToFile("src/code/model/save.txt");
		
	}

}
