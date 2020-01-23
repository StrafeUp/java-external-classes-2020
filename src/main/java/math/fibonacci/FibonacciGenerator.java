package math.fibonacci;

public class FibonacciGenerator {

    public static int generateRecursive(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
            return generateRecursive(number - 2) + generateRecursive(number - 1);
    }

    public static int generateIterative(int number) {

        int previousNumber = 0;
        int nextNumber = 1;
        int sum = 0;
        for (int i = 1; i <= number; ++i) {
            sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        return previousNumber;
    }

    public static void main(String[] args) {
        System.out.println(generateRecursive(5));
        System.out.println(generateIterative(5));
    }
}
