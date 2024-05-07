package org.example;

import java.io.*;

public class SingletonFileHandler {
    private static SingletonFileHandler instance;
    private File file;

    private SingletonFileHandler() {
    }

    public static synchronized SingletonFileHandler getInstance() {
        if (instance == null) {
            instance = new SingletonFileHandler();
        }
        return instance;
    }

    public void openFile(String filename) {
        file = new File(filename);
    }

    public String readFile() {
        if (file != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                return content.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return "Ошибка чтения";
            }
        } else {
            return "Ошибка";
        }
    }

    public void writeToFile(String data) {
        if (file != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(data);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Ошибка");
        }
    }
}
