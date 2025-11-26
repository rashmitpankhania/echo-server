package com.rashmit.johncrickett.Tcp;

import com.rashmit.johncrickett.Interfaces.IServer;

/**
 * Hello world!
 */
public class TcpEchoServer implements IServer {

    @Override
    public void start(int portNumber) {
        System.out.println("TCP Server started!!");
        try{
        TcpServerMainThread networkService = new TcpServerMainThread(portNumber, 50);
        new Thread(networkService).start();;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
