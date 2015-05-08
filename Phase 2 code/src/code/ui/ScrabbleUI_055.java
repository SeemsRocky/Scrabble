package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import common.IClient;
import common.IServer;
import code.model.Board_024_055;
import code.model.Player_024_055;
import code.model.Scrabble_055;
import code.model.Tile_024_055;
/**
 * @author    driver:adhishch (Adhish Chugh)
 * @author navigator: 
 *
 */
public class ScrabbleUI_055 implements Observer, Runnable, IClient {
	/**
	 * Scrabble game
	 */
	private Scrabble_055 _scrabble;
	/**
	 * Current player's turn
	 */
	private Player_024_055 _currentPlayer;
	/**
	 * Tile that is currently pressed
	 */
	private Tile_024_055 _currentlyPressedTile;
	/**
	 * arraylist of players in scrabble game
	 */
	private ArrayList<Player_024_055> _myPlayers;
	/**
	 * Double array of Jbuttons for the board
	 */
	private JButton[][] _dAOfButtons;
	/**
	 * buttons for the tilerack
	 */
	private JButton[][] _tileRackButtons;
	/**
	 * index of button on the tilerack
	 */
	private int _indexOfButton;
	/**
	 * Current player's label
	 */
	private JLabel _currentPlayerLabel;
	
	private IServer _server;
	/**
	 * Scrabble UI constructor with default scrabble game with 2 players
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public ScrabbleUI_055(IServer s, String hostName, int portNumber){
		_scrabble = new Scrabble_055();

		_myPlayers =_scrabble.getPlayers();
		_currentPlayer = _myPlayers.get(0);

		_dAOfButtons = new JButton[_scrabble.getBoard().getWidth()][_scrabble.getBoard().getLength()];
		_tileRackButtons = new JButton[_myPlayers.size()][12];
		_currentPlayer.addObserver(this);
		
		_server = s;
		IClient me = null;
		try {
			boolean retry = false;
			do {
				try {
					me = (IClient) UnicastRemoteObject.exportObject(this,portNumber);
					retry = false;
				}
				catch (ExportException e) {
					if (hostName.equals("localhost")) {
						System.out.print("Port "+portNumber+" is unavailable, trying ");
						portNumber++;
						System.out.println(portNumber);
						retry = true;
					}
					else {
						System.out.print("Port "+portNumber+" is unavailable.");
						e.printStackTrace();
						System.exit(1);
					}
				}
			} while (retry);

		} catch (RemoteException e) {
			System.err.println("[CLIENT] Could not export self.");
			e.printStackTrace();
			System.exit(1);
		}
		try {
			_server.addIClient(me);
		} catch (RemoteException e) {
			System.err.println("[CLIENT] Could not register with remote server.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	/**
	 * Constructor for new Scrabble Game UI with a list with name of the players
	 * @param names arraylist of string for player names
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public ScrabbleUI_055(ArrayList<String> names){
		_scrabble = new Scrabble_055(names);
		_myPlayers =_scrabble.getPlayers();
		_currentPlayer = _myPlayers.get(0);

		_dAOfButtons = new JButton[_scrabble.getBoard().getWidth()][_scrabble.getBoard().getLength()];
		_tileRackButtons = new JButton[_myPlayers.size()][12];
		_currentPlayer.addObserver(this);
	}
/**
 * runs a new scrabble game on a window with a board and player's name,tilerack,score
 * @author    driver:adhishch (Adhish Chugh)
 * @author navigator: 
 */
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
					myButton.addActionListener(new BoardButtonHandler_055(_scrabble, this, i, j));

					_dAOfButtons[i][j]=myButton;
					top.add(_dAOfButtons[i][j]);
				}
				else{
					//					System.out.println(_scrabble.getBoard().getTile(i, j).toString());
					JButton myButton = new JButton(_scrabble.getBoard().getTile(i, j).toString());
					myButton.setPreferredSize(new Dimension(25,25));
					myButton.addActionListener(new BoardButtonHandler_055(_scrabble, this, i, j));
					_dAOfButtons[i][j]=myButton;
					top.add(_dAOfButtons[i][j]);
				}

			}

			topPanel.add(top);
		}
		window.add(topPanel, BorderLayout.WEST);

		JPanel playerInfo = new JPanel();
		_currentPlayerLabel = new JLabel("Turn:"+_currentPlayer.getName());
		playerInfo.setLayout(new BoxLayout(playerInfo, BoxLayout.Y_AXIS));
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveButtonHandler_055(_scrabble));
		playerInfo.add(saveButton);
		JButton endTurnButton = new JButton("End Turn");
		saveButton.addActionListener(new EndTurnButtonHandler_055(this, _server));
		playerInfo.add(endTurnButton);
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
				myButton.setForeground(_scrabble.getPlayers().get(i).getColor());
				myButton.setPreferredSize(new Dimension(25,25));
				myButton.addActionListener(new RackButtonHandler_055(_scrabble, j, this,_scrabble.getPlayers().get(i),_currentPlayer));
				_tileRackButtons[i][j] = myButton;
				playerPanel.add(_tileRackButtons[i][j]);
			}

			playerInfo.add(playerPanel);
		}
		window.add(playerInfo, BorderLayout.EAST);




		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}
/**
 * updates the UI
 * @author    driver:adhishch (Adhish Chugh)
 * @author navigator: 
 */
	@Override
	public void update(Observable o, Object arg) {

		for(int i= 0;i<_scrabble.getBoard().getWidth(); i++){
			for(int j=0; j<_scrabble.getBoard().getLength(); j++){
				Scrabble_055 __s = _scrabble;
				Board_024_055 __b = __s.getBoard();
//				System.out.println("Trying to get Tile at location ("+i+","+j+")");
				Tile_024_055 __t = __b.getTile(i, j);
//				System.out.println("__t has value "+__t);
				String  __v = null;
				if (__t == null) {
					__v = " ";
				}
				else {
					__v = __t.toString();
				}
				_dAOfButtons[i][j].setText(__v);

			}
		}
		int sizeOfRack = _currentPlayer.getTileRack().getSize();
		System.out.println(sizeOfRack);
		for(int i=0; i<sizeOfRack; i++){
			System.out.println(_currentPlayer.getTileRack().getTile(i).toString());
			_tileRackButtons[0][i].setText(_currentPlayer.getTileRack().getTile(i).toString());
		}
		
		for(int k =sizeOfRack; k<12;k++){
			_tileRackButtons[0][k].setText(" ");
		}
		_currentPlayerLabel.setText("Turn: "+_currentPlayer.getName());
	}

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new ScrabbleUI_055(null));
//	}
	/**
	 * sets the currently pressed tile
	 * @param b the tile pressed
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public void setCurrentlyPressedTile(Tile_024_055 b){
		_currentlyPressedTile = b;
	}
	/**
	 * gets the tile that was most recently pressed on the rack
	 * @return the tile currently pressed
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public Tile_024_055 getCurrentlyPressedTile(){
		return _currentlyPressedTile;
	}
	/**
	 * gets the current player playing
	 * @return the current player playing
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public Player_024_055 getCurrentPlayer(){
		return _currentPlayer;
	}
	/**
	 * sets the index of button to i
	 * @param i new index to change to
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public void setIndexOfButton(int i){
		_indexOfButton = i;
	}
	/**
	 * gets the index of the button
	 * @return index of the button
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public int getIndexOfButton(){
		return _indexOfButton;
	}
	/**
	 * ends the turn of the player
	 * * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public void moveComplete(){
		int pos = _myPlayers.indexOf(_currentPlayer);
		if(_currentPlayer.equals(_myPlayers.get(_myPlayers.size()-1)))
		{
			_currentPlayer = _myPlayers.get(0);
		}
		else
		{
			_currentPlayer = _myPlayers.get(pos+1);
		}
		
	}
	/**
	 * This method is responsible for a player to update the game state.
	 * @author czhang43(Cheng Zhang)
	 */
	@Override
	public void update() throws RemoteException {
		try {
			_scrabble.restore(_server.getString(this));
		} catch (RemoteException exc) {
			System.err.println("Couldn't connect to server.");
			exc.printStackTrace();
		}
		
	}
	/**
	 * This method just call a method in _Scrabble to save the game state.
	 * @author czhang43(Cheng Zhang)
	 */
	@Override
	public String tempSave() throws RemoteException {
		return _scrabble.tempSave();
	}
}
