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

class KnightTest {

    Knight k;
    Knight k2;
    Knight k3;

    Thief t;
    BlockingQueue<GameCharacter> turnsQueue;

    Sword s;
    Bow b;

    Axe a;

    Knife n;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        k = new Knight("Knight", 1, 1, turnsQueue);
        k2 = new Knight("Knight", 1, 1, turnsQueue);
        k3 = new Knight("Callabero", 2, 2, turnsQueue);
        t = new Thief("Ladron", 1, 1, turnsQueue);

        s = new Sword("Sword", 1, 1);
        b = new Bow("Bow", 1, 1);
        a = new Axe("Axe", 1, 1);
        n = new Knife("knife", 1, 1);
    }

    @Test
    void equip() {
        k.equip(b);
        assertNotEquals(b, k.getEquippedWeapon());

        k.equip(s);
        assertEquals(s, k.getEquippedWeapon());

        k.equip(a);
        assertEquals(a, k.getEquippedWeapon());

        k.equip(n);
        assertEquals(n, k.getEquippedWeapon());
    }

    @Test
    void testToString() {
        assertEquals("Knight{maxHp="+k.getMaxHp()+", defense="+k.getDefense()+", name='"+k.getName()+"'}", k.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(k, k2);
        assertNotEquals(k, k3);
    }

    @Test
    void testEquals() {
        assertEquals(k, k);
        assertEquals(k, k2);
        assertNotEquals(k, k3);
        assertNotEquals(k, t);
    }
}