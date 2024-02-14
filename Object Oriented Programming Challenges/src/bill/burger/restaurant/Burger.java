package bill.burger.restaurant;

import java.util.ArrayList;
import java.util.List;

 abstract class Burger {

    private String type;
    private double price;
    private List<Toppings> toppings = new ArrayList<>();

    public Burger(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    void addTopping(Toppings topping) {
        if(toppings.size() < 3) {
            toppings.add(topping);
        } else {
            System.out.println("You can't add more than 3 toppings!");
        }
    }

    public void addTopping(String... addedToppings) {
        if(addedToppings != null && addedToppings.length < 4) {
            for(String addedTopping : addedToppings) {
                Toppings topping = Toppings.getTopping(addedTopping);
                addTopping(topping);
            }
        } else {
            System.out.println("That topping does not exist or you can't add more than 3 toppings!");
        }
    }

    @Override
     public String toString() {
        StringBuilder burger = new StringBuilder("Burger: " + type + " - $" + price + "\n");
        for(Toppings topping : toppings) {
            burger.append(topping).append("\n");
            price = price + Toppings.getToppingPrice(topping);
        }
        burger.append("Burger price with toppings: $").append(price);
        return burger.toString();
    }

}
