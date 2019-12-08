package com.codecool.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "data/nosuchfile.txt";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine > toLine) {
            throw new IllegalArgumentException("fromLine can't be less than toLine");
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine can't be less than 1");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                builder.append(line).append("\n");
            }
            return builder.toString();
        }
    }

    public String readLines() throws IOException {
        String fullContent = this.read();
        String[] lines = fullContent.split("\n");
        StringBuilder builder = new StringBuilder();
        int index = 1;
        for (String line: lines) {
            if (index >= this.fromLine && index <= this.toLine) {
                builder.append(line);
                if (index != this.toLine) {
                    builder.append("\n");
                } else {
                    break;
                }
            }
            index ++;
        }
        return builder.toString();
    }


}
