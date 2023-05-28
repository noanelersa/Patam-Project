package Model.PTM1;

import java.util.ArrayList;
import java.util.List;

public class LRU implements CacheReplacementPolicy{
    private final List<String> words;
    private int currentSize= 0;
    public LRU(){
        this.currentSize=0;
        words = new ArrayList<>();
    }
    @Override
    public void add(String word) {
        if(word != null) {
            words.remove(word);
            words.add(word);
            currentSize++;
        }
    }

    @Override
    public String remove() {
        currentSize--;
        return words.remove(0);
    }
    public int getCurrentSize() {
        return currentSize;
}
}