package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.model.Scrabble_055;
/**
 * @author    driver:adhishch (Adhish Chugh)
 * 
 *
 */
public class BoardButtonHandler_055 implements ActionListener {
	/**
	 * Scrabble game
	 */
	private Scrabble_055 _s;
	/**
	 * Scrabble game UI
	 */
	private ScrabbleUI_055 _sUI;
	/**
	 * X-coordinate on the board
	 */
	private int _x;
	/**
	 * y-coordinate on the board
	 */
	private int _y;
	/**
	 * class constructor
	 * @param s scrabble game
	 * @param sUI scrabble game UI
	 * @param x x-coordinate on board
	 * @param y y-coordinate on board
	 * * @author    driver:adhishch (Adhish Chugh)
     * 
	 */
	public BoardButtonHandler_055(Scrabble_055 s, ScrabbleUI_055 sUI, int x, int y){
		_s =s;
		_sUI = sUI;
		_x =x;
		_y =y;
	}
	/**
	 * 
	 * @author    driver:adhishch (Adhish Chugh)
     *  
	 */

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
