package lessons.lesson1.tester.annotations;



import lessons.lesson1.tester.None;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Test {
    //expectedException
    Class<? extends Throwable> expected() default None.class;
    //expectedMessage
    String message() default "None";
}
