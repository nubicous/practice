import java.util.ArrayList;

public class FoodProvider {

    private double foodInStorage;
    private double dailyUsage;

    public void setFoodInStorage(double food){
        this.foodInStorage = food;
    }

    public double getFoodInStorage(){
        return foodInStorage;
    }

    public void setDailyUsage(ArrayList<Animal> animals){
        dailyUsage = 0;
        for (Animal anim : animals){
            dailyUsage += anim.getAmountOfFood();
        }
    }

    public double getDailyUsage(){
        return dailyUsage;
    }


    public void orderFood(){
        setFoodInStorage(foodInStorage + dailyUsage);
    }

}
