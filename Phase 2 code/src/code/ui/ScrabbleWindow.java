package code.ui;
import java.awt.*;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.model.Scrabble;



public class ScrabbleWindow implements Observer, Runnable{

	private Scrabble _scrabble;
	private ArrayList<JButton> _buttons;
	
	public ScrabbleWindow() {
		_scrabble = new Scrabble();
		_scrabble.addObserver(this);
		_buttons = new ArrayList<JButton>();
	}
	
	@Override
	public void run() {
		JFrame window = new JFrame("Scrabble");
        window.setBounds(10, 10, 2000, 1000);
         
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JPanel p = new JPanel();
        p.setSize(40, 40);
        p.setLayout(new GridLayout(20, 20, 0, 0));
         
        for (int i = 0; i < 400; i++) {
            JButton b = new JButton("Letter");
            p.add(b);
             
        }
        JPanel q = new JPanel();
     
         
 
         
         
        container.add(p);
        container.add(q);
         
        window.add(container);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new ScrabbleWindow());
	}


}
