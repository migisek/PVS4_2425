package exceptions.processing;

public class ExceptionPractice {
    public static void main(String[] args) {
        System.out.println(factorial(-5));
    }

    static int factorial(int n){
        if (n < 0){
            throw new FactorialException();
        }
        if (n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
}
