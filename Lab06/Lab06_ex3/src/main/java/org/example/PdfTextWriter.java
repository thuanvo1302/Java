package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import static org.apache.pdfbox.pdmodel.font.PDType1Font.*;

public class PdfTextWriter implements TextWriter{
    @Override
    public void write(String text, String fileName ) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
            printWriter.println("Print pdf format: ");
            printWriter.print(text);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
