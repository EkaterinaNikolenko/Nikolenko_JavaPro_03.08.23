package edu.hillel.nikolenko.homeworks.homework21_serverClient.server;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        List<ClientConnection> activeConnections = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                ClientConnection clientConnection = new ClientConnection(clientSocket);
                activeConnections.add(clientConnection);
                System.out.println(activeConnections);
                System.out.println("[Server] " + clientConnection.getName() + " successfully connected.");

                new Thread(() -> {
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        String message;
                        while ((message = bufferedReader.readLine()) != null) {
                            System.out.println(message);
                            if (message.equals("-exit")) {
                                activeConnections.remove(clientConnection);
                                System.out.println(activeConnections);
                                System.out.println("[Server] " + clientConnection.getName() + " have been disconnected.");
                                clientSocket.close();
                            }
                            if (message.contains("-file ")) {
                                String path = message.replace("-file ", "");
                                paths.add(path);
                                System.out.println(paths);
                            }
                        }

                    } catch (SocketException | EOFException e) {
                        System.out.println("end stream");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }).start();
            }
        } catch (EOFException e) {
            System.out.println("end stream");
        }
    }

}
