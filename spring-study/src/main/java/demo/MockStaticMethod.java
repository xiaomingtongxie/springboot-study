package demo.mock;

public class MockStaticMethod {

    private StaticMethod2 staticMethod2;

    public static String staticMethod() {

        return "this is  a static method.";
    }

    public String testStatic2() {
        return staticMethod2.staticMethod2();
    }

    public StaticMethod2 getStaticMethod2() {
        return staticMethod2;
    }

    public void setStaticMethod2(StaticMethod2 staticMethod2) {
        this.staticMethod2 = staticMethod2;
    }
}
