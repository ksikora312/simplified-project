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

    public static double getDoubleInput(Scanner scanner, double minimum) {
        double input = 0.0;
        boolean hasEnteredCorrectNumber = false;
        while (!hasEnteredCorrectNumber) {
            if (!scanner.hasNextDouble()) {
                System.out.println("To nie jest double! Sprobuj ponownie");
                scanner.next();
            } else {
                input = scanner.nextDouble();
                if(input <= minimum) {
                    System.out.println("Nieprawidlowa liczba!");
                } else{
                    hasEnteredCorrectNumber = true;
                }
            }
        }
        return input;
    }
    public static String getStringInput (Scanner scanner) {
        String input = "";
        boolean hasEnteredCorrectString = false;
        while (!hasEnteredCorrectString) {
            if (!scanner.hasNextLine()) {
                System.out.println("Nie wprowadzono wartosci! Sprobuj ponownie");
                scanner.next();
            } else {
                input = scanner.next();
                hasEnteredCorrectString = true;
            }
        }
        return input;
    }


}
