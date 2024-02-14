package bill.burger.restaurant;

class Meal {

    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    Meal (Burger burger, Drink drink, SideItem sideItem) {

        if(burger == null || drink == null || sideItem == null) {
            throw new IllegalArgumentException("Meal must have a burger, drink and side item");
        }

        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    Meal (Burger burger, String drink, String drinkSize, String sideItem) {
        this(burger, new Drink(drink, drinkSize), SideItem.getSideItem(sideItem));
    }

    double getPrice() {
        return (burger.getPrice() + drink.getPrice() + SideItem.getSideItemPrice(sideItem));
    }

    @Override
    public String toString() {
        return burger.toString() + "\n" + drink.toString() + "\n" + sideItem.toString() + "\nMeal Total: $" + getPrice() + "\n";
    }
}
