package Vegetable;

public class Vegetable {
    private String name;
    private String seazon;
    private int caloriesPer100g;
    private int price;

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
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setSeazon(String seazon){
        if (seazon == null || seazon.trim().isEmpty()) {
            throw new IllegalArgumentException("Seazon cannot be null or empty");
        }
        this.seazon = seazon;
    }

    public void setCaloriesPer100g(int caloriesPer100g){
        if (caloriesPer100g < 0) {
            throw new IllegalArgumentException("Calories per 100g cannot be negative");
        }
        this.caloriesPer100g = caloriesPer100g;
    }

    public void setPrice(int price){
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Seazon: " + seazon + " Calories per 100g: " + caloriesPer100g + " Price: " + price;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Vegetable vegetable = (Vegetable)obj;
        return (name.equals(vegetable.name) && seazon.equals(vegetable.seazon) && caloriesPer100g == vegetable.caloriesPer100g && price == vegetable.price);
    }
}