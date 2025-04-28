package recap;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class DeleniDvouma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Zadej první číslo");
                int a = sc.nextInt();
                System.out.println("Zadej druhé číslo");
                int b = sc.nextInt();

                int c = a / b;
                System.out.println("Výsledek je" + c);
                BufferedWriter bw = new BufferedWriter(new FileWriter("data/vysledky.txt", true));
                bw.write(a + " + " + b + "= " + c + "\n");
                bw.close();

                break;
            } catch (ArithmeticException e) {
                System.out.println("Nesmíš dělit nulou...");
            } catch (FileNotFoundException e) {
                System.out.println("Soubor nenalezen.");
            } catch (Exception e) {
                System.out.println("Není číslo!");
            }
        }
    }
}