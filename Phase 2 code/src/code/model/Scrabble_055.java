package code.model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
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
	 * locations of occupied spaces on board
	 */
	private ArrayList<Integer> _locationList;
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
		_locationList = new ArrayList<Integer>();
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
		_locationList = new ArrayList<Integer>();
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
	 *  @author driver: adhishch (Adhish Chugh)
	 *  
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
	 * @param args Array of Strings
	 *  @author driver: adhishch (Adhish Chugh)
	 *  
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


	/**
	 * gets the board of the current scrabble game
	 * @return the board
	 * @author    driver: adhishch (Adhish Chugh)
	 * @author navigator: 
	 */
	public Board_024_055 getBoard(){
		return _board;
	}
	/**
	 * check the words
	 * @return the array list of integer
	 * @author driver: fzhao2 (Feng Zhao)
	 * @author navigator: rockylia (Rocky Liao)
	 */
	public boolean checkVaild() {
		int num =_locationList.size();
		// Finds location of new tiles
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				if (!_board.getTile(x, y).equals(null)) {
					_locationList.add((x * 20) + y);
				}
			}
		}	
		String s = direction(_locationList,num);
		if(s.equals(""))
		{
			return false;
		}
		return true;
	}
	/**
	 * gets the direction of the word to determine what the word is based on the tiles from
	 * num to a.size()
	 * @param a arraylist of integers on board
	 * @param num when to start in arraylist a
	 * @return direction of the word.
	 *  @author driver: rockylia (Rocky Liao)
	 * @author navigator: fzhao2 (Feng Zhao)
	 */
	public String direction(ArrayList<Integer> a, int num)
	{
		String str ="";
		int n=0;
		for (int z = num; z < a.size() - 1; z++)
		{
			while(n!=20)
			{
				if(a.contains(n * 20) && a.contains(19 + n * 20))
				{
					str="thor";
					break;
				}
				if(a.contains(n) && a.contains(380 + n))
				{
					str="tver";
					break;
				}

			}
			if (a.get(z + 1) - a.get(z) == 1 ) {
				str="hor";
				break;
			}
			if (a.get(z + 1) - a.get(z) == 20) {
				str="ver";
				break;
			}
		}
		return str;
	}
	/**
	 * Every time one player ends his turn, this method saves the data to a string
	 * that contains players' name, score and tilerack, inventory and board.
	 * @author czhang43(Cheng Zhang)
	 * @return A string that contains players' name, score and tilerack, inventory and board.
	 */
	public String tempSave() {
		String s = "";
		for(int i = 0; i < _players.size();i++){
			s += _players.get(i).getName() + ",";
			s += Integer.toString(_players.get(i).getScore()) + ",";
			for(int j = 0; j < 12; j++){
				s += _players.get(i).getTileRack().getTile(j).getChar();
			}
			s += ",";
		}
		s += "\n";
		for(int i = 0; i < _inv.getSize(); i++){
			s += _inv.getInventory().get(i).getChar();
		}
		s += "\n";
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				if(_board.isEmpty(i, j)){
					s += "-";
				}
				else{ 
					s += "(" + _board.getTile(i, j).getChar() + ",";
					s +=_board.getTile(i, j).getPlayer().getName() + ")";
				}
			}
			s += "\n";
		}

		return s;
	}
	/**
	 * This method is responsible for players to load the game.
	 * @author czhang43(Cheng Zhang)
	 * @param s
	 */
	
	public void restore(String s) {
		ArrayList<String> players = new ArrayList<String>();
		String str = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ','){
				players.add(str);
				str = "";
			}
			str += s.charAt(i);
			
			if(s.charAt(i) == '\n'){
				s = s.substring(i+1);
				break;
			}
		}
		// All players' score and tileRack are reseted.
		TileRack_024_055 tileRack = new TileRack_024_055(_inv);
		for(int i = 0; i < players.size(); i+= 3){
			for(int j = 0; j < this.getPlayers().size(); j++){
				if(players.get(i).equals(this.getPlayers().get(j))){
					this.getPlayers().get(j).setScore(Integer.getInteger(players.get(i+1)));
					for(int k = 0; k < 12; k++){
						tileRack.addTile(new Tile_024_055(players.get(i+2).charAt(k), getValue(players.get(i+2).charAt(k))));
					}
					this.getPlayers().get(j).setTileRack(tileRack);
					tileRack = new TileRack_024_055(_inv);
				}
			}
		}
		// Reset the inventory.
		String inventory = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '\n'){
				s = s.substring(i+1);
				break;
			}
			inventory += s.charAt(i);
		}
		Inventory_024_055 inv = new Inventory_024_055();
		for(int i = 0; i < inventory.length(); i++){
			inv.addTile(new Tile_024_055(s.charAt(i),getValue(s.charAt(i))));
		}
		this.setInventory(inv);
		
		//Reset the board.
		int oldIndex = 0;
		int newIndex = 0;
		int row = 0;
		ArrayList<String> oneRow = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '-'){
				oneRow.add(""+s.charAt(i));
			}
			if(s.charAt(i) == '('){
				oldIndex = i+1;
			}
			if(s.charAt(i) == ')'){
				newIndex = i-1;
				oneRow.add(s.substring(oldIndex, newIndex));
			}
			if(s.charAt(i) == '\n'){
				for(int j = 0; j < 20; j++){
					if(!oneRow.get(i).equals("-") && this.getBoard().getBoard()[row][j].getValue() != 0){
						this.getBoard().getBoard()[row][j] = new Tile_024_055(oneRow.get(j).charAt(1),getValue(oneRow.get(j).charAt(1)));
						for(int k = 0; k < _players.size(); k++){
							if(oneRow.get(j).substring(2).equals(_players.get(k))){
							this.getBoard().getBoard()[row][j].setColor(_players.get(k).getColor());
							}
						}
					}
				}
				oneRow.clear();
				row += 1;
			}
		}
		
		
	}
	/**
	 * This method is responsible for get the value of the letter based on the letter.
	 * @author czhang43(Cheng Zhang)
	 * @param c
	 * @return the value
	 */
	private int getValue(char c) {
		int value = 0;
		if ((c == 'A')||(c == 'E')||(c == 'I')||(c == 'O')||(c =='U')){
			value = 1;
		}
		else if (c == 'Y'){
			value = 2;
		}
		else{
			value = 5;
		}
		return value;
	}
	/**
	 * This method is responsible for setting the inventory.
	 * @author czhang43(Cheng Zhang)
	 * @param inventory
	 */
	public void setInventory(Inventory_024_055 inventory){
		_inv = inventory;
	}
}
