package ru.sdroman.netFileManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class Server.
 * @author sdroman
 * @since 01.02.2017
 * @version 0.1
 */
public class Server {

    /**
     * end command.
     */
    private static final String END = "exit";

    /**
     * input.
     */
    private Input input;

    /**
     * Constructs new Server object.
     * @param input Input
     */
    public Server(Input input) {
        this.input = input;
    }

    /**
     * Run server.
     * @throws IOException exception
     */
    public void serverRun() throws IOException {
        Settings settings = new Settings("app.properties");
        int port = settings.getPort();
        String homePath = settings.getHomePath();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting connection to server..");
            try (Socket socket = serverSocket.accept()) {

                System.out.println("Client connected.");
                InputStream inStream = socket.getInputStream();
                OutputStream outStream = socket.getOutputStream();

                try (DataInputStream in = new DataInputStream(inStream);
                     DataOutputStream out = new DataOutputStream(outStream)) {

                    MenuFileManager menu = new MenuFileManager(in, out, "app.properties");
                    menu.fillActions();
                    String line = homePath.replace("//", "");
                    while (!END.equals(line)) {
                        out.writeUTF("help - commands, exit - quit");
                        line = menu.select(input.ask(new StringBuilder(line).append(">").toString(), in, out));
                    }
                }
            }
        }
    }

    /**
     * main.
     * @param args String[]
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server(new ConsoleInput());
        server.serverRun();

    }
}
