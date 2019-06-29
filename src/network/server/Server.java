package network.server;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private ServerSocket serverSocket;
    boolean isRun = true;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
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
                saveFile(client);

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

    private void saveFile(Socket clientSock) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream("testfile.jpg");
        byte[] buffer = new byte[4096];

        int filesize = 15123; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
    }
}
