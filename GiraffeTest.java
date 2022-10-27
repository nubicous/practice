import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GiraffeTest {

    @Test
    void testMakeBiggerWorks() {
        Giraffe temp = new Giraffe("G", 20, 30, 6);
        assertEquals(8, temp.makeBigger(2));
    }

    @Test
    void feedWhenBelow3Years() {
        Giraffe temp = new Giraffe("G", 2, 30, 6);
        assertEquals(0, temp.feed());
    }

    @Test
    void feedWhenOver3Years() {
        Giraffe temp = new Giraffe("G", 5, 30, 6);
        assertEquals(temp.getAmountOfFood(), temp.feed());
    }

    @Test
    void testAttackWithOutCritCorrectDamage(){
        Giraffe attacker = new Giraffe("G", 20, 30, 6);
        Giraffe gettingBitUp = new Giraffe("O", 20, 30, 7);
        attacker.attack(gettingBitUp);
        assertEquals(140, gettingBitUp.getHealth());
    }

    @Test
    void testAttackWithCritCorrectDamage(){
        Giraffe attacker = new Giraffe("G", 20, 30, 6);
        Giraffe gettingBitUp = new Giraffe("O", 20, 30, 7);
        attacker.setHealth(49);
        attacker.attack(gettingBitUp);
        assertEquals(120, gettingBitUp.getHealth());
    }

    @Test
    void testAttackWhenAttackerIsDead(){
        Giraffe attacker = new Giraffe("G", 20, 30, 6);
        Giraffe gettingBitUp = new Giraffe("O", 20, 30, 7);
        attacker.setAlive(false);
        assertEquals(0, attacker.attack(gettingBitUp));
    }

    @Test
    void testAttackWhenGettingBitUpIsDead(){
        Giraffe attacker = new Giraffe("G", 20, 30, 6);
        Giraffe gettingBitUp = new Giraffe("O", 20, 30, 7);
        gettingBitUp.setAlive(false);
        assertEquals(0, attacker.attack(gettingBitUp));
    }

    @Test
    void testEqualsSameHeight() {
        Giraffe temp = new Giraffe("O", 21, 21, 21);
        Giraffe temp1 = new Giraffe("O", 21, 21, 21);
        assertTrue(temp.equals(temp1));
    }

    @Test
    void testEqualsDifferentHeight() {
        Giraffe temp = new Giraffe("O", 21, 21, 21);
        Giraffe temp1 = new Giraffe("O", 21, 21, 4);
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
    void testGiveBirth() {
        Giraffe.MasaiGiraffe g = new Giraffe.MasaiGiraffe("O", 20, 50);
        assertEquals(g, Giraffe.giveBirth("O", 20, 50));
    }

    @Test
    void testEqualsMasaiGiraffeDifferentParameters(){
        Giraffe.MasaiGiraffe temp = new Giraffe.MasaiGiraffe("O", 10, 30);
        Giraffe.MasaiGiraffe temp1 = new Giraffe.MasaiGiraffe("G", 10, 30);
        assertFalse(temp.equals(temp1));
    }

    @Test
    void testEqualsMasaiGiraffeDifferentClassParameter(){
        Giraffe.MasaiGiraffe temp = new Giraffe.MasaiGiraffe("O", 10, 30);
        Giraffe temp1 = new Giraffe("O", 20, 25, 6);
        assertFalse(temp.equals(temp1));
    }
}