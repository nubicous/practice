import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Giraffe kleopatra = new Giraffe("Kleopatra", 2,20, 6.7);
        Giraffe horace = new Giraffe("Horace", 8, 30, 8);
        Crocodile alfred = new Crocodile("Alfred", 6, 20, 22);
        Crocodile hermes = new Crocodile("Hermes", 6, 35, 20);

        // abstract methods
        alfred.attack(kleopatra);
        System.out.println(kleopatra.getHealth());
        kleopatra.attack(alfred);
        System.out.println(alfred.getHealth());

        // overriding compareTo method from Comparable interface
        System.out.println(alfred.compareTo(hermes));

        // calling compare() method from class Crocodile which takes a Comparable as an argument, using a lambda statement
        System.out.println((alfred.compare((a) -> Integer.compare(alfred.getYears(), a.getYears()))));

        // using lambda statement to call isAdult() from class Crocodile, which takes Predicate as an argument
        System.out.println(alfred.isAdult((p) -> p.getYears() > 4));

        // newBaby() is a method, which implements an abstract inner class, which is implementing an ActionListener interface
        // newBabyV2() is a method implementing an inner class
        // newBabyV3() is method implementing same functionality as other versions of newBaby method with lambda statement
        Crocodile hermes2 = new Crocodile("Hermes", 6, 35, 20);
        hermes2.newBaby(1000);

        //implementing an ArrayList  with double curly braces, which is a use of inner class
        System.out.println(new ArrayList<>() {{ add("your"); add("mom"); add("gay");}});

        //implementation of abstract inner class, which overrides makeBigger() method in class Giraffe
        Giraffe baby = new Giraffe("Mariola", 1, 10, 2){
            @Override
            public double makeBigger(double grow){
                this.setHeight(getHeight() + (2 * grow));
                return getHeight();
            }
        };
        System.out.println(baby.makeBigger(2));

        //It is a method inside Giraffe class, which is creatig a new object of MasaiGiraffe, which is a subclass of
        //giraffe
        Giraffe.MasaiGiraffe masai = Giraffe.giveBirth("Witold", 10, 20);

        //stopping newBaby() method which is working until pressing "Zamknąć program?"
        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);

    }
}
