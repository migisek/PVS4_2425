package threads.fileread.syncing;

public class BankAccountUnsafe {

    static void transfer(BankAccountNoSync from, BankAccountNoSync to, int amount){
        if (from.getBalance() >= amount){
            from.withdraw(amount);
            to.deposit(amount);
        }
    }

    public static void main(String[] args) {
        BankAccountNoSync a = new BankAccountNoSync(1000);
        BankAccountNoSync b = new BankAccountNoSync(2000);
    }

}
class BankAccountNoSync{
    private int balance;

    public BankAccountNoSync(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
}