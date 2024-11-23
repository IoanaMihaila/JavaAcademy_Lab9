package Tema;
/*Construiți un map (HashMap) în care cheia este un nume (String), iar valoarea o vârstă (Integer).
Puneți 3 elemente în map, ajungând de forma: “Mihai” - 33, “Florin” - 15, “Mihaela” - 31
!Operația poate fi realizată printr-un apel la metoda put(Object key, Objet value)
Căutați un element după cheie
		!Operația poate fi realizată print-un apel la metoda get(Obect key)
Afișați toate cheile dintr-un map.
!Operația se poate realiza astfel: apelând pe map metoda keySet() se va returna un set (un Set este echivalentul unei lista, doar ca nu pot exista duplicate - doua elemente cu acelasi equals) care trebuie salvat și iterat
Afișați toate valorile dintr-un map.
!Aici vă las pe voi să căutați în documentație ce metodă puteți apela - căutați metodele din cadrul lui Map
Parcurgeți și afișați atât cheile, cât și valorile dintr-un map.
! Trebuie să apelați metoda entrySet(), mai exact:
for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
    }
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problema6 {


    public static void main(String[] args) {
        //cheia este un nume, iar valoarea o varsta
        Map<String, Integer> map = new HashMap<>();

        //put-adaugare elemente in map
        map.put("Mihai", 33);
        map.put("Florin", 15);
        map.put("Mihaela", 31);

        //cautarea unui element dupa cheie
        String cheieCautata = "Mihai";
        Integer varsta = map.get(cheieCautata);
        if (varsta != null) {
            System.out.println("Varsta lui " + cheieCautata + " este " + varsta);
        } else {
            System.out.println(cheieCautata + " nu a fost gasit in map");
        }

        //afisare toate cheile din map
        Set<String> chei = map.keySet(); //keySet() returneaza toate cheile
        System.out.println("Cheile din map: ");
        for (String cheie : chei) {
            System.out.println(cheie);
        }

        //afisare toate valorile din map
        System.out.println("Valorile din map: ");
        for (Integer valoare : map.values()) {
            System.out.println(valoare);
        }

        //parcurgem si afisam atat cheile cat si valorile
        System.out.println("Cheile si valorile din map: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
