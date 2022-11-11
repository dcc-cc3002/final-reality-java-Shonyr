package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWeaponTest {

    Knife k;
    @BeforeEach
    void setUp() {
        k = new Knife("Cuchillo", 5, 90);
    }

    @Test
    void getName() {
        assertEquals("Cuchillo", k.getName());
    }

    @Test
    void getDamage() {
        assertEquals(5, k.getDamage());
    }

    @Test
    void getWeight() {
        assertEquals(90, k.getWeight());
    }
}