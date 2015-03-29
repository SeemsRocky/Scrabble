package code.model;

import java.util.ArrayList;
import java.util.Random;

public class Scrabble {
	
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
		_numberOfPlayers = 4;
		
		for (int i = 0; i < _numberOfPlayers; i++){
			addNewPlayer();
		}
	}
	
	/**
	 * Adds a new player to the game.
	 */
	private void addNewPlayer(){
		_players.add(new Player(_inv));
	}

}
