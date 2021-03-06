package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import common.IClient;
import common.IServer;

/**
 * A simple server that records how many votes are cast.
 */
public class Server implements IServer {
	
	private ArrayList<IClient> _observers;    // A list of observers
	

	public Server() {
	   System.out.println("...server running...");
		_observers = new ArrayList<IClient>();
	}
	
	
	/* (non-Javadoc)
	 * Notify all observers that the state of the server has changed
	 */
	private void notifyObservers() {
		for (IClient c : _observers) {
			// Try to call update() on a remote client
			try {
				c.update();
			}
			// If unable, print error message and stack trace, but keep trying with other
			// clients, which are running on different hosts.
			catch (RemoteException e) {
				System.err.println("[SERVER] Unable to communicate with client.");
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see common.IServer#addIClient(common.IClient)
	 */
	@Override public void addIClient(IClient c) throws RemoteException {
		System.out.println("[SERVER] Adding client");
		_observers.add(c);
	}
	
	
	@Override
	public void endTurn() throws RemoteException {
		notifyObservers();
	}



	@Override
	public String getString(IClient c) throws RemoteException {
		return c.tempSave();
	}
}
