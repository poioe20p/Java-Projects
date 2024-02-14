package bill.burger.restaurant;

public class Main {

    public static void main(String[] args) {
        RegularBurger regularBurger = new RegularBurger();
        regularBurger.addTopping("LETTUCE", "TOMATO", "ONION");
        Meal regularBurgerMeal = new Meal(regularBurger, "Coke", "Medium",
                "Fries");
        System.out.println(regularBurgerMeal);


        CheeseBurger cheeseBurger = new CheeseBurger();
        cheeseBurger.addTopping("BACON", "EXTRA CHEESE", "MAYO");
        Meal cheeseBurgerMeal = new Meal(cheeseBurger, "Pepsi", "Large",
                "Onion Rings");
        System.out.println(cheeseBurgerMeal);



    }

}
