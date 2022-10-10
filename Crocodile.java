import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.function.Predicate;

public class Crocodile extends Animal implements Comparable<Crocodile>, Predicate<Crocodile>, ActionListener {
    private final int amountOfTeeth;
    final int adult = 6;
    final int youngish = 3;

    public Crocodile(String nameInEnglish, int years, int amountOfFood, int amountOfTeeth) {
        super(nameInEnglish, years, amountOfFood);
        this.amountOfTeeth = amountOfTeeth;
        setHealth(150);
    }



    @Override
    public void feed(){
        int foodUsage = getAmountOfFood();
        if (getYears() < adult) {
            foodUsage = getAmountOfFood() / 2;
        } else if (getYears() < youngish) {
            foodUsage = getAmountOfFood() / 4;
        }
        System.out.println("Crocodile has eaten" + foodUsage + " kg of meat");
    }

    @Override
    public void attack(Animal a){
        if(a.isAlive()) {
            double damage = (amountOfTeeth / 2.0) * getYears();
            a.setHealth(a.getHealth() - damage);
            if (!a.isAlive()) {
                System.out.println("Crocodile has killed" + a.getNameInEnglish());
            }
            System.out.println("Crocodile has dealt: " + damage + " damage to " + a.getNameInEnglish());
        }else System.out.println("This animal is already dead!");
    }

    @Override
    public int compareTo(Crocodile other){
        return Integer.compare(amountOfTeeth, other.amountOfTeeth);
    }

    @Override
    public boolean test(Crocodile other){
        return other.amountOfTeeth > 30;
    }

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Crocodile other = (Crocodile) otherObject;
        return amountOfTeeth == other.amountOfTeeth;
    }

    @Override
    public String toString(){
        return super.toString() + "[Teeth = " + amountOfTeeth + "]";
    }

    @Override
    public int hashCode(){
        return super.hashCode() + Objects.hash(amountOfTeeth);
    }

    public int compare(Comparable<Crocodile> c){
        return c.compareTo(this);
    }

    public boolean isAdult(Predicate<Crocodile> b){
        return b.test(this);
    }


    public void start(int interval){
        ActionListener listener = new crocodileBaby();
        Timer t = new Timer(interval, listener);
        t.start();
    }
         public class crocodileBaby implements ActionListener {
            public void actionPerformed(ActionEvent event){
                System.out.println("FNDSFNKDSNFKS");
            }
         }

    public void actionPerformed(ActionEvent event){
        System.out.println();
    }


}
