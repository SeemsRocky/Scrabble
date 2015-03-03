package code;

public class Player {
    private String _name;
    private Board _board;
    private Inventory _inventory;
    private int _score;
    public Player(String name, Board b, Inventory inv){
    	_name = name;
    	_board = b;
    	_inventory = inv;
    	TileRack myTileRack = new TileRack(_inventory);
    }
    public int score(){
    	return _score;
    }
}
