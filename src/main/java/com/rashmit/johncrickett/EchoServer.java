package com.rashmit.johncrickett;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class EchoServer {
    public static void main(String[] args) {
        System.out.println("here ass hole");
        int portNumber = 7;
        if (args[0] != null) {
            portNumber = Integer.parseInt(args[0]);
        }

        try (
                ServerSocket socket = new ServerSocket(portNumber);
                Socket clientSocket = socket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    String inputLine;
                    while ((inputLine = in.readLine())!=null) {
                        System.out.println("got from socket: "+inputLine);
                        out.println(inputLine);
                    }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
