package Tema;
/*Construiti o expresie lambda care primeste ca parametru o lista de orice tip si va returna un element
(decideti voi 3 reguli)*/

import java.util.List;

@FunctionalInterface
interface ElementSelector<T> {
    T selectElement(List<T> list);
}

public class Problema3 {
    public static void main(String[] args) {
        ElementSelector<String> selector = list -> {
            if (list.isEmpty()) {
                return null;
            } else if (list.size() == 1){
                return list.get(0);
            }else{
                return list.stream()
                        .filter(s->s.startsWith("A"))
                        .findFirst()
                        .orElse(list.get(0));
            }
        };
        List<String>emptyList=List.of();
        List<String>singleElementList=List.of("Fruct");
        List<String>multiElementList=List.of("Banana","Mar","Caisa","Zmeura");

        System.out.println(selector.selectElement(emptyList));
        System.out.println(selector.selectElement(singleElementList));
        System.out.println(selector.selectElement(multiElementList));

    }
}
