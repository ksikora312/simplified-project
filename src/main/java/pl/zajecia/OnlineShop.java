package pl.zajecia;

import pl.zajecia.ui.MainUI;
import pl.zajecia.ui.ProductUI;

import java.util.Scanner;

public class OnlineShop {

    private Scanner scanner;

    private MainUI mainUI;
    private boolean isApplicationRunning;

    public OnlineShop() {
        this.scanner = new Scanner(System.in);
        this.mainUI = new MainUI();
        this.isApplicationRunning = true;
    }

    public void run() {
        while(isApplicationRunning) {
            mainUI.showMenu();
        }
    }



}
