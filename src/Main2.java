interface A {
    default void show() {
        System.out.println("A");
    }
}
interface B {
    default void show() {
        System.out.println("B");
    }
}
class C implements A,B{
    @Override
    public void show() {
        //A.super.show();
        System.out.println("C");
    }
}

public class Main2 {
    public static void main(String[] args) {
        A obj=new C();
        obj.show();
    }
}
