package ru.sdroman.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class BotClient.
 *
 * @author sdroman
 * @version 0.1
 * @since 05.02.17
 */
public class BotClient {

    /**
     * Socket.
     */
    private Socket socket;

    /**
     * Constructs the new BotClient objects.
     *
     * @param socket Socket
     */
    public BotClient(Socket socket) {
        this.socket = socket;
    }

    /**
     * Start client.
     *
     * @throws IOException exception
     */
    public void clientRun() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String str = "";
        String line;
        do {
            line = console.nextLine();
            out.println(line);
            if (!"exit".equalsIgnoreCase(line)) {
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            }
        } while (!"exit".equalsIgnoreCase(line));
    }

    /**
     * Main method.
     *
     * @param args String[]
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        final int port = 8981;
        try (final Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), port)) {
            new BotClient(socket).clientRun();
        }
    }
}
