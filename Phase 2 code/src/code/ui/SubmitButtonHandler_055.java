package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitButtonHandler_055 implements ActionListener {
	/**
	 *  scrabble game UI
	 */
	private ScrabbleUI_055 _s;
	/**
	 * constructor for submitbuttonhandler
	 * @param s scrabble game UI
	 * * @author    driver:
     * @author navigator: 
	 */
	public SubmitButtonHandler_055(ScrabbleUI_055 s){
		_s =s;
	}
	/**
	 * completes/ends the player's move
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_s.getCurrentPlayer().moveComplete();
		_s.moveComplete();
	}

}
