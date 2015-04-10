package code.ui;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

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
		window.setSize(30*_scrabble.getBoard().getWidth()+20,30*_scrabble.getBoard().getLength()+200);
		
		window.setResizable(false);
		JPanel top = new JPanel();
		
		
		for(int i = 0; i<_scrabble.getBoard().getWidth(); i++){
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
		}
		JPanel bottom = new JPanel();
		for(int i=0; i<_scrabble.getPlayers().size();i++){
			JLabel playerName = new JLabel(_scrabble.getPlayers().get(i).getName());
			playerName.setForeground(_scrabble.getPlayers().get(i).getColor());
			bottom.add(playerName);
			for(int j=0; j<12; j++){
				JButton myButton = new JButton(_scrabble.getPlayers().get(i).getTileRack().getTile(j).toString());
				myButton.setPreferredSize(new Dimension(25,25));
				bottom.add(myButton);
			}
		}
		
		window.add(top);
		window.add(bottom);
		
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
