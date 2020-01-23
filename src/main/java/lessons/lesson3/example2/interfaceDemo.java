package lessons.lesson3.example2;

public class interfaceDemo {
    public static void main(String[] args) {
        MyInterface m = new MyInterface() {
            @Override
            public void method() {
                System.out.println("anonymous");
            }
        };

        MyInterface lambda = () -> System.out.println("anonymous");
        OneParameterInterface<String> oneParameterInterface = message -> System.out.println(message.isEmpty());
        TwoParameterInterface twoParameterInterface = (message, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.println(message);

            }
        };


        m.method();
        lambda.method();
    }
}
