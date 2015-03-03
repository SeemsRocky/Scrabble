package code;

public class Tile {
	private char _letter;
	private int _value;
	public Tile(char l, int v){
		_letter = l;
		_value = v;
	}
	public char getLetter(){
		return _letter;
	}
	public int getValue(){
		return _value;
	}
}
