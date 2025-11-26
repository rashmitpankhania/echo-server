package com.rashmit.johncrickett.Tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;;

public class TcpServerMainThread implements Runnable {

    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public TcpServerMainThread(int portNumber, int poolSize) throws IOException {
        serverSocket = new ServerSocket(portNumber);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        System.out.println("Server started at socket port"+ serverSocket.getLocalPort() + "at thread "+ Thread.currentThread().getName());
        for (;;) {
            try {
                Socket clientSocket = serverSocket.accept();
                pool.submit(new TcpServerHandlerThread(clientSocket));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }
    }

}
