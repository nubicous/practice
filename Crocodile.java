import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.function.Predicate;

public class Crocodile extends Animal implements Comparable<Crocodile>, Predicate<Crocodile>, ActionListener {
    private int amountOfTeeth;
    final int adult = 6;
    final int youngish = 3;

    public Crocodile(String nameInEnglish, int years, int amountOfFood, int amountOfTeeth) {
        super(nameInEnglish, years, amountOfFood);
        this.amountOfTeeth = amountOfTeeth;
        setHealth(150);
    }

    public void setAmountOfTeeth(int amount){
        this.amountOfTeeth = amount;
    }

    public int getAmountOfTeeth() {
        return amountOfTeeth;
    }

    @Override
    public double feed(){
        double foodUsage = 0;
        if (getYears() < youngish && !isHasEaten()) {
            foodUsage = getAmountOfFood() / 4;
        } else if (getYears() < adult && !isHasEaten()) {
            foodUsage = getAmountOfFood() / 2;
        }
        setHasEaten(true);
        System.out.println("Crocodile has eaten" + foodUsage + " kg of meat");
        return foodUsage;
    }

    @Override
    public double attack(Animal a)throws NullPointerException{
            double damage = 0;
            if (a.isAlive() && this.isAlive()) {
                damage = (amountOfTeeth / 2.0) * getYears();
                a.setHealth(a.getHealth() - damage);
                if (!a.isAlive()) {
                    System.out.println("Crocodile has killed" + a.getNameInEnglish());
                }
                System.out.println("Crocodile has dealt: " + damage + " damage to " + a.getNameInEnglish());
            } else System.out.println("This animal is already dead!");
            return damage;
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

    public void newBaby(int interval) {
        ActionListener lis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(amountOfTeeth);
                System.out.println("FNDSFNKDSNFKS");
            }
        };
        Timer t = new Timer(interval, lis);
        t.start();
    }

    public void newBabyV2(int interval){
        class babyCrocodile implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.out.println(amountOfTeeth);
            }
        }
        ActionListener listener = new babyCrocodile();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public void newBabyV3(int interval){
        Timer t = new Timer(interval, event -> System.out.println(amountOfTeeth));
        t.start();
    }

    public void actionPerformed(ActionEvent event){
        System.out.println("");
    }


}
