package model;

public class ChainHashTable<K extends Comparable<K>,V> implements IHashTable<K,V>{
    private int length;
    private HNode<K,V>[] list;
    public ChainHashTable(int length){
        this.length=length;
        list=new HNode[length];
    }

    public void insert(K key, V value){
        int index=hash(key);
        HNode<K,V> node=new HNode<K,V>(key,value);
        if(list[index]!=null){
            list[index].setPrev(node);
            node.setNext(list[index]);
        }
        list[index]=node;
    }

    public V search(K key){
        int index=hash(key);
        HNode<K,V> node=list[index];
        while(node!=null){
            if(node.getKey().compareTo(key)==0){
                return node.getValue();
            }
            node=node.getNext();
        }
        return null;
    }

    public void delete(K key){
        int index=hash(key);
        HNode<K,V> node=list[index];
        boolean found=false;
        while(node!=null&&!found){
            if(node.getKey().compareTo(key)==0){
                if (node.getPrev()==null){
                    list[index]=node.getNext();
                }else{
                    node.getPrev().setNext(node.getNext());
                }if(node.getNext()!=null){
                    node.getNext().setPrev(node.getPrev());
                }
                found=true;
            }else{
                node=node.getNext();
            }
        }
    }

    public String print(){
        String msg ="";
        for (int i=0;i<length;i++){
            msg +="[ ";
            if(list[i]!=null){
                HNode<K,V>node = list[i];
                while(node!=null){
                    if(node.getNext()==null){
                        msg+=node.getValue().toString()+". ";
                    }else {
                        msg += node.getValue().toString() + ", ";
                    }
                    node = node.getNext();
                }

            }
            msg+="]\n";

        }
        return msg;
    }

    public int hash(K key){
        return key.hashCode()%length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public HNode<K, V>[] getList() {
        return list;
    }

    public void setList(HNode<K, V>[] list) {
        this.list = list;
    }
}
