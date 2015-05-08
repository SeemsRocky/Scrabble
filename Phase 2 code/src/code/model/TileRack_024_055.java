package code.model;

import java.util.ArrayList;
import java.util.Observable;

public class TileRack_024_055 extends Observable {
	
	/**
	 * Inventory to draw tiles from
	 */
	private Inventory_024_055 _inv;
	
	/**
	 * Stores the tiles that can be played.
	 */
	private ArrayList<Tile_024_055> _rack;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv inventory to draw tiles from
	 */
	public TileRack_024_055(Inventory_024_055 inv){
		_inv = inv;
		_rack = new ArrayList<Tile_024_055>();
		fillRack();
	}
	
	/**
	 * Fills tile rack to maximum capacity of 12
	 */
	public void fillRack(){
		while (_rack.size() < 12){
			_rack.add(_inv.removeRandomTile());
		}
	}
	
	/**
	 * Removes a tile from rack.
	 * 
	 * @param t tile to be removed from the rack
	 * @return tile removed from the rack
	 */
	public Tile_024_055 removeTile(Tile_024_055 t){
		Tile_024_055 tileToRemove = t;
		_rack.remove(t);
        setChanged();
        notifyObservers();
		return tileToRemove;
	}
	
	/**
	 * Removes a tile from an index from rack
	 * 
	 * @param i index of tile to be removed
	 * @return tile removed from the rack
	 */
	public Tile_024_055 removeTile(int i){
		Tile_024_055 tileToRemove = _rack.get(i);
		_rack.remove(i);
		return tileToRemove;
	}

	/**
	 * Gets size of the tile rack
	 * 
	 * @return size of the tile rack
	 */
	public int getSize() {
		return _rack.size();
	}
	/**
	 * This method creates an ArrayList of all the tiles in a TileRack
	 * @return ArrayList of all the tiles in a TileRack
	 */
	
	public ArrayList<Tile_024_055> getTiles(){
		return _rack;
		
	}
	/**
	 * Returns the tile at indexTileRack on the tilerack
	 * @param indexTileRack is the index at which the desired tile to get is
	 * @return Tile at index indexTileRack
	 */

	public Tile_024_055 getTile(int indexTileRack) {
		// TODO Auto-generated method stub
		return _rack.get(indexTileRack);
	}
	/**
	 * Adds tile t to the rack
	 * @param t is the Tile to be added
	 */
	
	public void addTile(Tile_024_055 t){
		_rack.add(t);	
	}
}
