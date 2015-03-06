package code;

import java.util.ArrayList;


public class TileRack {
	  /**
	  * An instance variable for the ArrayList of tiles for the TileRack. 
	  */
      private ArrayList<Tile> _tileRack;
      
      /**
       * An instance variable for the inventory of the game.
       */
      private Inventory _inventory;
      
      /**
       * The constructor creates a new ArrayList of tiles for the rack. It also fills
       * that array so that it holds 12 tiles taken from the inventory. 
       * @param inv Inventory for the game. 
       */
      public TileRack(Inventory inv){
    	  _inventory = inv;
    	  _tileRack = new ArrayList<Tile>();   
    	  for(int i = 0; i < 12; i++){      
    		  _tileRack.add(_inventory.getTile(0));   
    		  inv.remove(0);               
    	  }
      }
      
      
      public void refillIfNotFull(){   //refills back to 12 tiles if size of the rack is not 12
    	  if(!(_tileRack.size()==12)){
    		  int i = 12 - _tileRack.size();
    		  for(int l = 0; l < i; l++){
    			 addTile(_inventory.getTile(0));
        		  _inventory.remove(0);
    		  }
    	  }
      }
      public void removeTile(Tile t){      //removes tiles at index i from the rack
    	  _tileRack.remove(t);
    	  //System.out.println("Number of tiles before refilling again is " + _tile.size());
    	  
      }
      public void remove(int i){
    	  _tileRack.remove(i);
      }
      public Tile getTile(int i){     //returns the tile at index i 
    	  return _tileRack.get(i);
      }
      public int getSize(){
    	  return _tileRack.size();
      }
      public void addTile(Tile t){
    	  _tileRack.add(t);
      }
}

