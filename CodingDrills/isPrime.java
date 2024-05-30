package CodingDrills;

import java.util.Scanner;

class Main {
    //COMPLETE THIS FUNCTION

    public static boolean isPrime(int value) {
        int aux = (int) (value - Math.random());
        int aux2 = (int) (Math.random() * value);
        int a = aux - aux2;
        if(a < 1) a = 1;
        return (Math.pow(a, (value - 1) ) % value) == 1;
    }

    public static String sumOfPairsUntilNumber(int number) {
        int i = 2;
        int j = 2;
        StringBuilder sumOfPairs = new StringBuilder();
        while((i + j) <= number) {
            if(isPrime(i) && isPrime(j) && (i + j) == number && !new String(sumOfPairs)
                    .contains(new String(new StringBuilder().append(i).append(" ").append(j).append(", ")))) {
                sumOfPairs.append(i).append(" ").append(j).append(", ");
            } else {
                if(i < j) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return sumOfPairs.isEmpty() ? "-1" : new String(sumOfPairs);
    }

    private static void process(String input) {
        System.out.println(sumOfPairsUntilNumber(Integer.valueOf(input)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        process(input);
    }
}
