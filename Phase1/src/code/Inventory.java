package code;

import java.util.ArrayList;

public class Inventory {

	public Inventory(){
		ArrayList<Tile> myInventory = new ArrayList<Tile>();
		for(int i = 0; i < 29; i++){
		String vowels = "AEIOU";
		for(int l = 0; l<vowels.length(); l++){
			char c = vowels.charAt(l);
			myInventory.add(new Tile(c));
		}
		}	
	}
}
