/*În Java, o interfață funcțională este o interfață care conține exact o
metodă abstractă. Acest concept este esențial pentru programarea funcțională și este
utilizat în principal cu lambdas (expresii lambda) și referințele la metode.
1.O singura metoda abstracta
2.Adnotarea @FunctionalInterface

@FunctionalInterface
public interface Operatie {
    int calculeaza(int a, int b); // O singură metodă abstractă
}

public class Main {
    public static void main(String[] args) {
        Operatie adunare = (a, b) -> a + b; // Implementare lambda
        System.out.println(adunare.calculeaza(5, 3)); // 8
    }
}
*/

interface Foo {
    String method(String string);
}

interface FooParams {
    String method(String str1, String str2);
}

interface FooNoParams{
    String method();
}
interface FooNoParamasNoReturn{
    void method();
}

//v1 : implementam interfata intr-o clasa
class FooImplementare implements Foo {
    @Override
    public String method(String string) {
        return string.toUpperCase();
    }
}


public class Main {
    public static void main(String[] args) {
        //v2: clasa anonima
        Foo foo = new Foo() {
            @Override
            public String method(String string) {
                return string.toUpperCase();
            }
        };
        //v3:expresie lambda
        Foo foo2 = myString -> myString.toUpperCase();

        //v3:expresie lambda scrisa mai lung
        Foo foo3 = myString -> {
            return myString.toUpperCase();
        };
        Foo foo4 = (String myString) -> {
            return myString.toUpperCase();
        };

        FooParams fooImplementare = (sir1, sir2) -> sir1 + " " + sir2;

        FooNoParams fooNoParams=()->"Something";

        FooNoParamasNoReturn fooNoParamasNoReturn=()->{};
    }
}
