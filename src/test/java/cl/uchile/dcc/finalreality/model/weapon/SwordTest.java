package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
    Sword s;
    Sword x;

    Sword w;
    Axe a;

    @BeforeEach
    void setUp() throws Exception{
       s = new Sword("Sword", 1, 1);
       x = new Sword("Sword", 1, 1);
       a = new Axe("Sword", 1, 1);
       w = new Sword("Espada", 2, 2);
    }

    @Test
    void testEquals() {
        assertEquals(s, x);
        assertNotEquals(s, a);
        assertNotEquals(s, w);
    }

    @Test
    void testHashCode() {
        assertEquals(s.hashCode(), x.hashCode());
        assertNotEquals(s.hashCode(), w.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Sword{name='"+s.getName()+"', damage="+s.getDamage()+", weight="+s.getWeight()+"}", s.toString());
    }
}