package exceptions.debugging;

public class RecursiveDrop {
    public static void main(String[] args) {
        doSomething(0);
    }

    static void doSomething(int n){
        System.out.println(n);
        if ( n == 1000000){
            return;
        }
        doSomething(n+1);
    }

}
