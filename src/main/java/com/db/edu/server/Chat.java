package com.db.edu.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat{
    static final Logger logger = LoggerFactory.getLogger(ServerImpl.class);

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9222);
            while(true){
                Socket socket = serverSocket.accept();
                SocketThread socketThread = new SocketThread(new User(socket), new UserList());
                Thread thread = new Thread(socketThread);
                thread.start();
            }
        } catch (IOException e) {
            //FIXME log to file
           logger.error("Exception", e);
        }
    }
}