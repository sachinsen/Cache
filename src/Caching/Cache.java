package Caching;
import EvictionPolicy.IEvictionPolicy;
import Exception.NoElementException;
import Storage.IStorage;

public class Cache<Key, Value> {
	private IStorage<Key, Value> storage;
	private IEvictionPolicy<Key> evictionPolicy;
    private int size;
	
	public Cache(IStorage<Key, Value> storage, IEvictionPolicy<Key> evictionPolicy) {
		this.storage = storage;
		this.evictionPolicy = evictionPolicy;
	}

	public Value get(Key k) {
		Value v = null;
		try {
			v = storage.getKey(k);
			evictionPolicy.keyAccesed(k);
		} catch (NoElementException e) {
			System.out.print("No Element is present in cache");
		}
		return v;
	}
	
	
	public void add(Key k, Value val) {
		try {
			storage.put(k, val);
			evictionPolicy.keyAccesed(k);
		} catch (RuntimeException e) {
			System.out.println("Storage is full trying to evict the key from cache");
			Key evictKey = evictionPolicy.evictKey();
			if(evictKey == null) {
				throw new RuntimeException("Unexpected state");
			}
			System.out.println("Evict key is " + evictKey);
			storage.remove(evictKey);
			System.out.println("Putting the new value ");
			storage.put(k, val);
		}

	}
	
	
	
	
}
