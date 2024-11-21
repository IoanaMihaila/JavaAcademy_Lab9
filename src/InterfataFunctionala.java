interface NrIntregi {
    int operatie(int nr1, int nr2);

}

public class InterfataFunctionala {
    public static void main(String[] args) {
        NrIntregi nrIntregi1 = (a, b) -> a + b;
        System.out.println("10+5=" + nrIntregi1.operatie(10, 5));
        NrIntregi nrIntregi2 = (a, b) -> {
            return a - b;
        };
        System.out.println("6-3=" + nrIntregi2.operatie(6, 3));
        NrIntregi nrIntregi3 = (a, b) -> a * b;
        System.out.println("2*4=" + nrIntregi3.operatie(2, 4));
        NrIntregi nrIntregi4 = (a, b) -> {
            return a / b;
        };
        System.out.println("20/10=" + nrIntregi4.operatie(20, 10));
    }
}
