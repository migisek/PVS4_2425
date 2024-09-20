package exceptions.debugging;

public class ArrayDebugging {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        processArray(numbers);
    }

    public static void processArray(int[] numbers) {
        for (int i = 0; i <= numbers.length; i++) { 
            System.out.println("Processing number: " + numbers[i]); 
        }
    }
}
