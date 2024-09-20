package exceptions.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EmptyStackException;
import java.util.List;

public class Basics {

    static void doSomethingBad() throws IOException{
        throw new IOException();
    }

    static void doDoSomethingBad() throws IOException{
        doSomethingBad();
    }

    static void doDoDoSomethingBad(){
        try {
            doDoSomethingBad();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static void processLine(String line){
        String[] params;
        double a, b;
        params = line.split(",");
        a = Double.parseDouble(params[0]);
        b = Double.parseDouble(params[1]);
        switch (params[2]) {
            case "A" -> System.out.println(a + b);
            case "S" -> System.out.println(a - b);
            case "M" -> System.out.println(a * b);
            case "D" -> System.out.println(a / b);
        }
    }

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("inputs.txt"));
        String[] params;
        double a, b;
        for (String line : lines) {

            processLine(line);
//                catch (ArithmeticException e){
//                    System.out.println("Nelze delit nulou");
//                } catch (NumberFormatException nfe){
//                    System.out.println("Spatny format cisel");
//                } catch (ArrayIndexOutOfBoundsException e){
//                    System.out.println("Spatny format radku");
//                }

        }
    }
}

