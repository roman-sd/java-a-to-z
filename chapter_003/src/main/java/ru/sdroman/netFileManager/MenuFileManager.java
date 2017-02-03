package ru.sdroman.netFileManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

/**
 * Class MenuFileManager.
 * @author sdroman
 * @since 01.02.2017
 * @version 0.1
 */
public class MenuFileManager {

    /**
     * default capacity.
     */
    private static final int DEFAULT_CAPACITY = 5;

    /**
     * dir command.
     */
    private static final String DIR = "dir";

    /**
     * exit command.
     */
    private static final String EXIT = "exit";

    /**
     * separator.
     */
    private final String separator = System.getProperty("line.separator");

    /**
     * DataInputStream to read data.
     */
    private DataInputStream dis;

    /**
     * DataOutputStream.
     */
    private DataOutputStream dos;

    /**
     * Actions from file manager.
     */
    private UserAction[] actions = new UserAction[DEFAULT_CAPACITY];

    /**
     * Current path.
     */
    private Path path;

    /**
     * Home path.
     */
    private Path homePath;

    /**
     * commands.
     */
    private final String[] commandArray = new String[]{"cd", "download", "upload", "ls", "help"};

    /**
     * Constructs new file manager.
     * @param dis DataInputStream
     * @param dos DataOutPutStream
     * @param propFileName String property file
     * @throws IOException exception
     */
    MenuFileManager(DataInputStream dis, DataOutputStream dos, String propFileName) throws IOException {
        this.dis = dis;
        this.dos = dos;
        this.path = Paths.get(new Settings(propFileName).getHomePath());
        this.homePath = Paths.get(new Settings(propFileName).getHomePath());
    }

    /**
     * Adds actions.
     */
    void fillActions() {
        int count = 0;
        this.actions[count++] = new ChangeDir(String.format("%s\t%39s", "cd [path]", "change directory"));
        this.actions[count++] = new DownloadFile(String.format("%s\t%28s", "download [fileName]", "download file"));
        this.actions[count++] = new UploadFile(String.format("%s\t%31s", "upload [path]//[filename]", "upload file in home path"));
        this.actions[count++] = new CurrentDir(String.format("%s\t%45s", "ls", "home directory"));
        this.actions[count] = new Help(String.format("%s\t%40s", "help", "list commands"));
    }

    /**
     * Selects actions by key.
     * @param key String
     * @return String path
     * @throws IOException exception
     */
    String select(String key) throws IOException {
        Command userCommand = new Command(key);
        int count = 0;
        final int flag = 4;
        for (String command : commandArray) {
            if (EXIT.equalsIgnoreCase(userCommand.getAction())) {
                dos.writeUTF(EXIT);
                dos.flush();
                return EXIT;
            }
            if (DIR.equalsIgnoreCase(userCommand.getAction())) {
                this.actions[0].execute(userCommand.getParam());
                break;
            } else {
                if (command.equalsIgnoreCase(userCommand.getAction())) {
                    this.actions[count].execute(userCommand.getParam());
                    break;
                }
            }
            count++;
            if (count > flag)  {
                dos.writeUTF("bad command");
            }
        }
        return path.toString();
    }

    /**
     * Class DownloadFile.
     */
    private class DownloadFile extends BaseAction {

        /**
         * Constructs new DownloadFile object.
         * @param name String
         */
        DownloadFile(String name) {
            super(name);
        }

        /**
         * download file.
         * @param fileName String file to download.
         */
        @Override
        public void execute(String fileName)  {
            try {
                if (Files.exists(path.resolve(fileName))) {
                    File file = new File(path.resolve(fileName).toString());
                    System.out.println(file.toString());
                    try (FileInputStream fis = new FileInputStream(file);
                         BufferedInputStream bis = new BufferedInputStream(fis)) {
                        dos.writeUTF("downloading..");
                        dos.writeLong(file.length());
                        dos.flush();
                        dos.writeUTF(file.getName());
                        dos.flush();
                        byte[] buf = new byte[(int) file.length()];
                        bis.read(buf, 0, buf.length);
                        dos.write(buf, 0, buf.length);
                        dos.flush();
                        dos.writeUTF("Success.");
                    }
                } else {
                    dos.writeUTF("error");
                    dos.writeUTF("file not found.");
                    throw new NoSuchElementException("file not found");
                }

            } catch (IOException  | NoSuchElementException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * class UploadFile.
     */
    private class UploadFile extends BaseAction {

        /**
         * Constructs new UploadFile object.
         * @param name String
         */
        UploadFile(String name) {
            super(name);
        }

        /**
         * upload file.
         * @param name String
         */
        @Override
        public void execute(String name) {
            try {
                long fileSize = dis.readLong();
                String fileName = dis.readUTF();
                byte[] buf = new byte[(int) fileSize];
                try (FileOutputStream fos = new FileOutputStream(homePath.resolve(fileName).toString());
                     BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                    dis.readFully(buf, 0, buf.length);
                    bos.write(buf);
                    bos.flush();
                    dos.writeUTF("Success.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class ChangeDir.
     */
    private class ChangeDir extends BaseAction {

        /**
         * Constructs new ChangeDir object.
         * @param name String
         */
        ChangeDir(String name) {
            super(name);
        }

        /**
         * change directory.
         * @param userPath String
         */
        @Override
        public void execute(String userPath) {
            try {
                path = path.resolve(userPath).normalize();
                if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    dos.writeUTF("no path");
                    dos.flush();
                    throw new NoSuchFileException("no directory");
                }
                File file = new File(path.toString());
                StringBuilder builder = new StringBuilder();
                for (File sub : file.listFiles()) {
                    builder.append(sub.getName()).append(separator);
                }
                dos.writeUTF(builder.toString());
            } catch (NoSuchFileException e) {
                path = path.getParent();
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class CurrentDir.
     */
    private class CurrentDir extends BaseAction {

        /**
         * Constructs new CurrentDir object.
         * @param name String
         */
        CurrentDir(String name) {
            super(name);
        }

        /**
         * List files and folders.
         * @param dir String
         */
        @Override
        public void execute(String dir) {
            path = homePath;
            StringBuilder str = new StringBuilder();
            File file = new File(homePath.normalize().toString());
            for (File sub : file.listFiles()) {
                str.append(sub.getName()).append(separator);
            }
            try {
                dos.writeUTF(str.toString());
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class Help.
     */
    private class Help extends BaseAction {

        /**
         * Constructs new Help object.
         * @param name String
         */
        Help(String name) {
            super(name);
        }

        /**
         * List commands.
         * @param dir String
         */
        @Override
        public void execute(String dir) {
            StringBuilder builder = new StringBuilder();
            for (UserAction action : actions) {
                if (action != null) {
                    builder.append(action.info()).append(separator);
                }
            }
            builder.append(String.format("%s\t%67s", "dir", "list of files and folders")).append(separator);
            try {
                dos.writeUTF(builder.append(String.format("%s\t%31s", "exit", "quit")).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
