import java.util.Objects;

public abstract class Animal {
    private final String nameInEnglish;
    private final int years;
    private boolean alive = true;
    private int amountOfFood;
    private double health;

    public void setHealth(double health){
        if(health < 0) this.setAlive(false);
        this.health = health;
    }
    public double getHealth(){return health;}

    public String getNameInEnglish() {
        return nameInEnglish;
    }
    public int getYears() {
        return years;
    }

    public boolean isAlive() {
        return alive;
    }
    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    public Animal(String nameInEnglish, int years, int amountOfFood) {
        this.nameInEnglish = nameInEnglish;
        this.years = years;
        this.amountOfFood = amountOfFood;
    }

    public final void kill(){
        if(alive) alive = false;
        System.out.println(nameInEnglish + "has been killed!");
    }

    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(!(otherObject instanceof Animal other)) return false;
        return nameInEnglish.equalsIgnoreCase(other.nameInEnglish)
                && years == other.years
                && alive == other.alive
                && amountOfFood == other.amountOfFood
                && health == other.health;
    }

    @Override
    public int hashCode(){
        return Objects.hash(nameInEnglish, years, alive, amountOfFood, health);

    }

    @Override
    public String toString(){
        return getClass().getName() + "[name = " + nameInEnglish + ", years = " + years + "alive = " +
                alive + "eats = " + amountOfFood + "health" + health + "]";
    }

    public abstract void feed();
    public abstract void attack(Animal a);
}
