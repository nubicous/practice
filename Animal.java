import java.util.Objects;

public abstract class Animal {
    private String nameInEnglish;
    private int years;
    private boolean alive = true;
    private double amountOfFood;
    private double health;

    private boolean hasEaten = false;


    public void setYears(int years){this.years = years;}
    public void setNameInEnglish(String name){this.nameInEnglish = name;}
    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

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
    public double getAmountOfFood() {
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
        return getClass().getName() + "[name = " + nameInEnglish + ", years = " + years + ", alive = " +
                alive + ", eats = " + amountOfFood + ", health = " + health + "]";
    }

    public abstract double feed();
    public abstract double attack(Animal a);
}
