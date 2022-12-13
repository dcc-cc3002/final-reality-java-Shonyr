package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {

    Thief t;
    Thief t2;
    Thief t3;

    Knight n;

    Knife k;
    Axe a;

    Bow b;

    Sword s;

    BlockingQueue<GameCharacter> turnsQueue;
    @BeforeEach
    void setUp() throws InvalidStatValueException {
        t = new Thief("Thief", 1, 1, turnsQueue);
        t2 = new Thief("Thief", 1, 1, turnsQueue);
        t3 = new Thief("Ladron", 2, 2, turnsQueue);
        n = new Knight("Knight", 1, 1, turnsQueue);

        k = new Knife("Knife", 1, 1);
        a = new Axe("Axe", 1, 1);
        b = new Bow("Bow", 1, 1);
        s = new Sword("Sword", 1, 1);
    }

    @Test
    void equip() {
        t.equip(a);
        assertNotEquals(a, t.getEquippedWeapon());

        t.equip(k);
        assertEquals(k, t.getEquippedWeapon());

        t.equip(b);
        assertEquals(b, t.getEquippedWeapon());

        t.equip(s);
        assertEquals(s, t.getEquippedWeapon());
    }

    @Test
    void testHashCode() {
        assertEquals(t, t2);
        assertNotEquals(t, t3);
    }

    @Test
    void testEquals() {
        assertEquals(t, t);
        assertEquals(t, t2);
        assertNotEquals(t, t3);
        assertNotEquals(t, n);

    }

    @Test
    void testToString() {
        assertEquals("Thief{maxHp="+t.getMaxHp()+", defense="+t.getDefense()+", name='"+t.getName()+"'}", t.toString());
    }
}