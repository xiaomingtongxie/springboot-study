package demo.mock;

public class MockPrivateMethod {

    public String callPrivateMethod(){
        return parivateMethod();
    }


    private String parivateMethod()
    {
        return "this is a private method.";
    }
}
