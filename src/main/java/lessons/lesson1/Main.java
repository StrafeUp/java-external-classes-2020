package lessons.lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<A> aClass = A.class;
        Constructor<A> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        A a = constructor.newInstance();

        Method method = aClass.getDeclaredMethod("staticMethod");
        method.setAccessible(true);
        Object invoke = method.invoke(null);

    }
}

class A {

    private A() {

    }

    public void method() {
        System.out.println("non-static method");
    }

    private static void staticMethod() {
        System.out.println("Static method");
    }
}
