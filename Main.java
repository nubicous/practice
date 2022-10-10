import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Giraffe g = new Giraffe("Kleopatra", 2,20, 6.7);
        Giraffe h = new Giraffe("Horace", 8, 30, 8);
        Giraffe l = g;
        Crocodile c = new Crocodile("Alfred", 6, 20, 22);
        Crocodile k = new Crocodile("Hermes", 6, 35, 20);
        c.attack(g);
        System.out.println(g.getHealth());
        g.attack(c);
        System.out.println(c.getHealth());
        System.out.println(c.compareTo(k));
        System.out.println((c.compare((a) -> Integer.compare(c.getYears(), a.getYears()))));
        System.out.println(c.isAdult((p) -> p.getYears() > 4));


    }
}
