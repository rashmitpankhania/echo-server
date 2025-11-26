package com.rashmit.johncrickett.Udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.rashmit.johncrickett.Interfaces.IClient;

public class UdpEchoClient implements IClient {

    @Override
    public void start(String hostName, int portNumber) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }
        String userInput;
        try (DatagramSocket socket = new DatagramSocket();
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            while ((userInput = stdIn.readLine()) != null) {
                byte[] buff = userInput.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length, inetAddress, portNumber);
                socket.send(datagramPacket);
                System.out.println("client sent: " + userInput);
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                System.out.println("client recieved: " + new String(packet.getData()));
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
