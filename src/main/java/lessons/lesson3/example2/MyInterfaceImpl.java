package lessons.lesson3.example2;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public void method() {

    }
}

class Main {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.method1();
    }
}