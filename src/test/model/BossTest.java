package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    public void bossTest() {
        Boss boss = new Boss("John", 1);
        assertEquals(1, boss.health);
        assertEquals("John", boss.name);
    }

    @Test
    public void bossListTest() {
        Boss boss1 = new Boss("Boss1", 1);
        Boss boss2 = new Boss("Boss2", 2);
        AllBosses bossList = new AllBosses();
        bossList.addBoss(boss1);
        assertEquals(1, bossList.listSize());
        bossList.addBoss(boss2);
        assertEquals(2, bossList.listSize());
    }

}