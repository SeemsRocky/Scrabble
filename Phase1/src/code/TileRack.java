package code;

import java.util.ArrayList;


public class TileRack {
      private ArrayList<Tile> _tile;
      private Inventory _inventory;
      public TileRack(Inventory inv){
    	  _inventory = inv;
    	  _tile = new ArrayList<Tile>();   //creates new ArrayList for the TileRack
    	  for(int i = 0; i < 7; i++){      //adds 7 random tiles from the inventory to the rack
    		  _tile.add(_inventory.getTile(0));   
    		  inv.remove(0);               //removes the added tile from the inventory
    	  }
      }
      public void refillIfNotFull(){   //refills back to 7 tiles if size of the rack is not 7
    	  if(!(_tile.size()==7)){
    		  int i = 7 - _tile.size();
    		  for(int l = 0; l < i; l++){
    			  _tile.add(_inventory.getTile(0));
        		  _inventory.remove(0);
    		  }
    	  }
      }
      public void remove(int i){      //removes tiles at index i from the rack
    	  _tile.remove(i);
    	  //System.out.println("Number of tiles before refilling again is " + _tile.size());
    	  
      }
      public Tile getTile(int i){     //returns the tile at index i 
    	  return _tile.get(i);
      }
      public int getSize()
      {
    	  return _tile.size();
      }
}
