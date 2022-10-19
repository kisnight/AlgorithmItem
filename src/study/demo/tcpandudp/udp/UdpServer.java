package study.demo.tcpandudp.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) {

        try {
            // 创建要接收的报文的存储对象
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

            // 创建服务器端socket
            DatagramSocket socket = new DatagramSocket(9991);
            System.out.println("udp server 启动...");

            // 接收消息，如果未收到消息会一直阻塞
            socket.receive(packet);
            String mess = new String(packet.getData(), 0, packet.getLength());
            System.out.println(packet.getLength());
            System.out.println(mess);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

