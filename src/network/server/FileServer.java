package network.server;

import view.Friends.FriendActivity;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {

    private ServerSocket socket;
    private FriendActivity friendActivity;

    public FileServer(int port, FriendActivity friendActivity) {
        this.friendActivity = friendActivity;
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

                ClientHandler clientHandler = new ClientHandler(client, friendActivity);
                Thread td = new Thread(clientHandler);
                td.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}