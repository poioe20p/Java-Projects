package bill.burger.restaurant;

public class DeluxeBurger extends Burger {
    public DeluxeBurger() {
        super("Deluxe Burger", 4.99);
    }

    @Override
    public void addTopping(String... addedToppings) {
        if(addedToppings != null && addedToppings.length < 3) {
            for(String addedTopping : addedToppings) {
                Toppings topping = Toppings.getTopping(addedTopping);
                addTopping(topping);
            }
        } else {
            System.out.println("That topping is not available for this burger and you can't add more than 2 toppings");
        }
    }
}
