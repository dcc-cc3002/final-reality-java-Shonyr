package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
    Staff s;
    Staff f;

    Staff t;

    Knife k;

    @BeforeEach
    void setUp() {
        s = new Staff("Staff", 1, 1);
        f = new Staff("Staff", 1, 1);
        k = new Knife("Staff", 1, 1);
        t = new Staff("Palo", 2, 2);
    }

    @Test
    void testEquals() {
        assertEquals(s, f);
        assertNotEquals(s, k);
        assertNotEquals(s, t);
    }

    @Test
    void testHashCode() {
        assertEquals(s.hashCode(), f.hashCode());
        assertNotEquals(s.hashCode(), t.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Staff{name='"+s.getName()+"', damage="+s.getDamage()+", weight="+s.getWeight()+"}", s.toString());
    }
}