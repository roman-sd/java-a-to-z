package ru.sdroman.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class BotServer.
 *
 * @author sdroman
 * @version 0.1
 * @since 05.02.17
 */
public class BotServer {

    /**
     * Socket.
     */
    private final Socket socket;

    /**
     * Constructs the new BotServer objects.
     *
     * @param socket Socket
     */
    public BotServer(Socket socket) {
        this.socket = socket;
    }

    /**
     * Start server.
     *
     * @throws IOException exception
     */
    public void startServer() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello oracle".equalsIgnoreCase(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else {
                if (!"exit".equalsIgnoreCase(ask)) {
                    out.println("I don't understand");
                    out.println();
                }
            }
        } while (!"exit".equalsIgnoreCase(ask));
    }

    /**
     * Main method.
     *
     * @param args String[]
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        final int port = 8981;
        try (final Socket socket = new ServerSocket(port).accept()) {
            new BotServer(socket).startServer();
        }
    }
}
