package bill.burger.restaurant;

class Drink {

    private enum DrinkTypes {
        Coke,
        Diet_Coke,
        Sprite,
        Fanta,
        Water,
        Beer,
        Wine,
        Cofeee,
        Milkshake,
        Pepsi,
        Tea;

        public static DrinkTypes getDrinkType(String drinkType) {
            return switch (drinkType.toUpperCase()) {
                case "COKE" -> Coke;
                case "DIET COKE" -> Diet_Coke;
                case "SPRITE" -> Sprite;
                case "FANTA" -> Fanta;
                case "WATER" -> Water;
                case "BEER" -> Beer;
                case "WINE" -> Wine;
                case "COFFEE" -> Cofeee;
                case "MILKSHAKE" -> Milkshake;
                case "TEA" -> Tea;
                case "PEPSI" -> Pepsi;
                default -> throw new IllegalArgumentException("Drink type not found");
            };
        }
    }
    private DrinkTypes drinkTypes;
    private double price;

    public Drink(String drinkType, String size) {
        this.drinkTypes = DrinkTypes.getDrinkType(drinkType);
        this.price = switch (size) {
            case "Small" -> 1.0;
            case "Medium" -> 1.5;
            case "Large" -> 2.0;
            default -> throw new IllegalStateException("Unexpected value: " + size);
        };
    }

    double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink: " + drinkTypes + " - $" + price;
    }
}
