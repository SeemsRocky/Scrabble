package code.ui;

import java.awt.event.ActionEvent;
/**
 * @author    driver:
 * @author navigator: 
 */
import java.awt.event.ActionListener;

import code.model.Scrabble_055;

public class SaveButtonHandler implements ActionListener {
	private Scrabble_055 _s;
	public SaveButtonHandler(Scrabble_055 s){
		_s = s;
	}
	/**
	 * @author    driver:
     * @author navigator: 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_s.saveToFile("src/code/model/save.txt");
	}

}
