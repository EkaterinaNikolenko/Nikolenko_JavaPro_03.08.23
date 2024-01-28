package edu.hillel.nikolenko.homeworks.homework21_serverClient.server;

import java.net.Socket;
import java.util.Random;

public class ClientConnection {
    private String name;
    private long connectionTime;
    private Socket socket;

    public ClientConnection(Socket socket) {
        this.name = generateName();
        this.connectionTime = System.currentTimeMillis();
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public long getConnectionTime() {
        return connectionTime;
    }

    public Socket getSocket() {
        return socket;
    }

    private String generateName() {
        return "client-" + Math.round(Math.random() * 100);
    }
}
