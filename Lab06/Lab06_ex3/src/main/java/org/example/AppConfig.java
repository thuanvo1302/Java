package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {
    @Bean
    public TextWriter plainTextWriter(){
        return new PlainTextWriter();
    }
    @Bean TextWriter pdfTextWriter(){
        return new PdfTextWriter();
    }
    @Bean
    public TextEditor textEditor(){return new TextEditor();}

}
