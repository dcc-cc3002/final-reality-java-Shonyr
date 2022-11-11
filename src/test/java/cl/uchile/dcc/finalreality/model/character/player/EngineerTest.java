package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest {

    Engineer en;
    Engineer en2;
    Engineer en3;

    Knight k;

    BlockingQueue<GameCharacter> turnsQueue;

    Axe a;
    Sword s;

    Bow b;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        en = new Engineer("Engineer", 1, 1, turnsQueue);
        en2 = new Engineer("Engineer", 1, 1, turnsQueue);
        en3 = new Engineer("Ingeniero", 2, 2, turnsQueue);
        k = new Knight("Knight", 1, 1, turnsQueue);

        s = new Sword("Sword", 1, 1);
        a = new Axe("Axe", 1, 1);
        b = new Bow("Bow", 1, 1);
    }

    @Test
    void equip() {
        en.equip(s);
        assertNotEquals(s, en.getEquippedWeapon());

        en.equip(a);
        assertEquals(a, en.getEquippedWeapon());

        en.equip(b);
        assertEquals(b, en.getEquippedWeapon());
    }

    @Test
    void testToString() {
        assertEquals("Engineer{maxHp="+en.getMaxHp()+", defense="+en.getDefense()+", name='"+en.getName()+"'}", en.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(en.hashCode(), en2.hashCode());
        assertNotEquals(en.hashCode(), en3.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(en, en);
        assertEquals(en, en2);
        assertNotEquals(en, en3);
        assertNotEquals(en, k);
    }
}