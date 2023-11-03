package org.example;

import org.springframework.context.annotation.Bean;

import java.io.FileWriter;
import java.io.IOException;

public class PlainTextWriter implements TextWriter{
    @Override
    public void write(String text, String fileName ) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Successfully wrote to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

}
