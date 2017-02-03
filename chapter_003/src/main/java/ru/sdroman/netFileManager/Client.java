package ru.sdroman.netFileManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class Client.
 * @author sdroman
 * @since 01.02.2017
 * @version 0.1
 */
public class Client {

    /**
     * exit command.
     */
    private static final String EXIT = "exit";

    /**
     * download command.
     */
    private static final String DOWNLOAD = "download";

    /**
     * upload command.
     */
    private static final String UPLOAD = "upload";

    /**
     * run client.
     * @throws IOException exception
     */
    public void clientRun() throws IOException {
        Settings settings = new Settings("app.properties");
        int port = settings.getPort();
        String address = settings.getAddress();
        InetAddress inetAddress = InetAddress.getByName(address);
        try (Socket socket = new Socket(inetAddress, port)) {
            InputStream inStream = socket.getInputStream();
            OutputStream outStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inStream);
            DataOutputStream out = new DataOutputStream(outStream);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                System.out.println(in.readUTF());
                do {
                    System.out.print(in.readUTF());
                    line = reader.readLine();
                    Command command = new Command(line);
                    out.writeUTF(line);
                    out.flush();
                    if (DOWNLOAD.equalsIgnoreCase(command.getAction())) {
                        downloadFile(in);
                    }
                    if (UPLOAD.equalsIgnoreCase(command.getAction())) {
                        uploadFile(out, line);
                    }
                    System.out.println(in.readUTF());
                    if (!EXIT.equals(line)) {
                        System.out.println(in.readUTF());
                    }
                } while (!EXIT.equals(line));
            }
        }
    }

    /**
     * Download file.
     * @param dis DataInputStream
     * @throws IOException exception
     */
    public void downloadFile(DataInputStream dis) throws IOException {
        final String er = "error";
        if (!er.equals(dis.readUTF())) {
            System.out.println();
            long fileSize = dis.readLong();
            String fileName = dis.readUTF();
            byte[] buf = new byte[(int) fileSize];

            String downloadPath = new Settings("app.properties").getDownloadPath();
            try (FileOutputStream fos = new FileOutputStream(downloadPath.concat(fileName));
                 BufferedOutputStream bis = new BufferedOutputStream(fos)) {
                dis.readFully(buf, 0, buf.length);
                bis.write(buf);
                bis.flush();
            }
        } else {
            System.out.println(er);
        }
    }

    /**
     * Upload file.
     * @param dos DataOutputStream
     * @param line String
     * @throws IOException exception
     */
    public void uploadFile(DataOutputStream dos, String line) throws IOException {
        Command command = new Command(line);
        String fileName = command.getParam();
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis)) {
            dos.writeLong(file.length());
            dos.flush();
            dos.writeUTF(file.getName());
            dos.flush();
            byte[] buf = new byte[(int) file.length()];
            bis.read(buf, 0, buf.length);
            dos.write(buf, 0, buf.length);
            dos.flush();
        }
    }

    /**
     * main.
     * @param args String[]
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.clientRun();
    }
}
