package code.ui;

import java.awt.event.ActionEvent;
/**
 * @author    driver:
 * @author navigator: 
 */
import java.awt.event.ActionListener;

import code.model.Scrabble_055;

public class SaveButtonHandler_055 implements ActionListener {
	/**
	 * Scrabble game
	 */
	private Scrabble_055 _s;
	/**
	 * constructor for the savebuttonhandler
	 * @param s scrabble game
	 */
	public SaveButtonHandler_055(Scrabble_055 s){
		_s = s;
	}
	/**
	 * When button is pressed, it saves to the file "src/code/model/save.txt"
	 * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_s.saveToFile("src/code/model/save.txt");
	}

}
