package code.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import code.model.Player_024_055;
import code.model.Scrabble_055;
import code.model.Tile_024_055;
/**
 * 
 * @author    driver: adhishch(Adhish Chugh)
 * @author navigator: 
 *
 */
public class RackButtonHandler_055 implements ActionListener {
	/**
	 * player's tile rack
	 */
	private Player_024_055 _tileRackPlayer;
	/**
	 * current player
	 */
	private Player_024_055 _currentPlayer;
	/**
	 * scrabble game
	 */
	private Scrabble_055 _s;
	/**
	 * index of tile in the tilerack
	 */
	private int _tileRackIndex;
	/**
	 * the Scrabble game UI
	 */
	private ScrabbleUI_055 _scrabbleUI;
	/**
	 * constructor for rackbuttonhandler
	 * @param s scrabble game
	 * @param tileRackIndex index of desired tile in tilerack
	 * @param scrabbleUI Scrabble game UI
	 * @param tileRackPlayer Player's tile rack
	 * @param currentPlayer The current player
	 */
	public RackButtonHandler_055(Scrabble_055 s, int tileRackIndex, ScrabbleUI_055 scrabbleUI, Player_024_055 tileRackPlayer, Player_024_055 currentPlayer){
		
	_s = s;
	_tileRackIndex = tileRackIndex;
	_scrabbleUI = scrabbleUI;
	_tileRackPlayer = tileRackPlayer;
	_currentPlayer = currentPlayer;
	
	}
/**
 * If the tilerack is not the current player's, it doesn't allow them to play that tile
 * else it gets the currentlypressed tile and sets the button the current index of tilerack
 * @author    driver:adhishch(Adhish chugh)
 * @author navigator: 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!(_tileRackPlayer.getColor().equals(_currentPlayer.getColor()))){
			JDialog j = new JDialog();
			j.getContentPane().add(new JLabel("You can't do that. That's not your TileRack"));
			j.setSize(400, 200);
			j.setLocation(300, 300);
			j.setVisible(true);
			j.isAlwaysOnTop();
		}
		else{
			_scrabbleUI.setCurrentlyPressedTile(_currentPlayer.getTileRack().getTile(_tileRackIndex));
			_scrabbleUI.setIndexOfButton(_tileRackIndex);
			System.out.println(_scrabbleUI.getCurrentlyPressedTile());
		}
		
		
	}
	/**
	 * gets the index of the tile in the tilerack
	 * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 * @return An int representing the index of a tile rack
	 */
	public int tileRackIndex(){
		return _tileRackIndex;
	}

}
