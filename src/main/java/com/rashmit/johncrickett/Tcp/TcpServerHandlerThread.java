package com.rashmit.johncrickett.Tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpServerHandlerThread implements Runnable{

    private final Socket socket;

    public TcpServerHandlerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            System.out.println(
                    "Accepted connection from: " + socket.getInetAddress() + ":" + socket.getPort());
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("got from socket" + socket.getPort() + " " + Thread.currentThread().getName() +": " + inputLine);
                out.println(inputLine);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
