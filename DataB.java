import java.util.LinkedList;
import java.util.Scanner;

public class DataB {

    LinkedList<Animal> list;


    public void save(String name, int years, int food){
        if(find(name).getNameInEnglish() != name)list.add(new Animal(name, years, food) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        });
        else System.out.println("Animal with this name already exits!");
    }


    public Animal find(String name){
        for(Animal anim : list){
            if(anim.getNameInEnglish() == name) return anim;
        }
        return null;
    }

    public void delete(String name){
        Animal animToDelete = null;
        for(Animal anim : list){
            if(anim.getNameInEnglish() == name) animToDelete = anim;
        }

        if(animToDelete == null){
            System.out.println("No animal with such name");
        }
        else{
            list.remove(animToDelete);
        }

    }

    public void update(String name){
        Scanner sc = new Scanner(System.in);
        if(find(name).getNameInEnglish() != name){
            Animal animToUpdate = find(name);
            System.out.println("What's it name: ");
            String newName = sc.nextLine();
            System.out.println("How old it is: ");
            int years = sc.nextInt();
            System.out.println("Give amount of food: ");
            int food = sc.nextInt();
            animToUpdate.setNameInEnglish(newName);
            animToUpdate.setAmountOfFood(food);
            animToUpdate.setYears(years);
        }
        else{
            System.out.println("No animal with such name");
        }
    }

    public void display(){
        if(list.isEmpty()){
            System.out.println("No records");
        }
        for (Animal anim : list){
            System.out.println(anim.toString());
        }
    }


}
