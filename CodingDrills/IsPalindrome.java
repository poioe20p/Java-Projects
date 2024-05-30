package CodingDrills;

import java.util.*;

class IsPalindrome {

    private static String isPalindrome(String string) {
        if(string.isBlank() || string.isEmpty()) return "F";
        String noSpaceString = string.replace(" ", "").toLowerCase()
                .replace(",", "")
                .replace(";", "")
                .replace(".", "");
        String aux = noSpaceString;
        for(int i = 0; i < noSpaceString.length(); i++) {
            if(!Character.isLetterOrDigit(noSpaceString.charAt(i))) {
                aux = noSpaceString.replace(String.valueOf(noSpaceString.charAt(i)), "");
            }
        }
        int length = aux.length();
        for(int i = 0; i < (length/2); i++) {
            if(aux.charAt(i) != (aux.charAt(length - 1 - i))) return "F";
        }
        return "T";
    }

    private static void process(String input) {
        String isPalindrome = IsPalindrome.isPalindrome(input);
        System.out.println(isPalindrome);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        process(input);
    }
