import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import EvictionPolicy.LRUEvictionPolicy;

public class LRUTest {
	private LRUEvictionPolicy<Integer> lruEvictionPolicy;
	
	/*
	 * @BeforeEach void setUp() { lruEvictionPolicy = new LRUEvictionPolicy<>(); }
	 */
	

    @Test
    public void testKeysAreEvictedInTheOrderInWhichTheyAreAccessedAccess() {
    	lruEvictionPolicy = new LRUEvictionPolicy<>();
        lruEvictionPolicy.keyAccesed(1);
        lruEvictionPolicy.keyAccesed(2);
        lruEvictionPolicy.keyAccesed(3);
        lruEvictionPolicy.keyAccesed(4);
        assertEquals(2, lruEvictionPolicy.evictKey());
        assertEquals(2, lruEvictionPolicy.evictKey());
        assertEquals(3, lruEvictionPolicy.evictKey());
        assertEquals(4, lruEvictionPolicy.evictKey());
    }

}
