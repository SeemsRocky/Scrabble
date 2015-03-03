package code;

import java.util.ArrayList;


public class TileRack {
      private ArrayList<Tile> _tile;
      private Inventory _inventory;
      public TileRack(Inventory inv){
    	  _inventory = inv;
    	  _tile = new ArrayList<Tile>();
    	  for(int i = 0; i < 7; i++){
    		  _tile.add(_inventory.getTile(0));
    		  inv.remove(0);
    	  }
      }
      public void refillIfNotFull(){
    	  if(!(_tile.size()==7)){
    		  int i = 7 - _tile.size();
    		  for(int l = 0; l < i; l++){
    			  _tile.add(_inventory.getTile(0));
        		  _inventory.remove(0);
    		  }
    	  }
      }
      public void remove(int i){
    	  _tile.remove(i);
    	  //System.out.println("Number of tiles before refilling again is " + _tile.size());
    	  
      }
}
