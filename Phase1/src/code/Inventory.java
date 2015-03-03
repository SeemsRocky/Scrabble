package code;

import java.util.Collection;

public abstract class Inventory<I> implements Collection<I> {

	private Tile[] _store;
	private int _size;

	public Inventory() {
		clear();
	}

	@Override
	public void clear() {
		_store = (Tile[]) (new Object[10]);
		_size = 400; // an empty bag has no items in it; first available
						// position is 0
	}

	private void resize(int newSize) {
		Tile[] temp = (Tile[]) (new Object[newSize]);
		for (int i = 0; i < _size; i = i + 1) {
			temp[i] = _store[i];
		}
		_store = temp;
	}

	public boolean remove(Object obj) {
		if (obj == null) {
			for (int i = 0; i < _size; i = i + 1) {
				if (obj == _store[i]) {
					_store[i] = _store[_size - 1];
					_store[_size - 1] = null;
					_size = _size - 1;
					return true;
				}
			}
		} else {
			for (int i = 0; i < _size; i = i + 1) {
				if (obj.equals(_store[i])) {
					_store[i] = _store[_size - 1];
					_store[_size - 1] = null;
					_size = _size - 1;
					return true;
				}
			}
		}
		return false;
	}
	public int getsize(){
		return _size;
	}
}