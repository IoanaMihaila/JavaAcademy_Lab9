package Tema;
/*Construiti conditiile de la tema precedenta prin intermediul expresiilor lambda si demonstrati cum functioneaza.*/


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class StatulRoman {
    private static StatulRoman instance;
    private List<Firma> firme;
    private static int count;
    private double totalTaxe;

    private StatulRoman() {
        firme = new ArrayList<>();
        totalTaxe = 0;
        count = 999;
    }

    public static StatulRoman getInstance() {
        if (instance == null) {
            instance = new StatulRoman();
        }
        return instance;
    }

    public String getNextAvailableNumber() {
        count++;
        return "RO" + count;
    }

    public void addFirma(Firma f) {
        firme.add(f);
    }

    public void addTax(double valoare) {
        totalTaxe += valoare;
    }

    public void afisareForConditie(Conditie conditie) {
        /*for (Firma f : firme) {
            if (conditie.isRespected(f).orElse(false)) {
                System.out.println(f);
            }
        }*/
        for (Firma f : firme) {
            if (conditie.isRespected(f)) {
                System.out.println(f);
            }
        }
    }

    public double getTotalTaxe() {
        return totalTaxe;
    }
}

class Angajat {
    private String nume;
    private int varsta;
    private int nivelExperienta; //intre 1 si 10
    private Firma firma;

    public Angajat(String nume, int varsta, int nivelExperienta, Firma firma) {
        this.nume = nume;
        this.varsta = varsta;
        this.nivelExperienta = nivelExperienta;
        this.firma = firma;
    }

    public void demisioneaza() {
        if (firma != null) {
            firma.removeAngajat(this);
            firma = null;
        }
    }

    @Override
    public String toString() {
        return "Nume: " + nume + ", varsta=" + varsta + ", nivelExperienta=" + nivelExperienta + ", firma: " + firma.getNume() + "\n";
    }
}

abstract class Firma {
    private String ID;
    private String nume;
    private LocalDateTime dataInfiintare;
    private String localitate;
    private double venit;
    private List<Angajat> angajati;

    public Firma(String nume, String localitate) {
        this.ID = StatulRoman.getInstance().getNextAvailableNumber();
        this.nume = nume;
        this.dataInfiintare = LocalDateTime.now();
        this.localitate = localitate;
        this.venit = 0;
        this.angajati = new ArrayList<>();
        StatulRoman.getInstance().addFirma(this);
    }

    public abstract void platesteTaxe();

    public String getNume() {
        return nume;
    }

    public void setVenit(double venit) {
        this.venit = venit;
    }

    public double getVenit() {
        return venit;
    }

    public void addAngajat(Angajat a) {
        angajati.add(a);
    }

    public void removeAngajat(Angajat a) {
        angajati.remove(a);
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public String getLocalitate() {
        return localitate;
    }

    @Override
    public String toString() {
        return "ID firma: '" + ID + ", nume='" + nume + ", dataInfiintare=" + dataInfiintare + ", localitate='" + localitate + '\'' + ", venit=" + venit + ", numar angajati=" + angajati.size() + "\n";
    }
}

class FirmaTva extends Firma {
    public FirmaTva(String nume, String localitate) {
        super(nume, localitate);
    }

    @Override
    public void platesteTaxe() {
        double taxe = 0.19 * this.getVenit() + 0.05 * this.getVenit();
        this.setVenit(this.getVenit() - taxe);
        StatulRoman.getInstance().addTax(taxe);
    }

    @Override
    public void removeAngajat(Angajat a) {
        super.removeAngajat(a);
        double taxaDemise = 0.01 * this.getVenit();
        this.setVenit(this.getVenit() - taxaDemise);
        StatulRoman.getInstance().addTax(taxaDemise);
    }
}

class FirmaNoTva extends Firma {
    public FirmaNoTva(String nume, String localitate) {
        super(nume, localitate);
    }

    @Override
    public void platesteTaxe() {
        double taxe = 0.01 * this.getVenit();
        this.setVenit(this.getVenit() - taxe);
        StatulRoman.getInstance().addTax(taxe);
    }
}

interface Conditie {
    boolean isRespected(Firma firma);
}

public class Problema1 {
    public static void main(String[] args) {
        StatulRoman stat = StatulRoman.getInstance();

        Firma firmaTva = new FirmaTva("Firma TVA SRL", "Bucuresti");
        Firma firmaNoTva = new FirmaNoTva("Firma No TVA SRL", "Cluj");
        Firma firmaNoTva1 = new FirmaNoTva("Firma No TVA PFA", "Hunedoara");

        System.out.println("Firmele create:");
        System.out.println(firmaTva);
        System.out.println(firmaNoTva);
        System.out.println(firmaNoTva1);

        Angajat angajat1 = new Angajat("Ion Popescu", 30, 7, firmaTva);
        Angajat angajat2 = new Angajat("Maria Ionescu", 25, 5, firmaTva);
        Angajat angajat3 = new Angajat("Andrei Vasile", 40, 9, firmaNoTva);

        firmaTva.addAngajat(angajat1);
        firmaTva.addAngajat(angajat2);

        firmaNoTva.addAngajat(angajat3);

        System.out.println("\nLista de angajați după angajare:");
        System.out.println("Firma TVA: " + firmaTva.getAngajati());
        System.out.println("Firma No TVA: " + firmaNoTva.getAngajati());

        firmaTva.setVenit(20000);
        firmaNoTva.setVenit(8000);
        firmaNoTva1.setVenit(10000);

        firmaTva.platesteTaxe();
        firmaNoTva.platesteTaxe();
        firmaNoTva1.platesteTaxe();

        System.out.println("\nVenituri după plata taxelor:");
        System.out.println("Firma TVA: " + firmaTva.getVenit());
        System.out.println("Firma No TVA: " + firmaNoTva.getVenit());
        System.out.println("Firma No Tva1: "+firmaNoTva1.getVenit());

        angajat1.demisioneaza();

        System.out.println("\nLista de angajați după demisie:");
        System.out.println("Firma TVA: " + firmaTva.getAngajati());

        Conditie venitMaiMareDeZeceMii=firma -> firma.getVenit()>10000;
        System.out.println("Firmele cu venitul mai mare de 10000: ");
        stat.afisareForConditie(venitMaiMareDeZeceMii);

        Conditie maiMultDeCinciAngajati=firma->firma.getAngajati().size()>5;
        System.out.println("Firmele cu mai mult de 5 angajati: ");
        stat.afisareForConditie(maiMultDeCinciAngajati);

        Conditie firmeFaraAngajati=firma->firma.getAngajati().isEmpty();
        System.out.println("Firmele fara angajati: ");
        stat.afisareForConditie(firmeFaraAngajati);

        Conditie firmeAnumitaLocatie=firma->firma.getLocalitate().equals("Bucuresti");
        System.out.println("Firmele din Bucuresti: ");
        stat.afisareForConditie(firmeAnumitaLocatie);
    }
}
