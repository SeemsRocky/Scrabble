package code;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Tile> _myInventory;
	public Inventory(){
		
		_myInventory = new ArrayList<Tile>(); //creates a new ArrayList for the inventory
		
		for(int i = 0; i < 29; i++){   //adds the vowels 29 times
			String vowels = "AEIOU";
			for(int l = 0; l<vowels.length(); l++){
				char c = vowels.charAt(l);
				_myInventory.add(new Tile(c));
			}
		}
	
		for(int i = 0; i<15; i++){   //adds the letter 'Y' 15 times
			_myInventory.add(new Tile('Y'));
		}
		for(int i = 0; i<12; i++){   //adds the rest of the letters 12 times
			String rest = "BCDFGHJKLMNPQRSTVWXZ";
			for(int l = 0; l<rest.length(); l++){
				char c = rest.charAt(l);
				_myInventory.add(new Tile(c));
			}
			
		}
		Collections.shuffle(_myInventory);   //shuffles the collection so that tiles can be drawn randomy
	}
	public Tile getTile(int i){
		return _myInventory.get(i);  //returns the tile at index i
	}
	public int getSize(){
		return _myInventory.size();  //returns size of the inventory
	}
	public void remove(int i){
		_myInventory.remove(i);      //removes the tile at index i
	}
}
