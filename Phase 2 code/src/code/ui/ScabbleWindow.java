package code.ui;
import java.awt.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.model.ScabbleModel;



public class ScabbleWindow implements Observer, Runnable{

	private ScabbleModel _model;
	private ArrayList<JButton> _buttons;
	
	public ScabbleWindow() {
		_model = new ScabbleModel();
		_model.addObserver(this);
		_buttons = new ArrayList<JButton>();
	}
	
	@Override
	public void run() {
		JFrame window = new JFrame("Scabble");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(20, 20, 0, 0));
		for (int i = 0; i < 400; i++) {
			JButton b = new JButton("Letter");
			p.add(b);
			
		}
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(p);
		window.pack();
		window.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new ScabbleWindow());
	}


}
