package com.rashmit.johncrickett;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 7;
        if (args[0] != null) {
            portNumber = Integer.parseInt(args[0]);
        }
        NetworkService networkService = new NetworkService(portNumber, 50);
        new Thread(networkService).start();;
    }
}
