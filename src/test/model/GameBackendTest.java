package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameBackendTest {

    @Test
    public void gameBackendInitializationTest() {
        GameBackend toTest = new GameBackend();
        assertEquals(0, toTest.prestigeLevel);
        assertEquals(1, toTest.weaponLevel);
        assertEquals(0, toTest.balance);
        assertEquals(1, toTest.stage);
        assertEquals(1, toTest.level);
        assertEquals(3, toTest.currentEnemyHealth);
        assertEquals(1, toTest.upgradeCost);
        assertEquals(3, toTest.maxEnemyHealth);
        assertEquals(0, toTest.listOfBosses.listSize());
    }

    @Test
    public void onPrestigeTest() {
        GameBackend toTest = new GameBackend();
        toTest.onPrestige();
        assertEquals(1, toTest.prestigeLevel);
        assertEquals(1, toTest.weaponLevel);
        assertEquals(0, toTest.balance);
        assertEquals(1, toTest.stage);
        assertEquals(1, toTest.level);
        assertEquals(3, toTest.currentEnemyHealth);
        assertEquals(1, toTest.upgradeCost);
        assertEquals(3, toTest.maxEnemyHealth);
        assertEquals(0, toTest.listOfBosses.listSize());
    }

    @Test
    public void isPrestigeNotZeroTest() {
        GameBackend toTest = new GameBackend();
        assertFalse(toTest.isPrestigeNotZero());
        toTest.onPrestige();
        assertTrue(toTest.isPrestigeNotZero());
    }

    @Test
    public void attackDamageCalculatorTest() {
        GameBackend toTest = new GameBackend();
        assertEquals(3, toTest.attackDamageCalculator());
        toTest.onPrestige();
        assertEquals(3.15, toTest.attackDamageCalculator());
    }

    @Test
    public void getBalanceTest() {
        GameBackend toTest = new GameBackend();
        assertEquals(0, toTest.getBalance());
        toTest.balance += 100;
        assertEquals(100,toTest.getBalance());
    }
}
