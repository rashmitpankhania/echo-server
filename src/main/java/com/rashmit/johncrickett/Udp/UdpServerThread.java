package com.rashmit.johncrickett.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerThread implements Runnable {
    private final DatagramSocket datagramSocket;

    public UdpServerThread(int portNumber) throws IOException {
        datagramSocket = new DatagramSocket(portNumber);
    }

    @Override
    public void run() {
        System.out.println("UDP server started");
        for (;;) {
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                datagramSocket.receive(packet);
                new UdpServerHandlerThread(packet).run();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
