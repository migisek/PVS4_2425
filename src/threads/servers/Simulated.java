package threads.servers;

import java.util.Scanner;

public class Simulated {
    private static boolean running = true;
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread display = new Thread(() -> {
            while(running){
                try {
                    Thread.sleep(1000);
                    System.out.println("Current balance: " + account.getBalance());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Vlakno [display] končí...");
        });

        Thread commandThread = new Thread(() -> {
            try(Scanner sc = new Scanner(System.in)) {
                while (running){
                    System.out.println("Zadej prikaz v podobě:" +
                            "(/deposit <amount>, /withdraw <amount>, /quit");
                    String input = sc.nextLine();
                }
            }
        });
    }
} class BankAccount{
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized boolean withdraw(int amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }
}
