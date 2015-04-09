package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import code.model.*;

public class HighscoreTests 
{
	@Test
	public void testFirstGame() 
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
		assertTrue("The list is" + arrStr.get(0),1==2);
	}
}
