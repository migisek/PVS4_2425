package threads.fileread.syncing;

public class DeadlockExample {

    public static void main(String[] args) {
        BankAccount accountA = new BankAccount(1, 1000);
        BankAccount accountB = new BankAccount(2, 2000);


    }

    private static void transferMoney(BankAccount from, BankAccount to, int amount){
        //zamknu from
        synchronized (from){
            System.out.println("Thread: " + Thread.currentThread()
                + " ma zamceny ucet " + from.getId());
        }
    }

}
class BankAccount{
    private final int id;
    private int balance;

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
