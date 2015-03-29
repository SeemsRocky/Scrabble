package code.model;

import java.util.ArrayList;
import java.util.Random;

public class Inventory {
	
	/**
	 * Stores the tiles that have yet to be drawn.
	 */
	private ArrayList<Tile> _tileBag;
	
	/**
	 * Class constructor.
	 */
	public Inventory(){
		_tileBag = new ArrayList<Tile>();
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
					_tileBag.add(new Tile((char)i,1));
				}
			}
			// Create 15 y's with point value 2
			else if (i == 'Y'){
				for (int j = 0; j < 15; j++){
					_tileBag.add(new Tile((char)i,2));
				}
			}
			// Create 12 of every other letter with point value 5
			else{
				for (int j = 0; j < 12; j++){
					_tileBag.add(new Tile((char)i,5));
				}
			}
		}
	}

	/**
	 * Pulls a single random tile from the inventory.
	 * 
	 * @return the random tile that was removed
	 */
	public Tile removeRandomTile(){
		int randomIndex = new Random().nextInt(_tileBag.size());
		return _tileBag.remove(randomIndex);
	}
	
	/**
	 * Returns number of tiles in the tile bag.
	 * 
	 * @return the size of the array list containing the tiles
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
	public Tile getTile(int i){
		return _tileBag.get(i);
	}
}
