package aston.modul_1;

public interface MayMap<K,V> extends Iterable<V> {
    boolean put(K key, V value );
    boolean remove(K key);
    V get(K key);
}
