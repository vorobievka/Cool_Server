package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 8081;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String name = null;
        String age = null;
        int i = 0;
        while (i < 3) {
            switch (i) {
                case (0):
                    System.out.println("Write your name?");
                    out.println("Write your name?");
                    i = i + 1;
                    name = null;
                    break;
                case (1):
                    name = in.readLine();
                    if ("".equals(name) | name == null) {
                        i = 1;
                        break;
                    }
                    System.out.println(name);
                    System.out.println("Are you child? (yes/no)");
                    out.println("Are you child? (yes/no)");
                    i = i + 1;
                    break;
                case (2):
                    age = in.readLine();
                    System.out.println(age);
                    if ("".equals(age) | age == null) {
                        i = 2;
                        break;
                    }
                    if ("yes".equals(age)) {
                        System.out.println("Let's play!");
                        out.println("Let's play!");
                    } else {
                        System.out.println(String.format("Welcome to the adult zone, %s", name));
                        out.println(String.format("Welcome to the adult zone, %s", name));
                    }
                    i = i + 1;
                    Thread.sleep(500);
                    break;
                default:
                    break;
            }

        }

    }
}