package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServer {

    private List<String> storage = new ArrayList<>();

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            String[] cmd = input.split("\\s+");
            if (cmd[0].equals("add")) {
                addFile(cmd[1], storage);
            } else if (cmd[0].equals("get")) {
                getFile(cmd[1], storage);
            } else if (cmd[0].equals("delete")) {
                deleteFile(cmd[1], storage);
            }
        }
    }


    private static void addFile(String fileName, List<String> storage) {
        if (fileName.matches("file([1-9]|10)") && !storage.contains(fileName)) {
            storage.add(fileName);
            System.out.printf("The file %s added successfully\n", fileName);
        } else {
            System.out.println("Cannot add the file " + fileName);
        }
    }

    private static void getFile(String fileName, List<String> storage) {
        if (storage.contains(fileName)) {
            System.out.printf("The file %s was sent\n", fileName);
        } else {
            System.out.printf("The file %s not found\n", fileName);
        }
    }

    private static void deleteFile(String fileName, List<String> storage) {
        if (storage.contains(fileName)) {
            storage.remove(fileName);
            System.out.printf("The file %s was deleted\n", fileName);
        } else {
            System.out.printf("The file %s not found\n", fileName);
        }
    }


}
