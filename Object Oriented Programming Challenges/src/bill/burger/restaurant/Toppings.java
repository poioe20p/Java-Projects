package bill.burger.restaurant;

 enum Toppings {
    EXTRA_CHEESE,
    LETTUCE,
    TOMATO,
    ONION,
    PICKLES,
    KETCHUP,
    MUSTARD,
    BARBECUE_SAUCE,
    BACON,
    MAYO;

    static Toppings getTopping(String topping) {
        return switch (topping.toUpperCase()) {
            case "EXTRA CHEESE" -> EXTRA_CHEESE;
            case "LETTUCE" -> LETTUCE;
            case "TOMATO" -> TOMATO;
            case "ONION" -> ONION;
            case "PICKLES" -> PICKLES;
            case "KETCHUP" -> KETCHUP;
            case "MUSTARD" -> MUSTARD;
            case "BARBECUE SAUCE" -> BARBECUE_SAUCE;
            case "BACON" -> BACON;
            case "MAYO" -> MAYO;
            default -> null;
        };
    }

    static double getToppingPrice(Toppings topping) {
        return switch (topping) {
            case EXTRA_CHEESE -> 0.6;
            case LETTUCE, KETCHUP, MUSTARD, MAYO -> 0.3;
            case TOMATO, ONION -> 0.4;
            case PICKLES, BARBECUE_SAUCE -> 0.5;
            case BACON -> 0.8;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case EXTRA_CHEESE -> "Extra Cheese - $0.60";
            case LETTUCE -> "Lettuce - $0.30";
            case TOMATO -> "Tomato - $0.40";
            case ONION -> "Onion - $0.40";
            case PICKLES -> "Pickles - $0.50";
            case KETCHUP -> "Ketchup - $0.30";
            case MUSTARD -> "Mustard - $0.30";
            case BARBECUE_SAUCE -> "Barbecue Sauce - $0.50";
            case BACON -> "Bacon - $0.80";
            case MAYO -> "Mayo - $0.30";
        };
    }
}
