package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {

    Enemy k;
    BlockingQueue<GameCharacter> turnsQueue;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        k = new Enemy("Enegimo", 3, 2, 3, 1, turnsQueue);
    }


    @Test
    void getName() {
        assertEquals("Enegimo", k.getName());
    }

    @Test
    void getMaxHp() {
        assertEquals(2, k.getMaxHp());
    }

    @Test
    void getDefense() {
        assertEquals(3, k.getDefense());
    }

    @Test
    void getCurrentHp() {
        assertEquals(2, k.getCurrentHp());
    }

    @Test
    void setCurrentHp() throws InvalidStatValueException {
        k.setCurrentHp(1);
        assertEquals(1, k.getCurrentHp());
    }
}