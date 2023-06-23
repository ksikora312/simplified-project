package pl.zajecia;

import pl.zajecia.ui.ProductUI;

import java.util.Scanner;

public class OnlineShop {

    private Scanner scanner;
    private ProductUI productUI;
    private boolean isApplicationRunning;

    public OnlineShop() {
        this.scanner = new Scanner(System.in);
        this.productUI = new ProductUI();
        this.isApplicationRunning = true;
    }

    public void run() {
        while(isApplicationRunning) {
            productUI.showMenu();
        }
    }



}
