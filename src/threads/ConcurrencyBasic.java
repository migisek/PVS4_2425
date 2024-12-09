package threads;

public class ConcurrencyBasic {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    a = 5;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                b = 10;
            }
        });
        aThread.start();
        bThread.start();

        //spamuje, neustale v loopu a ma elegantni reseni
//        while (aThread.isAlive()){
//            System.out.println("Waitning...");
//        }
        System.out.println("Waiting...");

        //tady cekam, nez Thread skonci
        bThread.join();

        System.out.println(a);
        System.out.println(b);
        System.out.println("Happy end!");
    }
}
