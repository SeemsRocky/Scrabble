package code.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.model.Player;
import code.model.Scrabble;
import code.model.Tile;

public class ScrabbleUI implements Observer, Runnable {
	private Scrabble _scrabble;
	private Player _currentPlayer;
	private Tile _currentlyPressedTile;
	private ArrayList<Player> _myPlayers;
	private JButton[][] _dAOfButtons;
	private int _indexOfButton;
	public ScrabbleUI(){
		_scrabble = new Scrabble();
		_myPlayers = new ArrayList<Player>();
		_myPlayers =_scrabble.getPlayers();
		_currentPlayer = _myPlayers.get(0);
		_dAOfButtons = new JButton[_scrabble.getBoard().getWidth()][_scrabble.getBoard().getLength()];
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
					myButton.addActionListener(new BoardButtonHandler(_scrabble, this, i, j));
					
					_dAOfButtons[i][j]=myButton;
					top.add(_dAOfButtons[i][j]);
				}
				else{
					JButton myButton = new JButton(_scrabble.getBoard().getTile(i, j).toString());
					myButton.setPreferredSize(new Dimension(25,25));
					_dAOfButtons[i][j]=myButton;
					top.add(_dAOfButtons[i][j]);
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
				int value = _scrabble.getPlayers().get(i).getTileRack().getTile(j).getValue();
				String myValue = "";
				myValue = myValue + value;
				myValue = "<html><sub>" + myValue + "</sub></html>";
//				System.out.println(myValue);
				JButton myButton = new JButton(_scrabble.getPlayers().get(i).getTileRack().getTile(j).toString());
				myButton.setPreferredSize(new Dimension(25,25));
				myButton.addActionListener(new RackButtonHandler(_scrabble, j, this,_scrabble.getPlayers().get(i),_currentPlayer));
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
		for(int i= 0;i<_scrabble.getBoard().getWidth(); i++){
			for(int j=0; j<_scrabble.getBoard().getLength(); j++){
			JButton newButton =	new JButton(_scrabble.getBoard().getTile(i, j).toString());
			System.out.println(_scrabble.getBoard().getTile(i, j).toString());
			_dAOfButtons[i][j] = newButton;
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ScrabbleUI());
	}
	
	public void setCurrentlyPressedTile(Tile b){
		_currentlyPressedTile = b;
	}
	public Tile getCurrentlyPressedTile(){
		return _currentlyPressedTile;
	}
   public Player getCurrentPlayer(){
	   return _currentPlayer;
   }
   public void setIndexOfButton(int i){
	   _indexOfButton = i;
   }
   public int getIndexOfButton(){
	  return _indexOfButton;
   }
}
