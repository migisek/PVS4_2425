package threads.fileread.syncing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccountSafe {

    static void transfer(BankAccountSync from, BankAccountSync to, int amount){
        if (from.getBalance() >= amount){
            from.withdraw(amount);
            to.deposit(amount);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccountSync a = new BankAccountSync(1000);
        BankAccountSync b = new BankAccountSync(2000);

        System.out.println("A: " + a.getBalance());
        System.out.println("B: " + b.getBalance());
        System.out.println("Total: " + (a.getBalance() + b.getBalance()));

        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(()->{
                for (int j = 0; j < 3000; j++) {
                    if (Math.random() < 0.5){
                        transfer(a,b,1);
                    } else {
                        transfer(b, a, 1);
                    }
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("A: " + a.getBalance());
        System.out.println("B: " + b.getBalance());
        System.out.println("Total: " + (a.getBalance() + b.getBalance()));
    }

}
class BankAccountSync {
    private int balance;

    public BankAccountSync(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }
    public synchronized void withdraw(int amount){
        balance -= amount;
    }
}