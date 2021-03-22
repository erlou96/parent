package sdk.Bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class BioClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 6666);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                handle(client);
            }
        });
        thread.start();
    }
    public static void handle(Socket socket){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("Hello World");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
