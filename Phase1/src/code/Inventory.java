package code;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Tile> _myInventory;
	public Inventory(){
		_myInventory = new ArrayList<Tile>();
		for(int i = 0; i < 29; i++){
		String vowels = "AEIOU";
		for(int l = 0; l<vowels.length(); l++){
			char c = vowels.charAt(l);
			_myInventory.add(new Tile(c));
		}
		}
		for(int i = 0; i<15; i++){
			_myInventory.add(new Tile('Y'));
		}
		for(int i = 0; i<12; i++){
			String rest = "BCDFGHJKLMNPQRSTVWXZ";
			for(int l = 0; l<rest.length(); l++){
				char c = rest.charAt(l);
				_myInventory.add(new Tile(c));
			}
			
		}
		Collections.shuffle(_myInventory);
	}
	public Tile getTile(int i){
		return _myInventory.get(i);
	}
	public int getSize(){
		return _myInventory.size();
	}
	public void remove(int i){
		_myInventory.remove(i);
	}
}
