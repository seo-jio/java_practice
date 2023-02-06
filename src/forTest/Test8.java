package forTest;

class Parent{
    String x = "parent";
}

class Child extends Parent{
//    String x = "child";

    public void method(){
        String x = "method";
        System.out.println("x : " + x);
        System.out.println("x : " + this.x);
        System.out.println("x : " + super.x);
    }
}

public class Test8 {
    public static void main(String[] args) {
        Child child = new Child();
        child.method();
    }
}
