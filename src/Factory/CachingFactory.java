package Factory;

import Caching.Cache;
import EvictionPolicy.LRUEvictionPolicy;
import Storage.HashMapStorage;

public class CachingFactory<Key, Value>{

	public Cache<Key, Value> getDefaultCache(final int capacity) {
		return new Cache<Key, Value>(new HashMapStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
	}
}
