package code.model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

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

	private String _pathOfDictionary;
	private String _pathOfRestoreFile;
	private ArrayList<String> _nameOfPlayers;

	/**
	 * Class constructor
	 */
	public Scrabble(int n, ArrayList<String> players){
		_inv = new Inventory();
		_board = new Board();
		for(int i = 0; i<players.size(); i++){
			addNewPlayer(_inv, players.get(i));
		}


	}
	
	public Scrabble(){
		_inv = new Inventory();
		_board = new Board();
		for(int i = 1; i<3; i++){
			addNewPlayer(_inv, "Player " + i);
		}
	}

	/**
	 * Adds a new player to the game.
	 */
	private void addNewPlayer(Inventory inv,String name){
		_players.add(new Player(inv, name));
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
			_numberOfPlayers = Integer.parseInt(args[1]);
			String nameOfPlayers = args[2];
			String word = "";
			ArrayList<String> arrayOfWords = new ArrayList<String>();
			for(int i = 0; i<nameOfPlayers.length(); i++){
				char c = nameOfPlayers.charAt(i);
				if(c=='\n' || c=='\t' || c == ' '){
					arrayOfWords.add(word);
					word = "";
				}
				else{
					word = word + c;
				}
			}
			_nameOfPlayers = arrayOfWords;
			new Scrabble(_numberOfPlayers, _nameOfPlayers);

		}


	}
}
