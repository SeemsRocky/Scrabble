package tests;

import static org.junit.Assert.*;

import org.junit.Test;



public class DictionaryTests {
	
	private void commonTestCode(String input, Boolean expected) {
		code.model.Dictionary su = new code.model.Dictionary("src/code/model/Dictionary.txt");
		Boolean actual = su.isAWord(input);
		assertTrue("With input "+input
				+ " I expected the answer to be " + expected
				+ " but the actual response I got was "+ actual,
				expected==actual);
	}

	@Test public void test01() { commonTestCode("aardvark",true); }
	@Test public void test02() { commonTestCode("ABC", true); }
	@Test public void test03() { commonTestCode("accuracy", true); }
	@Test public void test04() { commonTestCode("timhortonhhhhhhhhhs", false); }

}

