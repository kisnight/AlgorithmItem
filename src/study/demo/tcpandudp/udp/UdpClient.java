package study.demo.tcpandudp.udp;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    public static void main(String[] args) {
        String mess = "udp message from client";

        try {
            // 获取IP地址对象
            InetAddress address = InetAddress.getByName("127.0.0.1");

            // 创建packet包对象，封装要发送的包数据和服务器地址和端口号
            DatagramPacket packet = new DatagramPacket(mess.getBytes(), mess.getBytes().length, address, 9991);

            // 创建socket对象
            DatagramSocket socket = new DatagramSocket();

            // 发送数据
            socket.send(packet);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

