import java.util.Objects;

public class Giraffe extends Animal {
    private double height;

    public double getHeight(){
        return height;
    }

    public void setHeight(double h){this.height = h;}

    public Giraffe(String nameInEnglish, int years, int amountOfFood, double height) {
        super(nameInEnglish, years, amountOfFood);
        this.height = height;
        setHealth(200);
    }

    public double makeBigger(double grow){
        setHeight(this.getHeight() + grow);
        return height;
    }

    @Override
    public double feed() {
        double foodUsage = getAmountOfFood();
        if (getYears() < 3) {
            foodUsage = 0;
            System.out.println("It's a baby giraffe, it only drinks milk from its' mom. Food usage: " + foodUsage);
        }else System.out.println("Just a regular giraffe, which ate: " + foodUsage);
        return foodUsage;
    }

    @Override
    public double attack(Animal a){
        double damage = 0;
        if(a.isAlive() && this.isAlive()) {
            damage = height * getYears() / 2;
            if (getHealth() < 50) {
                damage += 20;
                System.out.println("Giraffe kick its' enemy and deals: " + damage);
            } else System.out.println("Giraffe dealt: " + damage + " damage to " + a.getNameInEnglish());
            a.setHealth(a.getHealth() - damage);
            if(!a.isAlive()) System.out.println("Giraffe has killed " + a.getNameInEnglish());
        }
        return damage;
    }

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Giraffe other = (Giraffe) otherObject;
        return height == other.height;
    }

    @Override
    public String toString(){
        return super.toString() + "[Height = " + height + "]";
    }

    @Override
    public int hashCode(){
        return super.hashCode() + Objects.hash(height);
    }


    public static MasaiGiraffe giveBirth(String name, int age, int attack){
        MasaiGiraffe masai = new MasaiGiraffe(name, age, attack);
        masai.voice();
        System.out.println("New masai giraffe was born");
        return masai;
    }


    public static class MasaiGiraffe{
        String name;
        int age;
        int attack;

        public MasaiGiraffe(String name, int years, int attack){
            this.name = name;
            this.age = years;
            this.attack = attack;
        }

        public void voice(){
            System.out.println("ihaaaaaaaa");
        }

        @Override
        public boolean equals(Object otherObject) {
            if(this == otherObject) return true;
            if(otherObject == null) return false;
            if(!(otherObject instanceof MasaiGiraffe other)) return false;
            return name.equalsIgnoreCase(other.name)
                    && age == other.age
                    && attack == other.attack;
        }

    }

}
