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

import code.ui.ScrabbleUI_055;

public class Scrabble_055{
	/**
	 * ArrayList of colors from which a color is picked for the player to be associated with
	 */
	private ArrayList<Color> _arrayOfColor;
	/**
	 * Stores tiles.
	 */
	private Inventory_024_055 _inv;
	/**
	 * Stores players.
	 */
	private ArrayList<Player_024_055> _players;
	/**
	 * tile board to be played on
	 */
	private Board_024_055 _board;
	/**
	 * The filepath for the dictionary
	 */
	private String _pathOfDictionary;
	/**
	 * the filepath to the restore file
	 */
	private String _pathOfRestoreFile;
	
	/**
	 * Class constructor
	 * @param players List of player names in the game
	 * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public Scrabble_055(ArrayList<String> players){
		_inv = new Inventory_024_055();
		_board = new Board_024_055(20,20);
		_players = new ArrayList<Player_024_055>();
		_pathOfDictionary = "src/code/model/Dictionary.txt";
		Dictionary_055 wordChecker = new Dictionary_055(_pathOfDictionary);
		for(int i = 0; i<_players.size(); i++){
			addNewPlayer(_inv, players.get(i), wordChecker);
		}
		
		_arrayOfColor = new ArrayList<Color>();
		_arrayOfColor.add(Color.BLUE);
		_arrayOfColor.add(Color.GREEN);
		_arrayOfColor.add(Color.ORANGE);
		_arrayOfColor.add(Color.YELLOW);
		_arrayOfColor.add(Color.RED);
	}
	/**
	 * Constructor to restore a game that has been saved
	 * @param restorePath the filepath for the game to be restored
	 * * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public Scrabble_055(String restorePath){
		ArrayList<String> restoreFile = new ArrayList<String>();
		Scanner scanner = null;
		try {

			File dictionary = new File(restorePath);
			scanner = new Scanner(dictionary);
			while(scanner.hasNextLine()){
				String next = scanner.nextLine().toUpperCase();
				restoreFile.add(next);

			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		finally {
			scanner.close();
		}
		String lengthAndWidth = restoreFile.get(0);
		ArrayList<String> lw = new ArrayList<String>();
		String dimensions = "";
		for(int i = 0; i<lengthAndWidth.length(); i++){
			char c = lengthAndWidth.charAt(i);
			if(c==' '){
				dimensions = "";
				lw.add(dimensions);
			}
			else{
				dimensions = dimensions + c;
			}
			
		}
		int boardLength = Integer.parseInt(lw.get(0));
		int boardWidth = Integer.parseInt(lw.get(1));
		String pathOfDictionary = restoreFile.get(1);
		
			
	}
	/**
	 * Class constructor with no parameters that start a game of scrabble for 2 players 
	 * * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public Scrabble_055(){
		_inv = new Inventory_024_055();
		_board = new Board_024_055(20,20);
		_players = new ArrayList<Player_024_055>();
		_arrayOfColor = new ArrayList<Color>();
		_arrayOfColor.add(Color.BLUE);
		_arrayOfColor.add(Color.GREEN);
		_arrayOfColor.add(Color.ORANGE);
		_arrayOfColor.add(Color.YELLOW);
		_arrayOfColor.add(Color.RED);
		_pathOfDictionary = "src/code/model/Dictionary.txt";
		Dictionary_055 wordChecker = new Dictionary_055(_pathOfDictionary);
		for(int i = 1; i<3; i++){
			addNewPlayer(_inv, "Player " + i, wordChecker);
		}

	}
	/**
	 * Gets the arraylist of players in the scrabble game
	 * @return arraylist of players
	 */
	public ArrayList<Player_024_055> getPlayers(){
		return _players;
	}
	/**
	 * Adds a new player to the game.
	 * @author    driver: adhishch (Adish Chugh)
     * @author navigator: 
	 */
	private void addNewPlayer(Inventory_024_055 inv,String name, Dictionary_055 wordChecker){

		_players.add(new Player_024_055(inv, name, _arrayOfColor.get(0), wordChecker, _board));
		_arrayOfColor.remove(0);
	}

	/**
	 * Saves the length and width of board, and filepath for the dictionary
	 * player's name,score,tilerack, and color and all the current tiles 
	 * placed down onto the board.
	 * @param filename name of file to save the current scrabble game
	 * * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
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
			stream.format("\n" +filePathOfDictionary + "\n");
			for(int i = 0; i<_players.size(); i++){
				String playerName = _players.get(i).getName();
				String playerColor = _players.get(i).getColor().toString();
				String playerScore = Integer.toString(_players.get(i).getScore());
				String myPlayerRack = "[";
				for(int l = 0;l<12;l++){
					myPlayerRack = myPlayerRack + _players.get(i).getTileRack().getTile(l).toString();
				}
				myPlayerRack = myPlayerRack + "]";
//				String playerRack = _players.get(i).getTileRack().getTiles().toString();
				ArrayList<String> playerProperties = new ArrayList<String>();
				playerProperties.add(playerName);
				playerProperties.add(playerColor);
				playerProperties.add(playerScore);
				playerProperties.add(myPlayerRack);
				stream.format(playerProperties.toString());
				if(i!=_players.size()-1){
					stream.format(",");
				}
			}
			String myInv = "";
			for(int k =0; k<_inv.getInventory().size(); k++){
				myInv = myInv + _inv.getInventory().get(k).toString();
			}
			stream.format("\n" +"["+ myInv + "]");
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
		
		
	}
	/**
	 * main method that takes in string array of args
	 * if args length is 1, Restore file path is the string in args
	 * if it has more than one, each player has their own different restore pathfile
	 * @param args
	 * * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public void main(String[] args){
		if(args.length==1){
			_pathOfRestoreFile = args[0];
			new Scrabble_055(_pathOfRestoreFile);
		}
		else{
			_pathOfDictionary = args[0];
			ArrayList<String> nameOfPlayers = new ArrayList<String>();
			for(int i = 1; i<args.length;i++){
				nameOfPlayers.add(args[i]);
			}
			new ScrabbleUI_055(nameOfPlayers);

		}


	}

	/**
	 * It prints out the highscores and writes them onto a text file.
	 * @param s the current scrabble game
	 * @author    driver: rockylia (Rocky Liao)
     * @author navigator: 
	 */
	public void fileWriteHighScore(String filename) {
		PrintStream stream = null;
		try
		{
			stream = new PrintStream(filename);
			ArrayList<String> al = getHighScoreFile(filename);
			ArrayList<Player_024_055> p = this.getPlayers();
			sort1(p); //sorts order by score in current scrabble game
			if(al.size()==0) //if empty file just print the in order of p
			{
				for(int i=0; i<p.size();i++) //highest score on top
				{
					stream.format("%s:%d \n",p.get(i).getName(),p.get(i).getScore());
				}
			}
			else
			{
				for(int x=0;x<p.size();x++) // checks player score
				{
					for(int y=0;y<al.size();y++) // with current score so sorted properly
					{
						if(convertInt(al.get(y))<p.get(x).getScore())
						{
							al.add(y,p.get(x).getName()+":" +p.get(x).getScore());
						}
						else
						{
							al.add(p.get(x).getName()+":" +p.get(x).getScore());
						}
					}
				}
				if(al.size()<=20)
				{
					for(int i=0;i<al.size();i++) // print out everything added
					{
						stream.format("%s \n",p.get(i));
					}
				}
				else
				{
					int num = al.size()-20;
					for(int i=0;i<al.size()-num;i++) // print out everything added
					{
						stream.format("%s \n",p.get(i));
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
	/**
	 * sorts the Arraylist of player according to their scores
	 * Makes descending order of scores so highest score on top
	 * @param al Arraylist of players of scrabble game
	 * @author    driver: rockylia (Rocky Liao)
     * @author navigator: 
	 */
	private static void sort1(ArrayList<Player_024_055> al)
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
			Player_024_055 temp = al.get(i);
			al.set(i,al.get(pos));
			al.set(pos, temp);
		}	
	}
	/**
	 * Takes the score from the string
	 * @param s String with a number in it
	 * @return The number as an int 
	 * @author    driver:rockylia (Rocky Liao)
     * @author navigator: 
	 */
	private static int convertInt(String s)
	{
		int begin=0;
		int score=0;
		String scoreString ="";
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i)==':')
			{
				begin=i;
			}
		}
		for(int j=begin+1;j<s.length();j++)
		{
			scoreString = scoreString + s.charAt(j);
		}
		score = Integer.parseInt(scoreString);
		return score;
	}
	/**
	 * Gets all the lines in the file and stores them into an arraylist
	 * @param filename name of file
	 * @return string arraylist of each line in the file
	 * @author    driver:rockylia (Rocky Liao)
     * @author navigator: 
	 */
	public ArrayList<String> getHighScoreFile(String filename)
	{
		Scanner scan = null;
		ArrayList<String> str = new ArrayList<String>();
		try {
			scan = new Scanner(new File(filename));
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

	public void mark(Tile_024_055 _til, int _row, int _col) {


	}
	/**
	 * gets the board of the current scrabble game
	 * @return the board
	 * @author    driver:
     * @author navigator: 
	 */
	public Board_024_055 getBoard(){
		return _board;
	}


}
