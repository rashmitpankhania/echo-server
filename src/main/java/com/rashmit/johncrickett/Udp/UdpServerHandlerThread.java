package com.rashmit.johncrickett.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;;

public class UdpServerHandlerThread implements Runnable {

    private final DatagramPacket packetToSend;

    public UdpServerHandlerThread(DatagramPacket packet) throws IOException {
        byte[] buff = packet.getData();
        packetToSend = new DatagramPacket(buff, buff.length, packet.getAddress(), packet.getPort());
    }

    @Override
    public void run() {
        System.out.println("packet recieved from " + packetToSend.getAddress() + packetToSend.getPort());
        try 
            (DatagramSocket datagramSocket = new DatagramSocket();){
            datagramSocket.send(packetToSend);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("packet sent");
        
    }

}
