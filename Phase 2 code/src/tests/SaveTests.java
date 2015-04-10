package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.model.Scrabble_055;


public class SaveTests {

	@Test
	public void test() {
		Scrabble_055 s = new Scrabble_055();
		s.saveToFile("src/code/model/save.txt");
		
	}

}
