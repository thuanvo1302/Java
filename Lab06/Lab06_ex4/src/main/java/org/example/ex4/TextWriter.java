package org.example.ex4;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface TextWriter {
    public void write(String fileName, String text) throws IOException;
}
