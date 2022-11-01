import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ZooWorkerTest {

    @Test
    void testHasEatenIfAnimalHasEatenAlready(){
        ZooWorker worker1 = new ZooWorker();
        ArrayList<Animal> temp = new ArrayList<>();
        Crocodile crocHasEaten = new Crocodile("O", 10, 20, 10);
        crocHasEaten.setHasEaten(true);
        temp.add(crocHasEaten);
        assertEquals(0, worker1.hasEaten(temp).size());
    }

    @Test
    void testHasEatenIfAnimalHasntEatenAlready(){
        ZooWorker worker1 = new ZooWorker();
        ArrayList<Animal> temp = new ArrayList<>();
        Crocodile crocHasEaten = new Crocodile("O", 10, 20, 10);
        temp.add(crocHasEaten);
        assertEquals(1, worker1.hasEaten(temp).size());
    }


    @Test
    void testFeedWhenDailyUsageIsSmallerThanFoodInStorage(){
        ArrayList<Animal> temp = new ArrayList<>() {
            {
                add(new Animal("I", 20, 10) {
                    @Override
                    public double feed() {
                        return 0;
                    }

                    @Override
                    public double attack(Animal a) {
                        return 0;
                    }
                });
            }
        };
        ZooWorker temp1 = new ZooWorker();
        temp1.setFoodInStorage(20);
        temp1.feed(temp);
        assertTrue(temp.get(0).isHasEaten());
    }

    @Test
    void testFeedWhenDailyUsageIsBiggerThanFoodInStorage(){
        ArrayList<Animal> temp = new ArrayList<>() {
            {
                add(new Animal("I", 20, 30) {
                    @Override
                    public double feed() {
                        return 0;
                    }

                    @Override
                    public double attack(Animal a) {
                        return 0;
                    }
                });
            }
        };
        ZooWorker temp1 = new ZooWorker();
        temp1.setFoodInStorage(20);
        temp1.feed(temp);
        assertTrue(temp.get(0).isHasEaten());
    }
}