package code.ui;

import java.awt.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import code.model.Scrabble;

public class ScrabbleWindow implements Observer, Runnable {

	private Scrabble _scrabble;
	private ArrayList<JButton> _buttons;

	// public ScrabbleWindow() {
	// _scrabble = new Scrabble();
	// _scrabble.addObserver(this);
	// _buttons = new ArrayList<JButton>();
	// }

	@Override
	public void run() {
		JFrame window = new JFrame("Scabble");
		window.setMinimumSize(new Dimension(800, 800));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		JPanel player1 = new JPanel();
		JPanel player2 = new JPanel();
		JPanel player3 = new JPanel();
		JPanel player4 = new JPanel();

		JPanel sp1 = new JPanel();
		JPanel sp2 = new JPanel();
		JTextField name1 = new JTextField("name");
		JTextField name2 = new JTextField();
		JTextField name3 = new JTextField();
		JTextField name4 = new JTextField();

		JTextField score1 = new JTextField("score");
		JTextField score2 = new JTextField();
		JTextField score3 = new JTextField();
		JTextField score4 = new JTextField();

		JColorChooser cc = new JColorChooser();
		
		
		player1.add(name1, BorderLayout.WEST);
		player1.add(score1,BorderLayout.CENTER);
		
		p1.setSize(400, 400);
		p3.setSize(400, 200);
		p1.setBackground(Color.CYAN);
		p2.setBackground(Color.BLUE);
		p3.setBackground(Color.BLACK);
		p1.setLayout(new GridLayout(20, 20, 4, 4));
		p2.setLayout(new GridLayout(1, 12, 0, 25));
		sp1.setLayout(new GridLayout(1, 2, 0, 0));

		/*
		 * For Save and Open button
		 */
		JButton save = new JButton("save");
		JButton open = new JButton("open");
		save.setBackground(Color.ORANGE);
		open.setBackground(Color.ORANGE);
		

		sp1.setBackground(Color.BLACK);
		sp2.setBackground(Color.BLUE);
		p3.add("WEST", sp1);
		p3.add("CENTER", sp2);
		sp1.add(save);
		sp1.add(open);

		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				JButton b1 = new JButton("x");
				p1.add(b1);
				b1.addActionListener(new ButtonHandler(x, _scrabble));
				b1.addActionListener(new ButtonHandler(y, _scrabble));
			}
			
		}
		for (int i = 0; i < 12; i++) {
			JButton b2 = new JButton("y");
			p2.add(b2);
			b2.addActionListener(new ButtonHandler(i, _scrabble));
		}
		
		
//		window.setLayout(new BorderLayout());
		p2.add(player1, BorderLayout.WEST);
		window.add(p1, BorderLayout.WEST);
		window.add(p2,BorderLayout.SOUTH);
		window.add("Center", p3);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		window.setBackground(Color.BLACK);

	}

	@Override
	public void update(Observable o, Object arg) {
		String s = _scrabble.toString();
		for (int i = 0; i < s.length(); i++) {
			_buttons.get(i).setText("" + s.charAt(i));

		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ScrabbleWindow());
	}

}