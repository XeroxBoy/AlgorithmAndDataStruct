package IO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIO {
    static byte[] bs = new byte[1024];

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9098);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.getInputStream().read(bs);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
