package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final int SERVER_PORT = 23456;
    private static final String PUT_COMMAND = "PUT";
    private static final String GET_COMMAND = "GET";
    private static final String DELETE_COMMAND = "DELETE";
    private static final String EXIT_COMMAND = "EXIT";

    private static final String SUCCESS_RESPONSE_CODE = "200";
    private static final String FORBIDDEN_RESPONSE_CODE = "403";
    private static final String NOT_FOUND_RESPONSE_CODE = "404";

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println("Server started!");
        while (true) {
            try (ServerSocket server = new ServerSocket(SERVER_PORT);
                 Socket socket = server.accept(); // accepting a new client
                 DataInputStream input = new DataInputStream(socket.getInputStream());
                 DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            ) {
                String msg = input.readUTF(); // reading a message
                if (msg.startsWith(PUT_COMMAND)) {
                    File file = new File("./src/server/data/" + msg.substring(4));

                    if (file.exists()) {
                        output.writeUTF(FORBIDDEN_RESPONSE_CODE);
                    } else {
                        FileWriter fileWriter = new FileWriter(file, true);
                        output.writeUTF(SUCCESS_RESPONSE_CODE);
                        String content = input.readUTF();
                        fileWriter.write(content);
                        fileWriter.close();
                    }
                } else if (msg.startsWith(GET_COMMAND)) {
                    File file = new File("./src/server/data/" + msg.substring(4));
                    if (file.exists()) {
//                    send the content of the file
                        output.writeUTF(SUCCESS_RESPONSE_CODE + " " + readFileAsString(file.getPath()));
                    } else {
                        output.writeUTF(NOT_FOUND_RESPONSE_CODE);
                    }
                } else if (msg.startsWith(DELETE_COMMAND)) {
                    File file = new File("./src/server/data/" + msg.substring(7));
                    if (file.exists()) {
                        file.delete();
                        output.writeUTF(SUCCESS_RESPONSE_CODE);
                    } else {
                        output.writeUTF(NOT_FOUND_RESPONSE_CODE);
                    }
                } else if (msg.equalsIgnoreCase(EXIT_COMMAND)) {
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}