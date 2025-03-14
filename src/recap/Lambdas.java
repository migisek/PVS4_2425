package recap;

public class Lambdas{
    public static void main(String[] args) {
        //AIC
        NumberOperation addition = new NumberOperation() {
            @Override
            public double operation(double a, double b) {
                return a+b;
            }
        };


        //ruzne zapisy:

        //lambda varianta pro odcitani:
        NumberOperation difference = (first,second) -> first - second;
            //omezeni: interface muze mit jen jednu takovou metodu
            // vic vstupu


        //jeden vstup
        SingleThing square = a -> a*a;
        //nemusi byt v zavorce, pokud je jen jeden vstup

        //zadny vstup
        Generator gen = () -> (int)(Math.random()*10);

        //zadny vystup
        Printer p = text -> System.out.println(text);
        //nebo, lze toho i vice:
        Printer p2 = text -> {
            System.out.println("pocet zanku " + text.length());
            System.out.println(text);
        };//typicky actionListener, Threads/Runnable...

    }

}
interface NumberOperation{
    /**
     * Operace s cislama
     * @param a prvni cislo
     * @param b druhe cislo
     * @return vysledek operace
     */
    double operation(double a, double b);
}
interface SingleThing{
    double operation(double a);
}
interface Generator{
    int getRandomNum();
}
interface Printer {
    void print(String s);
}
