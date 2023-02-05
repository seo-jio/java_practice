package forTest;

class SuperClass {
    String x = "super";

    public void method() {
        System.out.println("super class method + " + x);
    }
}

class SubClass extends SuperClass {
    String x = "sub";

    @Override
    public void method() {
        System.out.println("sub class method + " + x);
    }
}
public class Test9 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.x); // sub
        subClass.method(); // sub class method

        SuperClass supClass = subClass;
        System.out.println(supClass.x); //정적 바인딩, super
        supClass.method(); //동적 바인딩, sub class method
    }
}
