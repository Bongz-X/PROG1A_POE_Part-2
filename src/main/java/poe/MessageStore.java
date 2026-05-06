package poe;

import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class MessageStore {
    private static final String FILE_PATH = "messages.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static ArrayList<Messages> loadMessages() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return mapper.readValue(file, new TypeReference<ArrayList<Messages>>() {});
            }
        } catch (IOException e) {
            System.out.println("Error loading messages: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void saveMessages(ArrayList<Messages> messages) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), messages);
            System.out.println("Messages saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving messages: " + e.getMessage());
        }
    }
}
