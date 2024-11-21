import java.util.List;

interface Operatie {
    int doOperation(List<Integer> numere);
}

public class InterfataFunctionala4 {
    public static void main(String[] args) {
        List<Integer> numere = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Operatie operatie = nr->{
            return nrImpare(numere);
        };
        System.out.println(operatie.doOperation(numere));
    }

    public static int nrImpare(List<Integer> numere) {
        int suma = 0;
        for (Integer nr : numere) {
            if (nr % 2 != 0) {
                suma += nr;
            }
        }
        return suma;
    }
}
