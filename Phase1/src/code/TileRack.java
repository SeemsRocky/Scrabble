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
      
      /**
       * This method refills the TileRack back if the TileRack does not have 12 tiles
       */
      public void refillIfNotFull(){   
    	  if(!(_tileRack.size()==12)){
    		  int i = 12 - _tileRack.size();
    		  for(int l = 0; l < i; l++){
    			 addTile(_inventory.getTile(0));
        		  _inventory.remove(0);
    		  }
    	  }
      }
      
      /**
       * This method removes a tile from the TileRack.
       * @param t Tile which has to be removed from the TileRack.
       */
      public void removeTile(Tile t){      //removes tiles at index i from the rack
    	  _tileRack.remove(t);
    	  //System.out.println("Number of tiles before refilling again is " + _tile.size());
    	  
      }
      
      /**
       * This method removes a tile from index i of the TileRack.
       * @param i An int that is the index of the tile that has to be removed.
       */
      public void remove(int i){
    	  _tileRack.remove(i);
      }
      
      /**
       * This method returns the tile that is at index i.
       * @param i An int that is the index of the TileRack.
       * @return Tile at index i. 
       */
      public Tile getTile(int i){     
    	  return _tileRack.get(i);
      }
      
      /**
       * This method returns the size of the TileRack. 
       * @return An int that is the size of the TileRack. 
       */
      public int getSize(){
    	  return _tileRack.size();
      }
      
      /**
       * This method adds a tile to the TileRack. This method is used a lot of times
       * in testing the functionality of the project. 
       * @param t Tile that has to be added to the TileRack.
       */
      public void addTile(Tile t){
    	  _tileRack.add(t);
      }
}

