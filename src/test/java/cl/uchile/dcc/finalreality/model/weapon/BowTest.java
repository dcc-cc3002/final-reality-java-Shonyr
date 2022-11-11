package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {
    Bow b;
    Bow c;
    Bow o;
    Staff s;

    @BeforeEach
    void setUp() {
        b = new Bow("Bow", 1, 1);
        c = new Bow("Bow", 1, 1);
        s = new Staff("Bow", 1, 1);
        o = new Bow("Arco", 2, 2);
    }

    @Test
    void testEquals() {
        assertEquals(b, b);
        assertEquals(b, c);
        assertNotEquals(b, s);
        assertNotEquals(b, o);
    }

    @Test
    void testHashCode() {
        assertEquals(b.hashCode(), c.hashCode());
        assertNotEquals(b.hashCode(), o.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Bow{name='"+b.getName()+"', damage="+b.getDamage()+", weight="+b.getWeight()+"}", b.toString());
    }
}