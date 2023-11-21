package Vegetable.Salad;

import main.Vegetable.Salad.HistoryOfSalads;
import main.Vegetable.Salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryOfSaladsTest {
    private HistoryOfSalads historyOfSalads;
    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() {
        historyOfSalads = new HistoryOfSalads();
    }

    @Test
    public void testAddSalad() {
        Salad salad = new Salad();
        historyOfSalads.addSalad(salad);
        assertEquals(1, historyOfSalads.getSalads().size());
    }

    @Test
    public void testFindByName() {
        Salad salad = new Salad();
        salad.setName("Test Salad");
        historyOfSalads.addSalad(salad);
        Salad foundSalad = historyOfSalads.findByName("Test Salad");
        assertNotNull(foundSalad);
        assertEquals("Test Salad", foundSalad.getName());
    }

    @Test
    public void testSaveAndReadFromFile() {
        Salad salad = new Salad();
        salad.setName("Test Salad");
        historyOfSalads.addSalad(salad);
        historyOfSalads.saveToFile();
        historyOfSalads = new HistoryOfSalads();
        historyOfSalads.readFromFile();
        Salad foundSalad = historyOfSalads.findByName("Test Salad");
        assertNotNull(foundSalad);
        assertEquals("Test Salad", foundSalad.getName());
    }

    @Test
    public void testFindByNameNotFound() {
        Salad salad = new Salad();
        salad.setName("Test Salad");
        historyOfSalads.addSalad(salad);
        Salad foundSalad = historyOfSalads.findByName("Nonexistent Salad");
        assertNull(foundSalad);
    }

    @Test
    public void printSaladsTest() {
        Salad salad = new Salad();
        salad.setName("Test Salad");
        historyOfSalads.addSalad(salad);
        historyOfSalads.printSalads();
    }
}