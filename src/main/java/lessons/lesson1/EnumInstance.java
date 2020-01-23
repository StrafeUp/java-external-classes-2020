package lessons.lesson1;


public class EnumInstance {
    public static void main(String[] args) throws Exception {
       /* Constructor<?> declaredConstructor = TestEnum.class.getDeclaredConstructors()[0];
        declaredConstructor.setAccessible(true);
        Field constructorAccessorField = Constructor.class.getDeclaredField("constructorAccessor");
        constructorAccessorField.setAccessible(true);
        ConstructorAccessor ca = (ConstructorAccessor) constructorAccessorField.get(declaredConstructor);

        if (ca == null) {
            Method acquireConstructorAccessorMethod = Constructor.class.getDeclaredMethod("acquireConstructorAccessor");
            acquireConstructorAccessorMethod.setAccessible(true);
            ca = (ConstructorAccessor) acquireConstructorAccessorMethod.invoke(declaredConstructor);
        }
        TestEnum o1 = (TestEnum) ca.newInstance(new Object[]{"TEST_ENUM", 0});
        TestEnum o2 = TestEnum.TEST_ENUM;

        System.out.println(o1.equals(o2));
        System.out.println(o1.getClass().toString());*/
    }
}

enum TestEnum {TEST_ENUM}