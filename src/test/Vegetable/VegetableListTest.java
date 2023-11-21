package Vegetable;

import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VegetableListTest {
    private VegetableList vegetableList;
    @Mock
    private Vegetable vegetable;
    @Mock
    private Vegetable vegetable2;

    @BeforeEach
    public void setUp() {
        this.vegetableList = new VegetableList();
        this.vegetable = new Vegetable("Carrot", "Summer", 100, 50);
        this.vegetable2 = new Vegetable("Potato", "Winter", 200, 70);
    }

    @Test
    public void testAdd() {
        vegetableList.add(vegetable);
        List<Vegetable> vegetables = vegetableList.findByName("Carrot");
        assertTrue(vegetables.contains(vegetable));
    }

    @Test
    public void testRemove() {
        vegetableList.add(vegetable);
        vegetableList.remove(vegetable);
        List<Vegetable> vegetables = vegetableList.findByName("Carrot");
        assertFalse(vegetables.contains(vegetable));
    }

    @Test
    public void testFindByCalories() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.findByCalories(150, 250);
        assertTrue(vegetables.contains(vegetable2));
        assertFalse(vegetables.contains(vegetable));
    }

    @Test
    public void testFindByPrice() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.findByPrice(60, 80);
        assertTrue(vegetables.contains(vegetable2));
        assertFalse(vegetables.contains(vegetable));
    }

    @Test
    public void testFindBySeazon() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.findBySeazon("Winter");
        assertTrue(vegetables.contains(vegetable2));
        assertFalse(vegetables.contains(vegetable));
    }

    @Test
    public void testFindByName() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.findByName("Potato");
        assertTrue(vegetables.contains(vegetable2));
        assertFalse(vegetables.contains(vegetable));
    }

    @Test
    public void testSortByCalories() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.sortByCalories();
        assertEquals(vegetables.get(0), vegetable);
        assertEquals(vegetables.get(1), vegetable2);
    }

    @Test
    public void testSortByPrice() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.sortByPrice();
        assertEquals(vegetables.get(0), vegetable);
        assertEquals(vegetables.get(1), vegetable2);
    }

    @Test
    public void testSortByName() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.sortByName();
        assertEquals(vegetables.get(1), vegetable2);
        assertEquals(vegetables.get(0), vegetable);
    }

    @Test
    public void testSortBySeazon() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        List<Vegetable> vegetables = vegetableList.sortBySeazon();
        assertEquals(vegetables.get(1), vegetable2);
        assertEquals(vegetables.get(0), vegetable);
    }

    @Test
    public void testSaveToFile() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        vegetableList.saveToFile();
        vegetableList = new VegetableList();
        vegetableList.readFromFile();
        List<Vegetable> vegetables = vegetableList.sortByCalories();
        assertEquals(vegetables.get(0), vegetable);
        assertEquals(vegetables.get(1), vegetable2);
    }

    @Test
    public void readFromFile() {
        vegetableList.add(vegetable);
        vegetableList.add(vegetable2);
        vegetableList.saveToFile();
        vegetableList = new VegetableList();
        vegetableList.readFromFile();
        List<Vegetable> vegetables = vegetableList.sortByCalories();
        assertEquals(vegetables.get(0), vegetable);
        assertEquals(vegetables.get(1), vegetable2);
    }
}