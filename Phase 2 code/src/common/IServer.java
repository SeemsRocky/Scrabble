package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The IServer interface specifies method(s) that
 * are available remotely.
 * 
 * In this example there are three methods
 * that a client can call on the server.
 * 
 */
public interface IServer extends Remote {
	
	public static final String SERVER_REGISTRY_KEY = "Player";

	/**
	 * Registers IClient c as an observer of changes on the server.
	 * @param c
	 * @throws RemoteException
	 */
	public void addIClient(IClient c) throws RemoteException;
	

	/**
	 *  This method is responsible for a player to update the game state
	 *  when he finishes his turn.
	 *  @author czhang43(Cheng Zhang)
	 * @throws RemoteException
	 */


	public void endTurn() throws RemoteException;
	/**
	 * A accsssor method returns the game state that saved as a string.
	 * @author czhang43(Cheng Zhang) 
	 * @param c
	 * @return The game state that saved as a string
	 * @throws RemoteException
	 */

	public String getString(IClient c) throws RemoteException;
}
