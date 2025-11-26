package com.rashmit.johncrickett.Factories;

import com.rashmit.johncrickett.Interfaces.IServer;
import com.rashmit.johncrickett.Tcp.TcpEchoServer;
import com.rashmit.johncrickett.Udp.UdpEchoServer;

public class ServerFactory {
    public static IServer getServer(String protocol) {
        if (protocol.equals("tcp"))
            return new TcpEchoServer();
        return new UdpEchoServer();
    }
}
