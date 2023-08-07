package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        clientSend();

    }


    public static void clientSend() {

        String host = "netology.homework";
        int port = 8081;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println();
            Thread.sleep(300);
            String resp = in.readLine();
            System.out.println(resp);
            out.println("Alex");
            System.out.println("Alex");
            String resp2 = in.readLine();
            System.out.println(resp2);
            Thread.sleep(300);
            out.println("no");
            System.out.println("no");
            String resp3 = in.readLine();
            Thread.sleep(300);
            System.out.println(resp3);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
