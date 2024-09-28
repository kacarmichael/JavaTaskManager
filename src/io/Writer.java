package io;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Writer {

    private String outFile;

    public Writer(String outFile) {
        this.outFile = outFile;
    }

    public String toCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void write(String[] data) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(this.outFile, true))) {
            for (String datum : data) {
                writer.print(datum);
                writer.print(",");
            }
            writer.println();
        }
        catch (FileNotFoundException e) {
            System.out.println("Invalid File Name: " + this.outFile);
        }
    }
}
