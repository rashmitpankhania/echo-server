package com.rashmit.johncrickett.Udp;

import com.rashmit.johncrickett.Interfaces.IServer;

/**
 * Hello world!
 */
public class UdpEchoServer implements IServer {
    @Override
    public void start(int portNumber) {
        System.out.println("UDP Server Started");
        try {
            UdpServerThread networkService = new UdpServerThread(portNumber);
            new Thread(networkService).start();
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
