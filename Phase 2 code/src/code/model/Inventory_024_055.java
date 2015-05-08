package code.model;

import java.util.ArrayList;
import java.util.Random;

public class Inventory_024_055 {
	
	/**
	 * An instance variable of type ArrayList<Tile> that stores the tiles in the Inventory
	 */
	private ArrayList<Tile_024_055> _tileBag;
	
	/**
	 * Constructor of the Inventory class which fills up the _tileBag ArrayList with 400 required tiles
	 * by calling the fillBag() method
	 */
	public Inventory_024_055(){
		_tileBag = new ArrayList<Tile_024_055>();
		fillBag();
	}
	
	/**
	 * Fills the inventory of tiles with the correct number of tiles on creation.
	 */
	private void fillBag() {
		for (int i = 'A'; i <= 'Z'; i = i + 1){
			// Create 29 of each vowel with point value 1
			if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
				for (int j = 0; j < 29; j++){
					_tileBag.add(new Tile_024_055((char)i,1));
				}
			}
			// Create 15 y's with point value 2
			else if (i == 'Y'){
				for (int j = 0; j < 15; j++){
					_tileBag.add(new Tile_024_055((char)i,2));
				}
			}
			// Create 12 of every other letter with point value 5
			else{
				for (int j = 0; j < 12; j++){
					_tileBag.add(new Tile_024_055((char)i,5));
				}
			}
		}
	}

	/**
	 * Pulls a single random tile from the inventory.
	 * 
	 * @return the random tile that was removed
	 */
	public Tile_024_055 removeRandomTile(){
		int randomIndex = new Random().nextInt(_tileBag.size());
		return _tileBag.remove(randomIndex);
	}
	
	/**
	 * Returns number of tiles in the tile bag.
	 * 
	 * @return the size of the ArrayList containing the tiles
	 */
	public int getSize(){
		return _tileBag.size();
	}
	
	/**
	 * Returns the tile at a specific index.
	 * 
	 * @param i index of the tile bag array list
	 * @return tile at index i
	 */
	public Tile_024_055 getTile(int i){
		return _tileBag.get(i);
	}
	/**
	 * 
	 * @return ArrayList consisting of all the Tiles associated to a Character and its corresponding value
	 * @author    driver: adhishch (Adhish Chugh) 
	 */
	public ArrayList<Tile_024_055> getInventory(){
		return _tileBag;
	}
	/**
	 * This method is responsible for adding tiles to the inventory.
	 * @author czhang43(Cheng Zhang)
	 */
	public void addTile(Tile_024_055 tile){
		_tileBag.add(tile);
	}
}
