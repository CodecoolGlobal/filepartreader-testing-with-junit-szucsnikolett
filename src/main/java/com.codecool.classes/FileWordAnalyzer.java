package com.codecool.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    public FilePartReader filePartReader = new FilePartReader();

    public FileWordAnalyzer(int from, int to) {
        filePartReader.setup("src/main/resources/data/data.txt", from, to);
    }

    public List<String> getWordsOrderedAlphabetically () throws IOException {
        List<String> lineList = getLinesAsList();
        Collections.sort(lineList);
        return lineList;
    }

    private List<String> getLinesAsList() throws IOException {
        String lines = this.filePartReader.readLines();
        return Arrays.asList(lines.split("\n"));
    }

    public List getWordsContainingSubString(String subString) throws IOException {
        List<String> output = new ArrayList<>();
        for (String word : getLinesAsList()) {
            if (word.contains(subString)) {
                output.add(word);
            }
        }
        return output;
    }

    public List getStringWhichPalindromes() throws IOException {
        List<String> palindromes = new ArrayList<>();
        for (String word : getLinesAsList()) {
            if (word.equals(new StringBuilder(word).reverse().toString())){
                palindromes.add(word);
            }
        }
        return palindromes;
    }
}
