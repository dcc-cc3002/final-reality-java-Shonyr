package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AxeTest {
    Axe a;
    Axe b;

    Axe x;
    Bow j;

    @BeforeEach
    void setUp() {
        a = new Axe("Axe", 1, 1);
        b = new Axe("Axe", 1, 1);
        j = new Bow("Axe", 1, 1);
        x = new Axe("Hacha", 2, 2);
    }

    @Test
    void testEquals() {
        assertEquals(a, b);
        assertNotEquals(a, j);
        assertNotEquals(a, x);

    }

    @Test
    void testHashCode() {
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), x.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Axe{name='"+a.getName()+"', damage="+a.getDamage()+", weight="+a.getWeight()+"}", a.toString());
    }
}