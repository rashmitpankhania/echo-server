package com.rashmit.johncrickett;

import com.rashmit.johncrickett.Factories.ServerFactory;
import com.rashmit.johncrickett.Interfaces.IServer;

public class ServerDriver {
    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        if (portNumber == 0)
            portNumber = 4445;
        String protocol = args[1];
        if (protocol == null)
            protocol = "tcp";

        IServer server = ServerFactory.getServer(protocol);
        server.start(portNumber);
    }
}
