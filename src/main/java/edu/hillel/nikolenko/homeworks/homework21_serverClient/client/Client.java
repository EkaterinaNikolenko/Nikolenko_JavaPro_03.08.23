package edu.hillel.nikolenko.homeworks.homework21_serverClient.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socketClient = new Socket("localhost", 8080)) {
            try (PrintWriter printWriter = new PrintWriter(socketClient.getOutputStream(), true)) {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    printWriter.println(line);
                    if (line.equals("-exit")) {
                        System.exit(0);
                    }
                }
            }
        }

    }
}
