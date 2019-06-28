package network.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        while (true) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String input = null;
            try {
                input = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            printWriter.println(input);
            printWriter.flush();

        }
    }
}
