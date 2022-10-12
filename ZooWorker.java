import java.util.ArrayList;
import java.util.Arrays;

public class ZooWorker {

    private String name;
    private int idCode;

    public ArrayList<Animal> getListOfAnimals(Animal... animals){
        ArrayList<Animal> allAnimals = new ArrayList<>(Arrays.asList(animals));
        return allAnimals;
    }


    public ArrayList<Animal> hasEaten(ArrayList<Animal> animalsToCheck){
        ArrayList<Animal> haventEaten= new ArrayList<>();
        for (Animal animal : animalsToCheck) if(!animal.isHasEaten()) haventEaten.add(animal);
        return haventEaten;
    }
}
