package util.collection.map;

import util.collection.list.LinkedList;
import util.collection.set.LinkedSet;
import util.values.Pair;

public class Map<K,V> {
    
    private LinkedList<Pair<K,V>> pairs;

    protected Map(){
        this.pairs = new LinkedList<>();
    }

    public void put(K key, V value){  
        LinkedList<Pair<K,V>>.Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        while (iterator.hasNext()){
            Pair<K,V> pair = iterator.next();
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
            }
            return;
        }
        this.pairs.add(new Pair<>(key, value));
    }

    public void remove(K key){
        LinkedList<Pair<K,V>>.Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        Pair<K,V> pair = null;
        while (iterator.hasNext() && !pair.getKey().equals(key)){
            pair = iterator.next();
        }
        if (pair != null){
            this.pairs.remove(pair);
        }
    }

    public V get(K key){
        LinkedList<Pair<K,V>>.Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        Pair<K,V> pair = null;
        while (iterator.hasNext() && !pair.getKey().equals(key)){
            pair = iterator.next();
        }
        if (pair != null){
            return pair.getValue();
        } 
        return null;
    }

    public LinkedSet<K> keySet() {
        LinkedSet<K> set = new LinkedSet<K>();
        LinkedList<Pair<K,V>>.Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        while (iterator.hasNext()){
            set.add(iterator.next().getKey());
        }
        return set;
    }

}
