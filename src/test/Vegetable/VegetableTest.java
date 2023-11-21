package Vegetable;

import main.Vegetable.Vegetable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VegetableTest {

    private Vegetable vegetable;
    private Vegetable vegetable1;
    private Vegetable vegetable2;

    @BeforeEach
    public void setUp() {
        this.vegetable = new Vegetable("Carrot", "Summer", 100, 50);
        this.vegetable1 = new Vegetable("Carrot", "Summer", 100, 50);
        this.vegetable2 = new Vegetable("Potato", "Winter", 200, 70);
    }

    @Test
    public void testSetName() {
        vegetable.setName("Potato");
        assertEquals("Potato", vegetable.getName());
    }

    @Test
    public void testSetNameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> vegetable.setName(""));
    }

    @Test
    public void testSetNameWithNull() {
        assertThrows(IllegalArgumentException.class, () -> vegetable.setName(null));
    }

    @Test
    public void testEquals() {
        assertEquals(vegetable1, vegetable);
    }

    @Test
    public void testNotEquals() {
        assertNotEquals(vegetable1, vegetable2);
    }

    @Test
    public void testToString() {
        assertEquals("Назва: Carrot Сезон: Summer Калорії на 100г: 100 Ціна: 50", vegetable.toString());
    }
}