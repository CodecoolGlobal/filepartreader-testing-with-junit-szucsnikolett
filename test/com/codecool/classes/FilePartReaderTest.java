package com.codecool.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private final String filePath = "src/main/resources/data/data.txt";
    private FilePartReader filePartReader;

    @BeforeEach
    void beforeEach() {
        this.filePartReader = new FilePartReader();
    }

    @Test
    void testReadLinesWithDefaultFields() {
        assertThrows(IOException.class, () -> {
            this.filePartReader.readLines();
        });
    }
    @Test
    public void testSetupWithBadFromLineParameter() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.filePartReader.setup(this.filePath, 0, 1);
        });
    }

    @Test
    public void testSetupWithBadToLineParameter() {
        assertThrows(IllegalArgumentException.class, () ->{
            this.filePartReader.setup(this.filePath, 2, 1);
        });
    }

    @Test
    void testReadLines() throws Exception {
        this.filePartReader.setup(filePath, 1, 10);
        assertEquals("ety\nketo\nhahom\nnety\not\nhat\nhet\nnyoc\nklienc\ntisz", this.filePartReader.readLines());
    }

    @Test
    void testReadLines1to5() throws Exception {
        this.filePartReader.setup(filePath, 1, 5);
        assertEquals("ety\nketo\nhahom\nnety\not", this.filePartReader.readLines());
    }

    @Test
    void testReadFirstLine() throws Exception {
        this.filePartReader.setup(filePath, 1, 1);
        assertEquals("ety", this.filePartReader.readLines());
    }

    @Test
    void testReadLines3to6() throws Exception {
        this.filePartReader.setup(filePath, 3, 6);
        assertEquals("hahom\nnety\not\nhat", this.filePartReader.readLines());
    }

    @Test
    void testReadLinesOutOfBound() throws Exception {
        this.filePartReader.setup(filePath, 1, 15);
        assertEquals("ety\nketo\nhahom\nnety\not\nhat\nhet\nnyoc\nklienc\ntisz\n", this.filePartReader.readLines());
    }

}