package HashMap;

/**
 * @author shkstart
 * @create 2021-04-27 20:03
 */
public class Entry<K, V> {
    K k;
    V v;
    public Entry<K, V> next;

    public Entry(K k, V v, Entry<K, V> next) {
        this.k = k;
        this.v = v;
        this.next = next;

    }
    public K getKey(){
        return k;
    }

    public V getValue() {
        return v;
    }
}
