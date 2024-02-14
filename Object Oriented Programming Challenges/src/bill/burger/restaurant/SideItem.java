package bill.burger.restaurant;

public enum SideItem {

    FRIES,
    CHIPS,
    ONION_RINGS,
    FRUIT,
    FRIED_CHICKEN,
    CHOCOLATE_CAKE,
    NUGGETS,
    ICE_CREAM,
    SALAD;

    static SideItem getSideItem(String sideItem) {
        return switch (sideItem.toUpperCase()) {
            case "FRIES" -> FRIES;
            case "CHIPS" -> CHIPS;
            case "ONION RINGS" -> ONION_RINGS;
            case "SALAD" -> SALAD;
            case "FRUIT" -> FRUIT;
            case "FRIED CHICKEN" -> FRIED_CHICKEN;
            case "CHOCOLATE CAKE" -> CHOCOLATE_CAKE;
            default -> null;
        };
    }

    static double getSideItemPrice(SideItem sideItem) {
        return switch (sideItem) {
            case FRIES, CHIPS, ONION_RINGS, CHOCOLATE_CAKE, NUGGETS, ICE_CREAM -> 1.5;
            case FRIED_CHICKEN -> 2.8;
            case SALAD -> 2.0;
            case FRUIT -> 0.8;
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case FRIES, CHIPS, ONION_RINGS,
                    CHOCOLATE_CAKE, ICE_CREAM -> "SideItem: Fries - $1.50";
            case FRUIT -> "SideItem: Fruit - $0.80";
            case FRIED_CHICKEN -> "SideItem: Fried Chicken - $2.80";
            case NUGGETS -> "SideItem: Nuggets - $1.50";
            case SALAD -> "SideItem: Salad - $2.00";
        };
    }
}
