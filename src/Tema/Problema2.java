package Tema;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/*Construiti urmatoarele expresii lambda si demonstrati functionaltiatea lor:
supplier - nu primeste argumente, returneaza orice tip
consumer - primeste un argument de orice tip, nu returneaza nimic
operator - primeste un argument de un tip, si returneaza acelasi tip
function - primeste un tip, returneaza alt tip
PS: aceste denumiri sunt implementari care exista deja in Java si le vom utiliza in cadrul stream-urilor
*/
public class Problema2 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello!";
        System.out.println(supplier.get());

        Consumer<Integer> consumer = nr -> {
        };
        consumer.accept(5);

        UnaryOperator<Integer> unaryOperator = nr -> nr * 2;
        System.out.println(unaryOperator.apply(5));

        Function<Integer, String> function = nr -> "Numarul este: " + nr;
        System.out.println(function.apply(6));


    }
}
