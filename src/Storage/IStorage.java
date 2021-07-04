package Storage;

import Exception.NoElementException;
import Exception.StorageFullException;

public interface IStorage<Key, Value>{

	Value getKey(Key k) throws NoElementException;
	
	void put(Key k, Value value) throws StorageFullException;
	
	void remove(Key k);
}
