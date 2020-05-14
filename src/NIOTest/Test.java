package NIOTest;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        //运行服务器
        BaseNIOServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        BaseNIOClient.start();
        while (BaseNIOClient.sendMsg(new Scanner(System.in).nextLine())) ;
    }


}