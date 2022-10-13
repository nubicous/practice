import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ZooWorker extends FoodProvider{

    private String name;
    private int idCode;

    public ArrayList<Animal> getListOfAnimals(Animal... animals){
        return new ArrayList<>(Arrays.asList(animals));
    }


    public ArrayList<Animal> hasEaten(ArrayList<Animal> animalsToCheck){
        ArrayList<Animal> haventEaten= new ArrayList<>();
        for (Animal animal : animalsToCheck) if(!animal.isHasEaten()) haventEaten.add(animal);
        return haventEaten;
    }

    public void feed(ArrayList<Animal> anim) {
        ArrayList<Animal> haventEaten = hasEaten(anim);
        setDailyUsage(haventEaten);
        if (getDailyUsage() < getFoodInStorage()){
            for (Animal animal : haventEaten) {
                setFoodInStorage(getFoodInStorage() - animal.getAmountOfFood());
                animal.setHasEaten(true);
            }
        }
        else{
            orderFood();
            feed(haventEaten);
        }
    }
}
