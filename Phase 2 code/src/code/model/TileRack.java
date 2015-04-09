package code.model;

import java.util.ArrayList;

public class TileRack {
	
	/**
	 * Inventory to draw tiles from
	 */
	private Inventory _inv;
	
	/**
	 * Stores the tiles that can be played.
	 */
	private ArrayList<Tile> _rack;
	
	/**
	 * Class cosntructor.
	 * 
	 * @param inv inventory to draw tiles from
	 */
	public TileRack(Inventory inv){
		_inv = inv;
		_rack = new ArrayList<Tile>();
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
	public Tile removeTile(Tile t){
		Tile tileToRemove = t;
		_rack.remove(t);
		return tileToRemove;
	}
	
	/**
	 * Removes a tile from an index from rack
	 * 
	 * @param i index of tile to be removed
	 * @return tile removed from the rack
	 */
	public Tile removeTile(int i){
		Tile tileToRemove = _rack.get(i);
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
	
	public ArrayList<Tile> gettiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int i=0;i<_rack.size();i++){
			array.add(i,_rack.get(i));
		}
		return array;
		
	}
}
