import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testEqualsWhenSame(){
        Animal temp = new Animal("A", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        Animal temp1 = temp;
        assertTrue(temp.equals(temp1));
    }

    @Test
    void testEqualsOneIsNull(){
        Animal temp = new Animal("A", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        Animal temp1 = null;
        assertFalse(temp.equals(temp1));
    }

    @Test
    void testEqualsOtherClass(){
        ZooWorker temp = new ZooWorker();
        Animal temp1 = new Animal("A", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        assertFalse(temp1.equals(temp));
    }

    @Test
    void testEqualsOtherParameters(){
        Animal temp = new Animal("A", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        Animal temp1 = new Animal("B", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        assertFalse(temp.equals(temp1));
    }

    @Test
    void testHashCode(){
        Animal temp1 = new Animal("B", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        assertEquals(Objects.hash(temp1.getNameInEnglish(), temp1.getYears(), temp1.isAlive(),
                temp1.getAmountOfFood(), temp1.getHealth()), temp1.hashCode());
    }

    @Test
    void testToString(){
        Animal temp = new Animal("B", 10, 40) {
            @Override
            public double feed() {
                return 0;
            }

            @Override
            public double attack(Animal a) {
                return 0;
            }
        };
        assertEquals(temp.getClass().getName() + "[name = " + temp.getNameInEnglish() + ", years = " +
                temp.getYears() + ", alive = " + temp.isAlive() + ", eats = " + temp.getAmountOfFood() +
                ", health = " + temp.getHealth() + "]", temp.toString());
    }
}