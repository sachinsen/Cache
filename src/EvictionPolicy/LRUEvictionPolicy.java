package EvictionPolicy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key>{
	private  Deque<Key> queue = new LinkedList<>();
	
	@Override
	public void keyAccesed(Key k) {
		queue.remove(k);
		queue.addLast(k);
	}

	@Override
	public Key evictKey() {
		return queue.removeFirst();
	}

}
