import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class CrocodileTest {

    @Test
    void testCompareToFirstSmaller(){
        Crocodile temp = new Crocodile("f", 20, 20, 20);
        Crocodile temp2 = new Crocodile("g", 21, 21, 21);
        assertEquals(-1, temp.compareTo(temp2));
    }

    @Test
    void testCompareToEqualAmountOfTeeth(){
        Crocodile temp = new Crocodile("f", 20, 20, 20);
        Crocodile temp2 = new Crocodile("g", 21, 21, 20);
        assertEquals(0, temp.compareTo(temp2));
    }

    @Test
    void testCompareToSecondSmaller(){
        Crocodile temp = new Crocodile("f", 20, 20, 21);
        Crocodile temp2 = new Crocodile("g", 21, 21, 20);
        assertEquals(1, temp.compareTo(temp2));
    }


    @Test
    void testFeedWhenYoungish(){
        Crocodile temp = new Crocodile("B", 2, 21, 22);
        assertEquals(temp.getAmountOfFood() / 4.0, temp.feed());
    }

    @Test
    void testFeedWhenAdult(){
        Crocodile temp = new Crocodile("B", 7, 21, 22);
        assertEquals(temp.getAmountOfFood() / 2, temp.feed());
    }

    @Test
    void testFeedWhenAlreadyEaten(){
        Crocodile temp = new Crocodile("B", 7, 21, 22);
        temp.setHasEaten(true);
        assertEquals(0, temp.feed());
    }

    @Test
    void testAttackWhenDead(){
        Crocodile attacker = new Crocodile("B", 4, 21, 22);
        Crocodile gettingBitUp = new Crocodile("o", 2, 21, 4);
        attacker.setAlive(false);
        assertEquals(0, attacker.attack(gettingBitUp));
    }

    @Test
    void testAttackRegular(){
        Crocodile attacker = new Crocodile("B", 4, 21, 22);
        Crocodile gettingBitUp = new Crocodile("o", 2, 21, 4);
        attacker.attack(gettingBitUp);
        assertEquals(106, gettingBitUp.getHealth());
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
    void testCompareWhenAmountOfTeethIsEqual(){
        Crocodile temp = new Crocodile("g", 21, 21, 21);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        assertEquals(0, temp.compare(temp1));
    }

    @Test
    void testCompareWhenAmountOfTeethIsSmaller(){
        Crocodile temp = new Crocodile("g", 21, 21, 19);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        assertEquals(-1, temp.compare(temp1));
    }

    @Test
    void testCompareWhenAmountOfTeethIsBigger(){
        Crocodile temp = new Crocodile("g", 21, 21, 24);
        Crocodile temp1 = new Crocodile("g", 21, 21, 21);
        assertEquals(1, temp.compare(temp1));
    }

}