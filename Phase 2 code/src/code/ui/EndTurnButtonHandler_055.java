package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurnButtonHandler_055 implements ActionListener {
	/**
	 *  An Instance variable of the Scrabble game UI
	 */
	private ScrabbleUI_055 _s;
	/**
	 * constructor for SubmitButtonHandler
	 * @param s Scrabble game UI
	 * * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public EndTurnButtonHandler_055(ScrabbleUI_055 s){
		_s =s;
	}
	/**
	 * completes/ends the player's move
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		_s.getCurrentPlayer().moveComplete();
		_s.moveComplete();
	}

}
