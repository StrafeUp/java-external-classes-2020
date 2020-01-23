package lessons.lesson1.tester;


import lessons.lesson1.tester.runners.TestRunner;

public class TesterDemo {
    public static void main(String[] args) throws Exception {
        TestRunner testRunner = new TestRunner();
        testRunner.run(MyTest.class);
    }
}
