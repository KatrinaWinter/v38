import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        int balance = 1000;
        int choice = -1;
        int amount;

        showWelcome();

        while (choice != 0) {
            showMenu();

            System.out.print("Ditt val: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Ditt saldo är: " + balance + " kr");
            } else if (choice == 2){
                System.out.print("Insättningsbelopp: ");
                amount = scanner.nextInt();
                balance += amount;
                history.add("Insättning: " + amount + " kr");
                System.out.println("Ny insättning " + amount + " kr! Nytt saldo: " + balance + " kr");
            } else if (choice == 3) {
                int interest = calculateInterest(balance, 5);
                System.out.println("Ränta (5%): " + interest + " kr");
            } else if (choice == 4) {
                System.out.println("Historik");
                if (history.size() == 0) {
                    System.out.println("Inga transaktioner än.");
                } else {
                    showHistory(history);
                }
            } else if (choice == 5){
                System.out.print("Uttagsbelopp: ");
                amount = scanner.nextInt();
                if (amount > balance){
                    System.out.println("Medges ej - otillräckligt saldo!");

                } else{
                    balance -= amount;
                    history.add("Uttag: " + amount + " kr");
                    System.out.println("Nytt uttag " + amount + " kr! Nytt saldo: " + balance + " kr");
                }
            } else if (choice == 0) {
                System.out.println("Kortet matas ut. Hejdå!");
            } else {
                System.out.println("Försök igen.");
            }
        }
    }
    public static int calculateInterest(int amount, int rate) {
        return amount * rate / 100;
    }
    public static void showWelcome() {
        System.out.println("--- VÄLKOMMEN TILL BANKOMATEN ---");
    }
    public static void showMenu() {
        System.out.println("1. Se saldo | 2. Insättning | 3. Årlig ränta |4. Historik |5. Uttag | 0. Avsluta");
    }
    public static void showHistory(List<String> history){
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
    }
}