package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnifeTest {
    Knife k;
    Knife l;

    Knife n;

    Sword s;


    @BeforeEach
    void setUp() {
        k = new Knife("Knife", 1, 1);
        l = new Knife("Knife", 1, 1);
        s = new Sword("Knife", 1, 1);
        n = new Knife("Cuchillo", 2, 2);
    }

    @Test
    void testEquals() {
        assertEquals(k, l);
        assertNotEquals(k, s);
        assertNotEquals(k, n);
    }

    @Test
    void testHashCode() {
        assertEquals(k.hashCode(), l.hashCode());
        assertNotEquals(k.hashCode(), n.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Knife{name='"+k.getName()+"', damage="+k.getDamage()+", weight="+k.getWeight()+"}", k.toString());
    }
}