package Model.PTM1;


import java.io.*;
import java.util.Scanner;

public class BookScrabbleHandler implements ClientHandler   {
    Scanner reader;
    PrintWriter p;
    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        reader = new Scanner(new BufferedReader(new InputStreamReader(inFromclient)));
        p = new PrintWriter(outToClient);
        String input = reader.next();
        String[] splitInput =input.split(",");
        String[] booksAndWord = new String[splitInput.length-1];
        System.arraycopy(splitInput, 1, booksAndWord, 0, splitInput.length - 1);
        boolean b;
        if(splitInput[0].equals("Q")){
            b = DictionaryManager.get().query(booksAndWord);
        }
        else {
            b = DictionaryManager.get().challenge(booksAndWord);
        }
        p.println(b);
        p.flush();
    }
    @Override
    public void close() {
        reader.close();
        p.close();
    }
}
