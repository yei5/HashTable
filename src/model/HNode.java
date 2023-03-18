package model;

public class HNode <K extends Comparable<K>,V>{
    private K key;
    private V value;
    private HNode<K,V> next;
    private HNode<K,V> prev;

    public HNode(K key, V value){
        this.key=key;
        this.value=value;
        next=null;
        prev=null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HNode<K, V> getNext() {
        return next;
    }

    public void setNext(HNode<K, V> next) {
        this.next = next;
    }

    public HNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(HNode<K, V> prev) {
        this.prev = prev;
    }
}
