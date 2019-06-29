package network.server;

import view.Friends.FriendActivity;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;
    private FriendActivity friendActivity;

    public ClientHandler(Socket client, FriendActivity friendActivity) {
        this.client = client;
        this.friendActivity = friendActivity;
    }


    @Override
    public void run() {

//        while (true) {
        try {
            saveFile(client, friendActivity);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }
    }

    private void saveFile(Socket client, FriendActivity friendActivity) throws IOException {

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

        int bytes = 0;

        try {
            bytes = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream dis = new DataInputStream(client.getInputStream());

        FileOutputStream fos = new FileOutputStream(input + ".mp3");
        byte[] buffer = new byte[bytes];

        int filesize = bytes; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            fos.write(buffer, 0, read);
        }

        friendActivity.addNewParticipant("/Users/apple/IdeaProjects/Jpotify1/" + input + ".mp3");

        fos.close();
        dis.close();

    }
}
