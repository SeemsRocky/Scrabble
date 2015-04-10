package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitButtonHandler_055 implements ActionListener {
	private ScrabbleUI_055 _s;
	public SubmitButtonHandler_055(ScrabbleUI_055 s){
		_s =s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_s.getCurrentPlayer().moveComplete();
		_s.moveComplete();
	}

}
