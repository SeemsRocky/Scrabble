package code.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import code.model.Player;
import code.model.Scrabble;
import code.model.Tile;

public class RackButtonHandler implements ActionListener {
	private Player _tileRackPlayer;
	private Player _currentPlayer;
	private Scrabble _s;
	private int _tileRackIndex;
	private ScrabbleUI _scrabbleUI;
	public RackButtonHandler(Scrabble s, int tileRackIndex, ScrabbleUI scrabbleUI, Player tileRackPlayer, Player currentPlayer){
		
	_s = s;
	_tileRackIndex = tileRackIndex;
	_scrabbleUI = scrabbleUI;
	_tileRackPlayer = tileRackPlayer;
	_currentPlayer = currentPlayer;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(!(_tileRackPlayer.getColor().equals(_currentPlayer.getColor()))){
//			JDialog j = new JDialog();
//			j.getContentPane().add(new JLabel("You can't do that. That's not your TileRack"));
//			j.setSize(400, 200);
//			j.setLocation(300, 300);
//			j.setVisible(true);
//			j.isAlwaysOnTop();
//		}
		_scrabbleUI.setCurrentlyPressedTile(_currentPlayer.getTileRack().getTile(_tileRackIndex));
		_scrabbleUI.setIndexOfButton(_tileRackIndex);
//		System.out.println(_scrabbleUI.getCurrentlyPressedTile());
		
	}
	public int tileRackIndex(){
		return _tileRackIndex;
	}

}
