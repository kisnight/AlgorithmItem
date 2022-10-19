package study.demo.tcpandudp.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // 1.服务器建立通信ServerSocket
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("启动服务器....");

            // 2.服务器建立Socket接收客户端连接
            Socket s = ss.accept();
            System.out.println("客户端:"+s.getInetAddress().getHostAddress() + "已连接到服务器");

            // 3.建立IO输入流读取客户端发送的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String mess = br.readLine();
            System.out.println("客户端: " + mess);

            // 4.建立IO输出流向客户端发送数据消息
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write( "【服务器端】发送消息\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

