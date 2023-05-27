package Model.PTM1;


import java.util.HashMap;

public class DictionaryManager {
    private final HashMap<String, Dictionary> dictionaryMapManager;
    private static DictionaryManager dictionaryManager;

    private DictionaryManager() {
        this.dictionaryMapManager = new HashMap<>();
    }

    public boolean query(String... booksAndWord){
        boolean flag=false;
        for (int i = 0; i < booksAndWord.length -1 ; i++) {
            if(dictionaryMapManager.get(booksAndWord[i]) == null){
                dictionaryMapManager.put(booksAndWord[i],new Dictionary(booksAndWord[i]));
            }
            if(dictionaryMapManager.get(booksAndWord[i]).query(booksAndWord[booksAndWord.length-1])) flag = true;
        }
        return flag;
    }

    public boolean challenge(String... booksAndWord){
        boolean flag=false;
        for (int i = 0; i < booksAndWord.length -1 ; i++) {
            if(dictionaryMapManager.get(booksAndWord[i]) == null){
                dictionaryMapManager.put(booksAndWord[i],new Dictionary(booksAndWord[i]));
            }
            if(dictionaryMapManager.get(booksAndWord[i]).challenge(booksAndWord[booksAndWord.length-1])) flag = true;
        }
        return flag;
    }

    public int getSize(){
        return dictionaryMapManager.size();
    }
    public static DictionaryManager get(){
        if (dictionaryManager == null)
            dictionaryManager = new DictionaryManager();
        return dictionaryManager;
    }
}
