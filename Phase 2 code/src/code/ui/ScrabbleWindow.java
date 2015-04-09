package code.ui;

import java.awt.*;
import java.util.*;
import javax.swing.*;


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
//		window.setMinimumSize(new Dimension(800, 800));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();

		JPanel player1 = new JPanel();
		JPanel player2 = new JPanel();
		JPanel player3 = new JPanel();
		JPanel player4 = new JPanel();

		JPanel sp1 = new JPanel();
		JPanel sp2 = new JPanel();
		JTextField name1 = new JTextField("name");
		JTextField name2 = new JTextField("name");
		JTextField name3 = new JTextField("name");
		JTextField name4 = new JTextField("name");

		JTextField score1 = new JTextField("score");
		JTextField score2 = new JTextField("score");
		JTextField score3 = new JTextField("score");
		JTextField score4 = new JTextField("score");
		JTextField highest = new JTextField("Highest Score");

//		JColorChooser cc = new JColorChooser();
		
		
		player1.add(name1, BorderLayout.EAST);
		player1.add(score1,BorderLayout.CENTER);
		player2.add(name2, BorderLayout.EAST);
		player2.add(score2,BorderLayout.CENTER);
		player3.add(name3, BorderLayout.EAST);
		player3.add(score3,BorderLayout.CENTER);
		player4.add(name4, BorderLayout.EAST);
		player4.add(score4,BorderLayout.CENTER);
		
		
		p1.setSize(400, 400);
		p1.setBackground(Color.CYAN);
		p1.setLayout(new GridLayout(20, 20, 4, 4));
		p2.setBackground(Color.BLUE);
		p2.setLayout(new GridLayout(4, 3, 1, 1));
		p3.setSize(400, 100);
		p3.setBackground(Color.DARK_GRAY);
		sp1.setLayout(new GridLayout(1, 2, 0, 0));

		/*
		 * For Save and Open button
		 */
		JButton save = new JButton("save");
		JButton open = new JButton("open");
		save.setBackground(Color.ORANGE);
		open.setBackground(Color.ORANGE);
		

		sp1.setBackground(Color.BLACK);
		sp2.setBackground(Color.GREEN);
		sp2.add(highest, BorderLayout.SOUTH);
		p3.add(sp1, BorderLayout.SOUTH);
		p3.add(sp2, BorderLayout.CENTER);
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
			JButton tb1 = new JButton("y");	
			p2.add(player1, BorderLayout.WEST);
			p2.add(tb1);
			
			tb1.addActionListener(new ButtonHandler(i, _scrabble));
		} 	
		for (int i = 0; i < 12; i++) {
			JButton tb2 = new JButton("y");	
			p2.add(player2, BorderLayout.WEST);
			p2.add(tb2);
			tb2.addActionListener(new ButtonHandler(i, _scrabble));
		} 	

		for (int i = 0; i < 12; i++) {
			JButton tb3 = new JButton("y");	
			p2.add(player3, BorderLayout.WEST);
			p2.add(tb3);
			tb3.addActionListener(new ButtonHandler(i, _scrabble));
		} 	

		for (int i = 0; i < 12; i++) {
			JButton tb4 = new JButton("y");	
			p2.add(player4, BorderLayout.WEST);
			p2.add(tb4);
			tb4.addActionListener(new ButtonHandler(i, _scrabble));
		} 	


		
//		window.setLayout(new BorderLayout());
		


		
		window.add(p1, BorderLayout.WEST);
		window.add(p2, BorderLayout.SOUTH);
		window.add(p3, BorderLayout.CENTER);
	
		
		
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		window.setBackground(Color.RED);


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