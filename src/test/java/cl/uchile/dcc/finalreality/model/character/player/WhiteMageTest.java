package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest {

    WhiteMage wm;
    WhiteMage wm2;
    WhiteMage wm3;
    Knight n;

    Staff s;

    Bow b;
    BlockingQueue<GameCharacter> turnsQueue;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        wm = new WhiteMage("WM", 1, 1, 1, turnsQueue);
        wm2 = new WhiteMage("WM", 1, 1, 1, turnsQueue);
        wm3 = new WhiteMage("WM2", 2, 2, 2, turnsQueue);
        n = new Knight("Knight", 1, 1, turnsQueue);

        s = new Staff("Staff", 1, 1);
        b = new Bow("Bow", 1, 1);

    }

    @Test
    void equip() {
        wm.equip(b);
        assertNotEquals(b, wm.getEquippedWeapon());

        wm.equip(s);
        assertEquals(s, wm.getEquippedWeapon());
    }

    @Test
    void testEquals() {
        assertEquals(wm, wm);
        assertEquals(wm, wm2);
        assertNotEquals(wm, wm3);
        assertNotEquals(wm, n);
    }

    @Test
    void testHashCode() {
        assertEquals(wm, wm2);
        assertNotEquals(wm, wm3);
    }

    @Test
    void testToString() {
        assertEquals("WhiteMage{maxMp="+wm.getMaxMp()+", maxHp="+wm.getMaxHp()+", defense="+wm.getDefense()+", name='"+wm.getName()+"'}", wm.toString());
    }
}