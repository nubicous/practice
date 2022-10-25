import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GiraffeTest {

    @Test
    void getHeight() {
        Giraffe temp = new Giraffe("G", 20, 30, 6);
        assertEquals(6, temp.getHeight());
    }

    @Test
    void setHeight() {
        Giraffe temp = new Giraffe("G", 20, 30, 6);
        temp.setHeight(7);
        assertEquals(7, temp.getHeight());
    }

    @Test
    void makeBigger() {
        Giraffe temp = new Giraffe("G", 20, 30, 6);
        int grow = 2;
        assertEquals(temp.getHeight() + grow, temp.makeBigger(2));
    }

    @Test
    void feed() {
        Giraffe temp = new Giraffe("G", 20, 30, 6);
        assertEquals(30, temp.feed());
        temp.setYears(2);
        assertEquals(0, temp.feed());
    }

    @Test
    void attack() {
        Giraffe temp = new Giraffe("G", 20, 30, 6);
        Giraffe temp1 = new Giraffe("O", 20, 30, 7);
        double health = temp1.getHealth();
        temp.attack(temp1);
        assertEquals(health - (temp.getHeight()*(temp.getYears())/(2)), temp1.getHealth());
        temp.setHealth(40);
        temp1.setHealth(health);
        temp.attack(temp1);
        assertEquals(health - ((temp.getHeight()*(temp.getYears())/(2)) + 20), temp1.getHealth());
    }

    @Test
    void testEquals() {
        Giraffe temp = new Giraffe("O", 21, 21, 21);
        Giraffe temp1 = new Giraffe("O", 21, 21, 21);
        assertTrue(temp.equals(temp1));
        temp.setHeight(2);
        assertFalse(temp.equals(temp1));
        temp.setYears(2);
        assertFalse(temp.equals(temp1));
    }

    @Test
    void testToString() {
        Giraffe temp = new Giraffe("O", 21, 21, 21);
        assertEquals(temp.getClass().getName() + "[name = " + temp.getNameInEnglish() + ", years = " +
                temp.getYears() + ", alive = " + temp.isAlive() + ", eats = " + temp.getAmountOfFood() + ", health = "
                + temp.getHealth() + "]" + "[Height = " + temp.getHeight() + "]" ,temp.toString());
    }

    @Test
    void testHashCode() {
        Giraffe temp = new Giraffe("O", 21, 21, 21);
        assertEquals(Objects.hash(temp.getNameInEnglish(), temp.getYears(), temp.isAlive(), temp.getAmountOfFood(),
                temp.getHealth()) + Objects.hash(temp.getHeight()), temp.hashCode());
    }

    @Test
    void giveBirth() {
        Giraffe.MasaiGiraffe g = new Giraffe.MasaiGiraffe("O", 20, 50);
        assertEquals(g, Giraffe.giveBirth("O", 20, 50));
    }
}