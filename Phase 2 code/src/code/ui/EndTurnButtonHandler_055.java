package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import common.IServer;

public class EndTurnButtonHandler_055 implements ActionListener {
	/**
	 *  An Instance variable of the Scrabble game UI
	 */
	private ScrabbleUI_055 _s;
	
	private IServer _server;
	/**
	 * constructor for SubmitButtonHandler
	 * @param s Scrabble game UI
	 * * @author    driver: adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	public EndTurnButtonHandler_055(ScrabbleUI_055 s, IServer server){
		_s =s;
		_server = server;
	}
	/**
	 * completes/ends the player's move
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		_s.moveComplete();
		try {
			_server.endTurn();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
