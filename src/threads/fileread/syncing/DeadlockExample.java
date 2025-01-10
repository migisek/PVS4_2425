package threads.fileread.syncing;

public class DeadlockExample {

    public static void main(String[] args) {
        BankAccount accountA = new BankAccount(1, 1000);
        BankAccount accountB = new BankAccount(2, 2000);

        Thread t1 = new Thread(() -> safeTransferMoney(accountA, accountB, 100));
        Thread t2 = new Thread(() -> safeTransferMoney(accountB, accountA, 200));

        t1.start();
        t2.start();
    }

    private static void unsafeTransferMoney(BankAccount from, BankAccount to, int amount) {
        //zamknu from
        synchronized (from) {
            System.out.println("Thread: " + Thread.currentThread()
                    + " ma lock na ucet " + from.getId());

            //simulace nejakho procesu (treba overovani informaci apod..)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread: " + Thread.currentThread()
                    + " nastavuje lock na ucet " + to.getId());
            //tady nejspis zamrzne
            synchronized (to) {
                System.out.println("Thread: " + Thread.currentThread()
                        + " ma lock na ucet " + to.getId());

                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Presun penez od " + from.getId() + " k " + to.getId());
            }
        }
    }


    private static void safeTransferMoney(BankAccount from, BankAccount to, int amount) {
        //at uz je from/to jakykoliv, jsou jasne prirazene, ktery bude zpracovan prvni
        BankAccount firstLock = (from.getId() < to.getId()) ? from : to;
        BankAccount secondLock = (from.getId() < to.getId()) ? to : from;
        System.out.println("Spoustim prevod z " + from.getId() + " do " + to.getId());
        //tady bude dalsi thread cekat.
        synchronized (firstLock) {
            System.out.println("Thread: " + Thread.currentThread()
                    + " ma lock na ucet " + firstLock.getId());

            //simulace nejakho procesu (treba overovani informaci apod..)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread: " + Thread.currentThread()
                    + " nastavuje lock na ucet " + secondLock.getId());
            //tady nejspis zamrzne
            synchronized (secondLock) {
                System.out.println("Thread: " + Thread.currentThread()
                        + " ma lock na ucet " + secondLock.getId());


                if (firstLock == from) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println("Presun penez od " + from.getId() + " k " + to.getId());

                } else {
                    to.withdraw(amount);
                    from.deposit(amount);
                    System.out.println("Presun penez od " + to.getId() + " k " + from.getId());
                }
            }
        }
    }
}

class BankAccount {
    private final int id;
    private int balance;

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
