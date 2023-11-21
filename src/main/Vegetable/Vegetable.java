package main.Vegetable;

public class Vegetable {
    private String name;
    private final String seazon;
    private final int caloriesPer100g;
    private final int price;

    public Vegetable(String name, String seazon, int caloriesPer100g, int price){
        this.name = name;
        this.seazon = seazon;
        this.caloriesPer100g = caloriesPer100g;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getSeazon(){
        return seazon;
    }

    public int getCaloriesPer100g(){
        return caloriesPer100g;
    }

    public int getPrice(){
        return price;
    }

    public void setName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою або null");
        }
        this.name = name;
    }

    @Override
    public String toString(){
        return "Назва: " + name + " Сезон: " + seazon + " Калорії на 100г: " + caloriesPer100g + " Ціна: " + price;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Vegetable vegetable = (Vegetable)obj;
        return (name.equals(vegetable.name) && seazon.equals(vegetable.seazon) && caloriesPer100g == vegetable.caloriesPer100g && price == vegetable.price);
    }
}