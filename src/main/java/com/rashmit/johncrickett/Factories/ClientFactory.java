package com.rashmit.johncrickett.Factories;

import com.rashmit.johncrickett.Interfaces.IClient;
import com.rashmit.johncrickett.Tcp.TcpEchoClient;
import com.rashmit.johncrickett.Udp.UdpEchoClient;

public class ClientFactory {
    public static IClient getClient(String protocol){
        if(protocol.equals("tcp"))
        return new TcpEchoClient();
        else return new UdpEchoClient();
    }
}
