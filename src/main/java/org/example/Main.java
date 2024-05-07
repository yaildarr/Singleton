package org.example;

public class Main {
    public static void main(String[] args) {
        SingletonFileHandler fileHandler = SingletonFileHandler.getInstance();

        fileHandler.openFile("example.txt");
        fileHandler.writeToFile("Hello, World!");

        String fileContent = fileHandler.readFile();
        System.out.println("File content: " + fileContent);
    }
}
