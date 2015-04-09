package code.model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

public class Scrabble extends Observable{
	/**
	 * ArrayList of colors from which a color is picked for the player to be associated with
	 */
	
	private ArrayList<Color> _arrayOfColor;

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
	

	private String _pathOfDictionary;
	private String _pathOfRestoreFile;
	

	/**
	 * Class constructor
	 */
	public Scrabble(ArrayList<String> players){
		_inv = new Inventory();
		_board = new Board(20,20);
		_players = new ArrayList<Player>();
		for(int i = 0; i<_players.size(); i++){
			addNewPlayer(_inv, players.get(i));
		}
		_pathOfDictionary = "src/code/model/Dictionary.txt";
		Dictionary wordChecker = new Dictionary(_pathOfDictionary);
		_arrayOfColor = new ArrayList<Color>();
		_arrayOfColor.add(Color.BLUE);
		_arrayOfColor.add(Color.GREEN);
		_arrayOfColor.add(Color.ORANGE);
		_arrayOfColor.add(Color.YELLOW);
		_arrayOfColor.add(Color.RED);
	}
	
	public Scrabble(){
		_inv = new Inventory();
		_board = new Board(20,20);
		_players = new ArrayList<Player>();
		for(int i = 1; i<3; i++){
			addNewPlayer(_inv, "Player " + i);
		}

		

	}
	public ArrayList<Player> getPlayers(){
		return _players;
	}
	/**
	 * Adds a new player to the game.
	 */
	private void addNewPlayer(Inventory inv,String name){
		
		_players.add(new Player(inv, name, _arrayOfColor.get(0)));
	    _arrayOfColor.remove(0);
	}


	public void saveToFile(String filename) {
		PrintStream stream = null;
		try {
			stream = new PrintStream(filename);
			int lengthOfTheBoard = _board.getLength();
			int widthOfTheBoard = _board.getWidth();
			String lengthOfBoard = Integer.toString(lengthOfTheBoard);
			String widthOfBoard = Integer.toString(widthOfTheBoard);
			String filePathOfDictionary = _pathOfDictionary;
			stream.format(lengthOfBoard);
			stream.format(" " +widthOfBoard);
			stream.format(filePathOfDictionary);
			for(int i = 0; i<_players.size(); i++){
				String playerName = _players.get(i).getName();
				String playerColor = _players.get(i).getColor().toString();
				String playerScore = Integer.toString(_players.get(i).getScore());
				String playerRack = _players.get(i).getTileRack().toString();
				ArrayList<String> playerProperties = new ArrayList<String>();
				playerProperties.add(playerName);
				playerProperties.add(playerColor);
				playerProperties.add(playerScore);
				playerProperties.add(playerRack);
				stream.format(playerProperties.toString());
				if(i!=_players.size()-1){
					stream.format(",");
				}
			}
			stream.format("\n" + _inv.getInventory().toString());
			String board = "";
			for(int i = 0; i<20; i++){
				for(int j = 0; j<20; j++){
					if(_board.isEmpty(i, j)){
						board = board + '-';
					}
					else{ 
						char c = _board.getTile(i, j).getChar();
						String character = "";
						character = character + c;
						ArrayList<String> playerLetter = new ArrayList<String>();
						playerLetter.add(character);
						playerLetter.add(_board.getTile(i,j).getPlayer().getName());
						board = board + playerLetter.toString();
					}
				}
			}
			stream.format("\n" + board);

		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
		}
		finally {
			stream.close();
		}
	}


	public void restoreFromFile(String path){
            // String[] strings = string.replace("[", "").replace("]", "").split(", ");
		    // going to need to set up the tile rack
	}

	public void main(String[] args){
		if(args.length==1){
			_pathOfRestoreFile = args[0];
			this.restoreFromFile(_pathOfRestoreFile);
		}
		else{
			_pathOfDictionary = args[0];
			ArrayList<String> nameOfPlayers = new ArrayList<String>();
			for(int i = 1; i<args.length;i++){
				nameOfPlayers.add(args[i]);
			}
			new Scrabble(nameOfPlayers);

		}


	}

	/**
	 * It prints out the highscores and writes them onto a text file.
	 * @param s the current scrabble game
	 */
	public void fileWriteHighScore() {
        PrintStream stream = null;
        try
        {
            stream = new PrintStream("src/code/model/Highscores.txt");
            int numLines = getNumberOfLines("src/code/model/Highscores.txt"); 
            ArrayList<String> al = getHighScoreFile("src/code/model/Highscores.txt");
            ArrayList<Player> p = _players;
            sort1(p); //sorts order by score in game s
            if(numLines==0) //if empty file just print the in order of p
            {
            	for(int i=0; i<p.size();i++) //highest score on top
            	{
            		stream.format("<%s>:<%d> %n",p.get(i).getName(),p.get(i).getScore());
            	}
            }
            else if(numLines>=4 && numLines<20) // if already has more than 4 but less than 20
            	{
            		for(int x=0;x<p.size();x++) // checks player score
            		{
            			for(int y=0;y<al.size();y++) // with current score so sorted properly
            			{
            				if(convertInt(al.get(y))<p.get(x).getScore())
            				{
            					al.add(y,"<"+p.get(x).getName()+">:<" +p.get(x).getScore()+">");
            				}
            				else
            				{
            					al.add("<"+p.get(x).getName()+">:<" +p.get(x).getScore()+">");
            				}
	            		}
            		}
            		for(int i=0;i<al.size();i++) // print out everything added
            		{
            			stream.format("%s %n",p.get(i));
            		}
            	}
            else // so more than 20 lines
            {
            	int num =0; // number of times a new score is added
            	for(int x=0;x<p.size();x++) // checks player score
            	{
            		for(int y=0;y<al.size();y++) // with current score so sorted properly
            		{
            			if(convertInt(al.get(y))<p.get(x).getScore()) // if greater add
            			{
            				al.add(y,"<"+p.get(x).getName()+">:<" +p.get(x).getScore()+">");
            				++num;
            			}
	            	}
            	}
            	for(int i=0;i<al.size()-num;i++) // print out everything added only 20 lines
            	{
            		stream.format("%s %n",p.get(i));
            	}
           	}
            
        } catch (FileNotFoundException e)
        {
            System.err.println("File not found and cannot be created: "+ "src/code/model/Highscores.txt");
        }
        finally
        {
            stream.close();
        }
    }
	/**
	 * sorts the Arraylist of player according to their scores
	 * Makes descending order of scores so highest score on top
	 * @param al Arraylist of players of scrabble game
	 */
	private static void sort1(ArrayList<Player> al)
	{
		int pos;
		for(int i =0; i<al.size()-1;i++)
		{
			pos=i;
			for(int j=i+1; j<al.size();j++)
			{
				if(al.get(j).getScore()<al.get(pos).getScore())
				{
					pos = j;
				}
			}
			Player temp = al.get(i);
			al.set(i,al.get(pos));
			al.set(pos, temp);
		}	
	}
	/**
	 * Takes the score from the string
	 * @param s String with a number in it
	 * @return The number as an int 
	 */
	private static int convertInt(String s)
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
	/**
	 * gets the number of lines of the file
	 * @param filename name of file
	 * @return how many lines in the file
	 */
	private static int getNumberOfLines(String filename)
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
	/**
	 * Gets all the lines in the file and stores them into an arraylist
	 * @param filename name of file
	 * @return string arraylist of each line in the file
	 */
	public ArrayList<String> getHighScoreFile(String filename)
    {
        Scanner scan = null;
        ArrayList<String> str = new ArrayList<String>();
        try {
            scan = new Scanner(new File("src/code/model/Highscores.txt"));
            while (scan.hasNextLine()) {
                String oneLineFromFile = scan.nextLine();
                str.add(oneLineFromFile);
            }
         } catch (FileNotFoundException e) {
            System.err.println("File not found: "+filename);
        }
        finally { 
            scan.close();
        }
        return str;
    }

	public void mark(Tile _til, int _row, int _col) {
		
		
	}
	

}
