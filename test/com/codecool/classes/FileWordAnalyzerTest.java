package com.codecool.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private final String filePath = "src/main/resources/data/data.txt";
    private FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void beforeEach() {
        this.fileWordAnalyzer = new FileWordAnalyzer(1, 10);
    }

    @Test
    void testWordsOrderedAlphabetically() throws IOException {
        assertEquals(new ArrayList<>(Arrays.asList("ety", "hahom", "hat", "het", "keto", "klienc", "nety", "nyoc", "ot", "tisz")), this.fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void testWordsOrderedAlphabetically1to3() throws IOException {
        this.fileWordAnalyzer.filePartReader.setup(filePath, 1, 3);
        assertEquals(new ArrayList<>(Arrays.asList("ety", "hahom", "keto")), this.fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void testWordsContainingSubString() {
        assertAll("Tests words containing given substring",
                () -> assertEquals(new ArrayList<>(Arrays.asList("keto")), this.fileWordAnalyzer.getWordsContainingSubString("ket")),
                () -> assertEquals(new ArrayList<>(Arrays.asList("hahom", "hat")), this.fileWordAnalyzer.getWordsContainingSubString("a")),
                () -> assertEquals(new ArrayList<>(Arrays.asList("ety", "keto", "nety", "het")), this.fileWordAnalyzer.getWordsContainingSubString("et"))
        );
    }

    @Test
    public void testWordsArePalindrome() throws IOException {
        assertEquals(this.fileWordAnalyzer.getStringWhichPalindromes(), new ArrayList());
    }


}