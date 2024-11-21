interface P3<T, Q> {
    T metoda(Q q);
}

public class InterfataFunctionala3 {
    public static void main(String[] args) {
        P3<String, Integer> p3 = nr -> "Numar";
        System.out.println(p3.metoda(3));
    }
}
