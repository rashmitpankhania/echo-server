package com.rashmit.johncrickett;

import com.rashmit.johncrickett.Factories.ClientFactory;
import com.rashmit.johncrickett.Interfaces.IClient;

public class ClientDriver {
    public static void main(String[] args) {
        String hostName = args[0];
        if (hostName == null)
            hostName = "localhost";

        int portNumber = Integer.parseInt(args[1]);
        if (portNumber == 0)
            portNumber = 4445;
        String protocol = args[2];
        if (protocol == null)
            protocol = "tcp";
        IClient client = ClientFactory.getClient(protocol);
        client.start(hostName, portNumber);
    }
}
