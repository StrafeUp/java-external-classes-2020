package lessons.lesson1.tester;

import lessons.lesson1.tester.annotations.After;
import lessons.lesson1.tester.annotations.AfterAll;
import lessons.lesson1.tester.annotations.Before;
import lessons.lesson1.tester.annotations.BeforeAll;
import lessons.lesson1.tester.annotations.Test;

public class MyTest {

    @Before
    public void init1() {
        System.out.println("Before tests1");
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @Before
    public void init2() {
        System.out.println("Before tests2");
    }

    @After
    public void after() {
        System.out.println("After tests");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("After all tests");
    }

    @Test
    public void test1() {
        System.out.println("Test1");
    }

    @Test(expected = NullPointerException.class, message = "NPE test")
    public void testNPE(){
        throw new NullPointerException();
    }

    @Test
    public void test2() {
        System.out.println("Test2");
    }

    private void testWithoutAnnotation() {
        System.out.println("Test without annotation");
    }
}
