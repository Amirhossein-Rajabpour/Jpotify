package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private ServerSocket serverSocket;
    boolean isRun = true;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(4422, 2);
    }

    public void stop() throws IOException {
        this.serverSocket.close();
        isRun = false;
    }

    @Override
    public void run() {
        while (isRun) {
            try {

                Socket client = this.serverSocket.accept();
                System.out.println("Client Connected");

                ClientHandler clientHandler = new ClientHandler(client);
                Thread td = new Thread(clientHandler);
                td.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
