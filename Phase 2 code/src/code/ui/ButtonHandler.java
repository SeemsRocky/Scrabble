package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.model.ScabbleModel;

public class ButtonHandler implements ActionListener{
	private ScabbleModel _model;
	private int _col;
	private int _row;
	
	public ButtonHandler (int i, ScabbleModel model) {
		_model = model;
		_row = i/20;
		_col = i%20;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
