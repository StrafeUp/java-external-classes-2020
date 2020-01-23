package lessons.lesson1;

public class Calculator {

    public static final String PLUS = "+";
    public static final String DIV = "/";
    public static final String MUL = "*";
    public static final String MINUS = "-";

    public int calc(int a, String operator, int b) {
        if(operator==null){
            throw new IllegalArgumentException("Operator is null");
        }
        switch (operator) {
            case PLUS:
                return a + b;
            case DIV:
                return a / b;
            case MUL:
                return a * b;
            case MINUS: return a-b;
            default:
                throw new IllegalArgumentException("Operator is not expected");
        }
    }
}
