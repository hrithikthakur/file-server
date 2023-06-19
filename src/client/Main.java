package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final String SERVER_IP_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 23456;
    private static final String EXIT_COMMAND = "EXIT";
    private static final String CREATE_FILE_COMMAND = "2";
    private static final String GET_FILE_COMMAND = "1";
    private static final String DELETE_FILE_COMMAND = "3";

    private static final String SUCCESS_RESPONSE_CODE = "200";
    private static final String FORBIDDEN_RESPONSE_CODE = "403";
    private static final String NOT_FOUND_RESPONSE_CODE = "404";

    private static final String PUT_COMMAND = "PUT";
    private static final String GET_COMMAND = "GET";
    private static final String DELETE_COMMAND = "DELETE";

    public static void main(String[] args) {
        System.out.print("Enter action (1 - get a file, 2 - create a file, 3 - delete a file): ");

        try (Socket socket = new Socket(SERVER_IP_ADDRESS, SERVER_PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             Scanner sc = new Scanner(System.in);
            )
             {
                 String cmd = sc.next();
                if (cmd.equalsIgnoreCase(EXIT_COMMAND)) {
                    output.writeUTF(cmd);
                    System.exit(0);
                }
                 System.out.print("Enter file name: ");
                 String fileName = sc.next();
            switch (cmd) {
                case GET_FILE_COMMAND:
                    getFile(input, output, fileName);
                    break;
                case CREATE_FILE_COMMAND:
                    createFile(input, output, fileName);
                    break;
                case DELETE_FILE_COMMAND:
                    deleteFile(input, output, fileName);
                    break;
                default:
                    System.out.println("Invalid cmd");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void createFile(DataInputStream input, DataOutputStream output, String fileName) throws IOException {
            output.writeUTF(PUT_COMMAND + " " + fileName);
            String msg = input.readUTF();
            if (msg.equals(FORBIDDEN_RESPONSE_CODE)) System.out.println("The response says that creating the file was forbidden!");
            else System.out.print("Enter file content: ");
            Scanner scanner = new Scanner(System.in);
            String content = scanner.nextLine();
            scanner.close();
            output.writeUTF(content);
            if (msg.equals(SUCCESS_RESPONSE_CODE)) System.out.println("The response says that the file was created!");
    }

    static void getFile(DataInputStream input, DataOutputStream output, String fileName) throws IOException {
            output.writeUTF(GET_COMMAND + " " + fileName);
            String msg = input.readUTF();
            if (msg.equals(NOT_FOUND_RESPONSE_CODE)) System.out.println("The response says that the file was not found!");
            else if (msg.startsWith(SUCCESS_RESPONSE_CODE)) {
                System.out.println("The content of the file is: " + msg.substring(4));
            }

    }

    static void deleteFile(DataInputStream input, DataOutputStream output, String fileName) throws IOException {
            output.writeUTF(DELETE_COMMAND + " " + fileName);
            String msg = input.readUTF();
            if (msg.equals(NOT_FOUND_RESPONSE_CODE)) System.out.println("The response says that the file was not found!");
            else if (msg.equals(SUCCESS_RESPONSE_CODE)) System.out.println("The response says that the file was deleted!");
    }
}
