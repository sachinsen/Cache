package EvictionPolicy;

public interface IEvictionPolicy<Key> {

	void keyAccesed(Key k);

	Key evictKey();
}
