package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.model.Scrabble_055;

public class BoardButtonHandler_055 implements ActionListener {
	private Scrabble_055 _s;
	private ScrabbleUI_055 _sUI;
	private int _x;
	private int _y;
	public BoardButtonHandler_055(Scrabble_055 s, ScrabbleUI_055 sUI, int x, int y){
		_s =s;
		_sUI = sUI;
		_x =x;
		_y =y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(_s.getBoard().isEmpty(_x, _y));
		System.out.println(_sUI.getCurrentlyPressedTile());
		if(_sUI.getCurrentlyPressedTile()==null){
			
		}
		else{
			_sUI.getCurrentPlayer().placeATileOnTheBoard(_x, _y, _sUI.getIndexOfButton());
			_sUI.setCurrentlyPressedTile(null);
		}
		
		
		
	}

}
