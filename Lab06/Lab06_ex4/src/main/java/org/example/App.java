package org.example;

import org.example.ex4.TextEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import org.example.ex4.TextEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.ex4")
public class App 
{
    public static void main( String[] args ) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        TextEditor textEditor = context.getBean(TextEditor.class);

        textEditor.input("hello");
        textEditor.save("test.pdf");

        context.close();



    }
}
