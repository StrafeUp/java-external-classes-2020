package lessons.lesson4;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String name = "Alex";

        Function<String, String> function = x -> {
            System.out.println(x);
            return "Hello " + name;
        };
    }
}
