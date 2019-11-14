package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NIO {
    static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8098);
            serverSocketChannel.bind(socketAddress);
            serverSocketChannel.configureBlocking(false);
            while (true) {
                for (SocketChannel socketChannel : channelList
                ) {
                    int read = socketChannel.read(byteBuffer);
                    if (read > 0) {
                        System.out.println("read---- ");
                        byteBuffer.flip();
                        byte[] bs = new byte[read];
                        byteBuffer.get(bs);
                        String content = new String(bs);
                        System.out.println(content);
                        byteBuffer.flip();
                    }
                }
                SocketChannel accept = serverSocketChannel.accept();
                if (accept != null) {
                    System.out.println("conn success");
                    accept.configureBlocking(false);
                    channelList.add(accept);
                    System.out.println(channelList.size() + "list --size");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
