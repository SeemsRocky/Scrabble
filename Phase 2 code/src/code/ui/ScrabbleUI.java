package code.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.model.Scrabble;

public class ScrabbleUI implements Observer, Runnable {
	private Scrabble _scrabble;
	
	public ScrabbleUI(){
		_scrabble = new Scrabble();
		
	}

	@Override
	public void run() {
		JFrame window = new JFrame("Scrabble");
		
		window.setSize(30*_scrabble.getBoard().getWidth()+600,30*_scrabble.getBoard().getLength()+200);

		window.setResizable(false);

		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.setSize(30*_scrabble.getBoard().getWidth()+20,30*_scrabble.getBoard().getLength());
		for(int i = 0; i<_scrabble.getBoard().getWidth(); i++){
			JPanel top = new JPanel();
			for(int j=0; j<_scrabble.getBoard().getLength(); j++){
				
				if(_scrabble.getBoard().isEmpty(i, j)){
					JButton myButton = new JButton();
					myButton.setPreferredSize(new Dimension(25,25));
					top.add(myButton);
				}
				else{
					JButton myButton = new JButton(_scrabble.getBoard().getTile(i, j).toString());
					myButton.setPreferredSize(new Dimension(25,25));
					top.add(myButton);
				}
					
			}
            
			topPanel.add(top);
		}
		window.add(topPanel, BorderLayout.WEST);
		
		JPanel playerInfo = new JPanel();
		playerInfo.setLayout(new BoxLayout(playerInfo, BoxLayout.Y_AXIS));
		JButton saveButton = new JButton("Open");
		playerInfo.add(saveButton);
		for(int i=0; i<_scrabble.getPlayers().size();i++){
			JPanel playerPanel = new JPanel();
			JLabel playerName = new JLabel(_scrabble.getPlayers().get(i).getName());
			playerName.setForeground(_scrabble.getPlayers().get(i).getColor());
			playerPanel.add(playerName);
			JLabel playerScore = new JLabel("Score: "+_scrabble.getPlayers().get(i).getScore());
			playerPanel.add(playerScore);
			for(int j=0; j<12; j++){
				JButton myButton = new JButton(_scrabble.getPlayers().get(i).getTileRack().getTile(j).toString());
				myButton.setPreferredSize(new Dimension(25,25));
				playerPanel.add(myButton);
			}

			playerInfo.add(playerPanel);
		}
		window.add(playerInfo, BorderLayout.EAST);

		
		

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ScrabbleUI());
	}

}
