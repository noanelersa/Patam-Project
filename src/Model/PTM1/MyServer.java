package Model.PTM1;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer {
    private final int port;
    private final ClientHandler ch;
    private volatile boolean stop;

    public MyServer(int port, ClientHandler clientHandler) {
        this.port = port;
        this.ch = clientHandler;
        stop = false;
    }

    public void start(){
        new Thread(()-> {
            try {
                runServer();
            } catch (IOException ignored) {
            }
        }).start();
    }

    public void close(){
        stop=true;
    }

    private void runServer() throws IOException {
        ServerSocket server=new ServerSocket(port);
        server.setSoTimeout(1000);
        Socket aClient  = new Socket();
        while(!stop){
            try{
                aClient = server.accept();
                try{
                    ch.handleClient(aClient.getInputStream(),aClient.getOutputStream());
                    ch.close();
                } catch (IOException ignored){}

            } catch (SocketTimeoutException ignored){}
        }
        try {}
        finally {
            aClient.close();
            server.close();
        }
    }
}
