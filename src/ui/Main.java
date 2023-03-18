package ui;
import model.ChainHashTable;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        ChainHashTable<Integer,String> hashTable = new ChainHashTable<>(10);
        for(int i =0;i<10;i++){
            Random r = new Random();
            int val=r.nextInt(500);
            hashTable.insert(val,val+"");
        }
        System.out.println(hashTable.print());
    }
}
