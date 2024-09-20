package exceptions.processing;

public class FactorialException extends ArithmeticException{
    public FactorialException(){
        super("Faktorial cisla < 0 neexistuje");
    }
}
