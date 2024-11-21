import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Casa {
    private List<Locatar> locatari;
    private String strada;
    private static int count = 0;

    public Casa(String strada) {
        this.locatari = new ArrayList<>();
        this.strada = strada;
        count++;
    }

    public void addLocatar(Locatar locatar) {
        locatari.add(locatar);
    }

    public String getStrada() {
        return strada;
    }

    @Override
    public String toString() {
        return "Casa " + count + " este pe pe strada: " + strada;
    }

    public List<Locatar> getLocatari() {
        return locatari;
    }

}

class Locatar {
    private String nume;
    private Casa casa;
    private int varsta;

    public Locatar(String nume, Casa casa, int varsta) {
        this.nume = nume;
        this.casa = casa;
        this.varsta = varsta;
        this.casa.addLocatar(this);
    }

    public int getVarsta() {
        return varsta;
    }
}

public class Stream1 {
    public static void main(String[] args) {
        List<Integer> numere = List.of(2, 7, 8, 10, 4, 5);
        /*Identificati numerele divizibile cu 5*/
        List<Integer> divizibile = numere.stream()
                .filter(nr -> nr % 5 == 0)
                .collect(Collectors.toList());
        System.out.println(divizibile);

        /*Identificati string-urile care se termina cu "an"*/
        List<String> strings = List.of("Alexandra", "Ioan", "Maria", "Marian");
        List<String> endsWithAna = strings.stream()
                .filter(nume -> nume.endsWith("an"))
                .collect(Collectors.toList());
        System.out.println(endsWithAna);

        /*4. Identificati numerele pare apoi adunati cu 3 fiecare numar identificat,
urmand a-l ridica la patrat, fiecare operatie facandu-se in propria sa expresie lambda*/
        List<Double> nrPareOp = numere.stream().filter(nr -> nr % 2 == 0).map(nr -> nr + 3).map(nr -> Math.pow(nr, 2)).collect(Collectors.toList());
        System.out.println(nrPareOp);


        Casa casa1 = new Casa("Plantelor");
        Casa casa2 = new Casa("Verde");
        Casa casa3 = new Casa("Plantelor");
        List<Casa> casee = List.of(casa1, casa2, casa3);

        List<Casa> stradaPlantelor = casee.stream().filter(casa -> casa.getStrada().equals("Plantelor")).collect(Collectors.toList());
        System.out.println("Casele de pe strada Plantelor: ");
        System.out.println(stradaPlantelor);

        Locatar locatar1=new Locatar("Ioana",casa1,21);
        Locatar locatar2=new Locatar("Maria",casa1,16);
        Locatar locatar3=new Locatar("Valentin",casa2,23);
        Locatar locatar4=new Locatar("Daria",casa2,25);
        //List<Casa>caseCuMajori=casee.stream().filter()
    }

    //Inner class value + ScopeExample-class scope
}
