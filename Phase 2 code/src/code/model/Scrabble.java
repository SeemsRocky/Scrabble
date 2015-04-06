package code.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

public class Scrabble extends Observable{

	/**
	 * Stores tiles.
	 */
	private Inventory _inv;
	/**
	 * Stores players.
	 */
	private ArrayList<Player> _players;
	/**
	 * tile board to be played on
	 */
	private Board _board;
	/**
	 * Number of players
	 */
	private int _numberOfPlayers;

	/**
	 * Class constructor
	 */
	public Scrabble(){
		_inv = new Inventory();
		_board = new Board();
		_players = new ArrayList<Player>();
	}
	public ArrayList<Player> getPlayers()
	{
		return _players;
	}
	/**
	 * Adds a new player to the game.
	 */
	//	private void addNewPlayer(){
	//		_players.add(new Player(_inv));
	//	}
	public void saveToFile(String filename) {
		PrintStream stream = null;
		try {
			stream = new PrintStream(filename);
			int lengthOfTheBoard = _board.getLength();
			int widthOfTheBoard = _board.getWidth();
			String lengthOfBoard = Integer.toString(lengthOfTheBoard);
			String widthOfBoard = Integer.toString(widthOfTheBoard);
			String filePathOfDictionary = "\nsrc/code/model/Dictionary.txt";
			stream.format(lengthOfBoard);
			stream.format(" " +widthOfBoard);
			stream.format(filePathOfDictionary);
			for(int i = 0; i<_players.size(); i++){
				String playerName = _players.get(i).getName();
				String playerScore = Integer.toString(_players.get(i).getScore());
				String playerRack = _players.get(i).getTileRack().toString();
				ArrayList<String> playerProperties = new ArrayList<String>();
				playerProperties.add(playerName);
				playerProperties.add(playerScore);
				playerProperties.add(playerRack);
				stream.format(playerProperties.toString());
				if(i!=_players.size()-1){
					stream.format(",");
				}
			}
			stream.format("\n" + _inv.getInventory().toString());

		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
		}
		finally {
			stream.close();
		}
	}
	/*
	 * ROCKY'S CODE THAT DOESNT WORK AT ALL 
	 */
	public void fileWriteHighScore(Scrabble s, String filename) {
        PrintStream stream = null;
        try
        {
            stream = new PrintStream(filename);
            int numLines = getNumberOfLines(filename);
            ArrayList<String> al = getHighScoreFile(filename);
            ArrayList<Player> p = s.getPlayers();
            sort1(p);
            for(int i=0;i<_players.size();i++)
            {
            	if(numLines<20)
            	{
            		stream.format("<%s> : <%d> %n",p.get(i).getName(),p.get(i).getScore());
            	}
            	else
            	{
            		for(int j=0;j<p.size();j++)
            		{
	            		if(convertInt(al.get(al.size()-1))<p.get(i).getScore())
	            		{
	            			
	            		}
            		}
            	}
            }
        } catch (FileNotFoundException e)
        {
            System.err.println("File not found and cannot be created: "+ filename);
        }
        finally
        {
            stream.close();
        }
    }
	
	private void sort1(ArrayList<Player> al)
	{
		int pos =0;
		for(int i =0; i<al.size()-1;i++)
		{
			pos=i;
			for(int j=i+1; j<al.size();j++)
			{
				if(al.get(j).getScore()<al.get(i).getScore())
				{
					pos = j;
				}
			}
			Player temp = al.get(pos);
			al.set(pos,al.get(i));
			al.set(i, temp);
		}	
	}
	/**
	 * sorts the arraylist of 20 
	 * @param as
	 */
	private void sort2(ArrayList<String> as)
	{
		int pos =0;
		for(int i =0; i<as.size()-1;i++)
		{
			pos=i;
			for(int j=i+1; j<as.size();j++)
			{
				if(convertInt(as.get(j))<convertInt(as.get(i)))
				{
					pos = i;
				}
			}
			String temp = as.get(pos);
			as.set(pos,as.get(i));
			as.set(i, temp);
		}	
	}
	/**
	 * Takes the score from the string
	 * @param s String with a number in it
	 * @return The number as an int 
	 */
	private int convertInt(String s)
	{
		int begin=0;
		int end=0;
		int score=0;
		String scoreString ="";
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i)=='<')
			{
				begin=i;
			}
			if(s.charAt(i)=='>')
			{
				end=i;
			}
		}
		for(int j=begin+1;j<end;j++)
		{
			scoreString = scoreString + s.charAt(j);
		}
		score = Integer.parseInt(scoreString);
		return score;
	}
	private int getNumberOfLines(String filename)
    {
        Scanner scan = new Scanner(filename);
        int lineNumber = 0;
        try {
            scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) 
            {
            	lineNumber++;
            }
         } catch (FileNotFoundException e) {
            System.err.println("File not found: "+filename);
        }
        finally {
            scan.close();
        }
        return lineNumber;
    }
	public ArrayList<String> getHighScoreFile(String filename)
    {
        Scanner scan = null;
        ArrayList<String> str = new ArrayList<String>();
        try {
            scan = new Scanner(new File("src/code/model/Highscores.txt"));
            int lineNumber = 0;
            while (scan.hasNextLine()) {
                String oneLineFromFile = scan.nextLine();
                str.add(oneLineFromFile);
                System.out.format("%3d %s %n", lineNumber, oneLineFromFile);
                lineNumber++;
            }
         } catch (FileNotFoundException e) {
            System.err.println("File not found: "+filename);
        }
        finally { 
            scan.close();
        }
        return str;
    }
	
	
}
