package network.server;

import model.Song;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {

    private ServerSocket socket;

    public FileServer(int port) {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket client = socket.accept();

                ClientHandler clientHandler = new ClientHandler(client);
                Thread td = new Thread(clientHandler);
                td.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        FileServer fs = new FileServer(1988);
        fs.start();
    }

}