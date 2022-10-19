package study.demo.tcpandudp.tcp;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {

            // 创建Socket通信，设置通信服务器的IP和Port
            Socket socket = new Socket("127.0.0.1", 9999);

            // 建立IO输出流向服务器发送数据消息
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // 数据发送流，注意bw.write()中的数据要加 \n，否则Server会一直等待
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("发送消息【客户端】\n");
            bw.flush();

            // 数据接收留
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("服务器: " + mess);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

