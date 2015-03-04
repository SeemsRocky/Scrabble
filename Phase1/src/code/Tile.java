package code;

public class Tile {
	private char _letter;
	private int _value;
	public Tile(char l){
		_letter = l;
		_value = this.getValue();
	}
	public char getLetter(){     //returns the letter represented by the tile
		return _letter;
	}
	public int getValue(){       //returns the value of the tile according to the rules
		if(_letter=='Y'){
			return 2;
		}
		if(_letter=='A' || _letter=='E' || _letter=='I' || _letter=='O' || _letter=='U'){
			_value = 1;
		}
		else{
			_value = 5;
		}
		return _value;
	}
	@Override
	public String toString(){  //prints the letter of the tile
		String s = "" + _letter;
		return s;
		
	}
	
}
