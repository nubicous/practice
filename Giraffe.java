import java.util.Objects;
import java.util.function.Consumer;

public class Giraffe extends Animal {
    private double height;

    public double getHeight(){
        return height;
    }

    public void setHeight(double h){this.height = height;}

    public Giraffe(String nameInEnglish, int years, int amountOfFood, double height) {
        super(nameInEnglish, years, amountOfFood);
        this.height = height;
        setHealth(200);
    }

    public double makeBigger(){
        setHeight(this.getHeight() + 1.0);
        return height;
    }

    @Override
    public void feed() {
        int foodUsage = getAmountOfFood();
        if (getYears() < 3) {
            foodUsage = 0;
            System.out.println("It's a baby giraffe, it only drinks milk from its' mom. Food usage: " + foodUsage);
        }else System.out.println("Just a regular giraffe, which ate: " + foodUsage);
    }

    @Override
    public void attack(Animal a){
        if(a.isAlive()) {
            double damage = height * getYears() / 2;
            if (getHealth() < 50) {
                damage += 20;
                System.out.println("Giraffe kick its' enemy and deals: " + damage);
            } else System.out.println("Giraffe dealt: " + damage + " damage to " + a.getNameInEnglish());
            a.setHealth(a.getHealth() - damage);
            if(!a.isAlive()) System.out.println("Giraffe has killed " + a.getNameInEnglish());
        }
    }

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Giraffe other = (Giraffe) otherObject;
        return height == other.height;
    }

    @Override
    public String toString(){
        return super.toString() + "[Teeth = " + height + "]";
    }

    @Override
    public int hashCode(){
        return super.hashCode() + Objects.hash(height);
    }


}
