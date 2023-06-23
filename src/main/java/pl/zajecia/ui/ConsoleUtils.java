package pl.zajecia.ui;

import java.util.Scanner;

public class ConsoleUtils {

    public static int getIntInput(Scanner scanner, int minimum, int maximum) {
        int input = 0;
        boolean hasEnteredCorrectNumber = false;
        while (!hasEnteredCorrectNumber) {
            if (!scanner.hasNextInt()) {
                System.out.println("To nie jest int! Sprobuj ponownie");
                scanner.next();
            } else {
                input = scanner.nextInt();
                if(input < minimum || input > maximum) {
                    System.out.println("Podana liczba nie miesci sie w zakresie!");
                } else{
                    hasEnteredCorrectNumber = true;
                }
            }
        }
        return input;
    }


}
