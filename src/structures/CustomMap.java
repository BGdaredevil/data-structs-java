package structures;

import org.jetbrains.annotations.Nullable;
import utils.MapCustomNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomMap<K, V> {
    private int length;
    private int capacity;
    private ArrayList<MapCustomNode<K, V>>[] store;

    public CustomMap() {
        this(3);
    }

    public CustomMap(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        this.store = (ArrayList<MapCustomNode<K, V>>[]) Array.newInstance(ArrayList.class, capacity);

        for (int i = 0; i < this.store.length; i++) {
            this.store[i] = new ArrayList<>();
        }
    }

    @Nullable
    public V get(K key) {
        V returnValue = null;
        int idx = this.hashKey(key);

        for (int i = 0; i < this.store[idx].size(); i++) {
            MapCustomNode<K, V> item = this.store[idx].get(i);
            if (item.key == key) {
                returnValue = item.value;
                break;
            }
        }

        return returnValue;
    }

    public void set(K key, V value) {
        int idx = this.hashKey(key);
        this.store[idx].add(new MapCustomNode<>(key, value));
        if ((double) this.length / this.capacity > 0.7) {
            this.grow();
        }

        this.length++;
    }

    @Nullable
    public V delete(K key) {
        V returnValue = null;
        int idx = this.hashKey(key);
        ArrayList<MapCustomNode<K,V>> list = this.store[idx];

        for (int i = 0; i < list.size(); i++) {
            MapCustomNode<K,V> item = list.get(i);
            if (item.key == key) {
                returnValue = item.value;
                list.remove(item);
                this.length--;
                break;
            }
        }

        return returnValue;
    }

    public int size() {
        return this.length;
    }

    private int hashKey(K key) {
        int hashCode = Math.abs(key.hashCode());

        return hashCode % this.capacity;
    }

    private void grow() {
        this.capacity = this.capacity * 2;
        ArrayList<MapCustomNode<K, V>> tempList = new ArrayList<>();
        ArrayList<MapCustomNode<K, V>>[] newStore = (ArrayList<MapCustomNode<K, V>>[]) Array.newInstance(ArrayList.class, this.capacity);
        for (int i = 0; i < newStore.length; i++) {
            newStore[i] = new ArrayList<>();
        }

        for (int i = 0; i < this.store.length; i++) {
            var currList = this.store[i];
            tempList.addAll(currList);
        }

        for (int i = 0; i < tempList.size(); i++) {
            var item = tempList.get(i);
            var idx = this.hashKey(item.key);
            newStore[idx].add(item);
        }

        this.store = newStore;
    }
}
