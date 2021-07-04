import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import Caching.Cache;
import Factory.CachingFactory;

class CachingTest {
	private Cache<Integer, Integer> cache;

	/*
	 * @BeforeAll public void setup() { cache = new CachingFactory<Integer,
	 * Integer>().getDefaultCache(3); }
	 */
	
	@Test
	public void test1() {
	 cache = new CachingFactory<Integer, Integer>().getDefaultCache(3);
		cache.add(1, 1);
        cache.add(2, 2);

        assertEquals(1, cache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        cache.add(3, 3);
        assertEquals(3, cache.get(3));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        cache.add(4, 4);

        cache.get(2); // This should throw exception "Tried to access non-existing key."
	    
	}

	
}
