package Storage;

import java.util.HashMap;
import java.util.Map;

import Exception.NoElementException;
import Exception.StorageFullException;

public class HashMapStorage<Key, Value> implements IStorage<Key, Value> {

	private final Map<Key, Value> map= new HashMap<>();
	private int size;
	
	
	 public HashMapStorage(int size) {
		this.size = size;
	}
	
	@Override
	public Value getKey(Key k) throws NoElementException{
		if (map.containsKey(k)) {
			return map.get(k);
		}
		throw new NoElementException("No Element is present");
	}

	@Override
	public void put(Key k, Value value) throws StorageFullException{
		if (!storageFull()) {
			map.put(k, value);
		} else {
			throw new StorageFullException("Storage is full");
		}
	}
	
	private boolean storageFull() {
		return map.size() >= size;
	}

	@Override
	public void remove(Key k) {
		map.remove(k);
	}

}
