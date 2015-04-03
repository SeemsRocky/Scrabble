package code.model;

import java.util.ArrayList;
import java.util.Observable;

public class ScabbleModel extends Observable {
	
	private Player[][] _board;
	private ArrayList<Player> _players;

	public ScabbleModel() {
		_board = new Player[20][20];
	
		
	}
	
	public void switchPlayers() {
		
	}
}
