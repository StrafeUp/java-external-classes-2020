package lessons.lesson1.tester.runners;

import lessons.lesson1.tester.annotations.After;
import lessons.lesson1.tester.annotations.AfterAll;
import lessons.lesson1.tester.annotations.Before;
import lessons.lesson1.tester.annotations.BeforeAll;
import lessons.lesson1.tester.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public void run(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        List<Method> beforeMethods = getMethodsByAnnotation(Before.class, declaredMethods);
        List<Method> afterMethods = getMethodsByAnnotation(After.class, declaredMethods);

        List<Method> beforeAllMethods = getMethodsByAnnotation(BeforeAll.class, declaredMethods);
        List<Method> afterAllMethods = getMethodsByAnnotation(AfterAll.class, declaredMethods);


        invokeStaticMethods(object, beforeAllMethods);


        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);

                Class<? extends Throwable> expectedException = annotation.expected();
                String expectedMessage = annotation.message();

                afterEachTest(object, beforeMethods);

                try {
                    method.invoke(object);
                } catch (Exception e) {
                    if (e.getCause().getClass().equals(expectedException)) {
                        if (expectedMessage.equals(e.getCause().getMessage())) {
                            System.out.println("Exception assertion success! Exception: " + expectedException);
                        } else {
                            System.out.println(e.getCause().getMessage() + " - Assertion failed, message expected: " + expectedMessage);
                        }

                        if (e.getCause().getMessage() == null && expectedMessage.equals("None")) {
                            System.out.println("Exception assertion success! Exception: " + expectedException);
                            continue;
                        }

                    } else {
                        System.out.println(e.getCause() + "is thrown instead of " + expectedException.toString());
                    }
                }

                afterEachTest(object, afterMethods);
            }
        }
        invokeStaticMethods(object, afterAllMethods);
    }

    private void invokeStaticMethods(Object object, List<Method> afterAllMethods) throws IllegalAccessException, InvocationTargetException {
        for (Method method : afterAllMethods) {
            if (Modifier.isStatic(method.getModifiers())) {
                method.invoke(object);
            }
        }
    }

    private void afterEachTest(Object object, List<Method> afterMethods) throws IllegalAccessException, InvocationTargetException {
        for (Method afterMethod : afterMethods) {
            afterMethod.invoke(object);
        }
    }

    private List<Method> getMethodsByAnnotation(Class<? extends Annotation> annotation, Method[] methods) {
        ArrayList<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
