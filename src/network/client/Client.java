package network.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Socket socket;
    Scanner sc = new Scanner(System.in);

    public Client(String ip, int port) throws IOException {

        this.socket = new Socket(ip, port);
        String output = sc.nextLine();

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println(output);
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }
}
