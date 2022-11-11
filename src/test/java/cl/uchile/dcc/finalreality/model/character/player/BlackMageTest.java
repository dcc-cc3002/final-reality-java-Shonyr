package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest {
    BlackMage bm;
    BlackMage bm2;
    BlackMage bm3;
    Knight n;
    BlockingQueue<GameCharacter> turnsQueue;

    Sword s;
    Knife k;

    Staff t;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        bm = new BlackMage("BM", 1, 1, 1, turnsQueue);
        bm2 = new BlackMage("BM", 1, 1, 1, turnsQueue);
        bm3 = new BlackMage("BM2", 2, 2, 2, turnsQueue);
        n = new Knight("Knight", 1, 1, turnsQueue);

        s = new Sword("Sword", 1, 1);
        k = new Knife("Knife", 1, 1);
        t = new Staff("Staff", 1, 1);
    }

    @Test
    void equip() {
        bm.equip(s);
        assertNotEquals(s, bm.getEquippedWeapon());

        bm.equip(k);
        assertEquals(k, bm.getEquippedWeapon());

        bm.equip(t);
        assertEquals(t, bm.getEquippedWeapon());

    }

    @Test
    void testEquals() {
        assertEquals(bm, bm);
        assertNotEquals(bm, n);
        assertEquals(bm, bm2);
        assertNotEquals(bm, bm3);
    }

    @Test
    void testToString() {
        assertEquals("BlackMage{maxMp="+bm2.getMaxMp()+", maxHp="+bm2.getMaxHp()+", defense="+bm2.getDefense()+", name='"+bm2.getName()+"'}", bm2.toString());
        assertEquals("BlackMage{maxMp="+bm3.getMaxMp()+", maxHp="+bm3.getMaxHp()+", defense="+bm3.getDefense()+", name='"+bm3.getName()+"'}", bm3.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(bm.hashCode(), bm2.hashCode());
        assertNotEquals(bm.hashCode(), bm3.hashCode());
    }
}