import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class CrocodileTest {

    @Test
    void test() {
        Crocodile temp = new Crocodile("Stefan", 20, 40, 31);
        assertTrue(temp.test(temp));
    }

    @Test
    void compareTo(){
        Crocodile temp = new Crocodile("f", 20, 20, 20);
        Crocodile temp2 = new Crocodile("g", 21, 21, 21);
        assertEquals(-1, temp.compareTo(temp2));
        temp.setAmountOfTeeth(21);
        assertEquals(0, temp.compareTo(temp2));
        temp.setAmountOfTeeth(22);
        assertEquals(1, temp.compareTo(temp2));
    }

    @Test
    void feed(){
        Crocodile temp = new Crocodile("B", 4, 21, 22);
        double food1 = temp.getAmountOfFood();
        assertEquals(food1/2, temp.feed());
        temp.setYears(2);
        temp.setHasEaten(false);
        assertEquals(food1/4, temp.feed());
    }

    @Test
    void attack(){
        Crocodile temp = new Crocodile("f", 20, 20, 2);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        double health = temp1.getHealth();
        temp.attack(temp1);
        assertEquals(health - temp1.getHealth(), (temp.getAmountOfTeeth() / 2.0) * temp.getYears());
        temp.setAmountOfTeeth(200);
        temp1.setHealth(health);
        temp.attack(temp1);
        assertFalse(temp1.isAlive());
        temp1.setHealth(health);
        temp.attack(temp1);
        assertEquals(health, temp1.getHealth());
    }

    @Test
    void equals(){
        Crocodile temp = new Crocodile("g", 21, 21, 21);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        assertTrue(temp.equals(temp1));
        temp.setAmountOfTeeth(2);
        assertFalse(temp.equals(temp1));
        temp.setYears(2);
        assertFalse(temp.equals(temp1));
    }

    @Test
    void testToString(){
        Crocodile temp = new Crocodile("g", 21, 21, 21);
        assertEquals(temp.getClass().getName() + "[name = " + temp.getNameInEnglish() + ", years = " + temp.getYears() + ", alive = " +
                temp.isAlive() + ", eats = " + temp.getAmountOfFood() + ", health = " + temp.getHealth() + "]" + "[Teeth = " + temp.getAmountOfTeeth() + "]" ,temp.toString());
    }

    @Test
    void testHashCode(){
        Crocodile temp = new Crocodile("g", 21, 21, 21);
        assertEquals(Objects.hash(temp.getNameInEnglish(), temp.getYears(), temp.isAlive(), temp.getAmountOfFood(),
                temp.getHealth()) + Objects.hash(temp.getAmountOfTeeth()), temp.hashCode());
    }

    @Test
    void testCompare(){
        Crocodile temp = new Crocodile("g", 21, 21, 21);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        assertEquals(temp.compareTo(temp1), temp1.compare(temp));
    }

    @Test
    void testIsAdult(){
        Crocodile temp = new Crocodile("g", 21, 21, 21);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        assertEquals(temp.test(temp1), temp.isAdult(temp1));
    }


}