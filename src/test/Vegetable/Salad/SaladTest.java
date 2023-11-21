package Vegetable.Salad;

import main.Vegetable.Salad.HistoryOfSalads;
import main.Vegetable.Salad.Salad;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaladTest {

    @Mock
    private Salad salad;

    @Mock
    private VegetableList vegetableList;

    @Mock
    private HistoryOfSalads historyOfSalads;

    @BeforeEach
    public void setUp() {
        this.salad = new Salad();
        this.vegetableList = new VegetableList();
        this.historyOfSalads = new HistoryOfSalads();
        vegetableList.add(new Vegetable("Carrot", "Summer", 100, 50));
        vegetableList.add(new Vegetable("Potato", "Winter", 200, 70));
    }

    @Test
    public void testSetName() {
        salad.setName("Summer Salad");
        assertEquals("Summer Salad", salad.getName());
    }

    @Test
    public void testUpdateCaloriesPer100g() {
        salad.getVegetables().add(new Vegetable("Carrot", "Summer", 100, 50));
        salad.getVegetables().add(new Vegetable("Potato", "Winter", 200, 70));
        salad.updateCaloriesPer100g();
        assertEquals(300, salad.getCaloriesPer100g());
    }

    @Test
    public void testGetCaloriesPer100g() {
        salad.getVegetables().add(new Vegetable("Carrot", "Summer", 100, 50));
        salad.getVegetables().add(new Vegetable("Potato", "Winter", 200, 70));
        salad.updateCaloriesPer100g();
        assertEquals(300, salad.getCaloriesPer100g());
    }

    @Test
    public void printSalad() {
        salad.setName("Summer Salad");
        salad.getVegetables().add(new Vegetable("Carrot", "Summer", 100, 50));
        salad.getVegetables().add(new Vegetable("Potato", "Winter", 200, 70));
        salad.updateCaloriesPer100g();
        salad.printSalad();
    }

    @Test
    public void testSaveSaladToHistory() {
        salad.setName("Summer Salad");
        salad.getVegetables().add(new Vegetable("Carrot", "Summer", 100, 50));
        salad.getVegetables().add(new Vegetable("Potato", "Winter", 200, 70));
        salad.updateCaloriesPer100g();
        salad.saveSaladToHistory(historyOfSalads);
    }
}