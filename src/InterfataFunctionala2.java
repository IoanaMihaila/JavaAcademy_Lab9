interface P2<T> {
    boolean metoda(T t);
}

public class InterfataFunctionala2 {
    public static void main(String[] args) {
        P2<Integer> p2 = a -> a > 0;
        System.out.println(p2.metoda(10));
    }
}
