package math.factorial;

public class BigFactorial {

    static void factorial(int n) {
        int[] resultArr = new int[500];

        resultArr[0] = 1;
        int resultSize = 1;

        for (int x = 2; x <= n; x++)
            resultSize = multiply(x, resultArr, resultSize);

        System.out.println("Factorial is: ");
        for (int i = resultSize - 1; i >= 0; i--)
            System.out.print(resultArr[i]);
    }

    static int multiply(int x, int[] resultArr, int resultSize) {
        int carry = 0; // Initialize carry

        for (int i = 0; i < resultSize; i++) {
            int prod = resultArr[i] * x + carry;
            resultArr[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            resultArr[resultSize] = carry % 10;
            carry = carry / 10;
            resultSize++;
        }
        return resultSize;
    }

    public static void main(String[] args) {
        factorial(150);
    }
}
