package network.client;

import model.Song;

import java.io.*;
import java.net.Socket;

public class FileClient {

    private Socket socket;
    private Song song;

    public FileClient(String host, int port, String file) {

        song = new Song(file);
        try {
            socket = new Socket(host, port);
            sendFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String file) throws IOException {

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println(song.getTitle());
        printWriter.flush();

        printWriter.println(song.getBytes());
        printWriter.flush();

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[song.getBytes()];

        while (fis.read(buffer) > 0) {
            dos.write(buffer);
        }

        fis.close();
        dos.close();
    }


}