package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import code.model.*;

public class HighscoreTests 
{
	@Test
	public void testHS1() 
	{
		ArrayList<String> l= new ArrayList<String>();
		l.add("John");
		l.add("Jack");
		l.add("Jorge");
		l.add("Jeff");
		Scrabble s = new Scrabble(l);
		ArrayList<Player> p =s.getPlayers();
		for(int i=0;i<p.size();i++)
		{
			p.get(i).addScore(0,(int)(Math.random()*100)+5);
		}
		s.fileWriteHighScore("src/code/model/Highscores.txt");
		ArrayList<String> arrStr= s.getHighScoreFile("src/code/model/Highscores.txt");
		int expected = 4;
		int actual = arrStr.size();
		assertTrue("The actual length is " + actual + " but expected " + 
					expected,actual==expected);
	}
	@Test
	public void testHS2() 
	{
		ArrayList<String> l= new ArrayList<String>();
		l.add("John");l.add("Jack");l.add("Jorge");l.add("Jeff");
		ArrayList<String> al= new ArrayList<String>();
		al.add("Abe");al.add("Abc");l.add("Aaron");l.add("Argh");
		Scrabble s = new Scrabble(l);
		Scrabble s1 = new Scrabble(l);
		s.fileWriteHighScore("src/code/model/Highscores.txt");
		s1.fileWriteHighScore("src/code/model/Highscores.txt");
		ArrayList<Player> p =s.getPlayers();
		for(int i=0;i<p.size();i++)
		{
			p.get(i).addScore(0,(int)(Math.random()*100)+5);
		}
		ArrayList<Player> p1 =s1.getPlayers();
		for(int i=0;i<p1.size();i++)
		{
			p1.get(i).addScore(0,(int)(Math.random()*100)+5);
		}
	
		ArrayList<String> arrStr= s.getHighScoreFile("src/code/model/Highscores.txt");
		int expected = 8;
		int actual = arrStr.size();
		assertTrue("The actual length is " + actual + " but expected " + 
					expected,actual==expected);
	}
}
