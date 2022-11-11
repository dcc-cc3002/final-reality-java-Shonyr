package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMageTest {
    WhiteMage wm;
    BlockingQueue<GameCharacter> turnsQueue;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        wm = new WhiteMage("Whitemage",1 ,1 , 10, turnsQueue);
    }

    @Test
    void getMaxMp() {
        assertEquals(10, wm.getMaxMp());
    }

    @Test
    void getCurrentMp() {
        assertEquals(10, wm.getCurrentMp());
    }

    @Test
    void setCurrentMp() throws InvalidStatValueException {
        wm.setCurrentMp(5);
        assertEquals(5, wm.getCurrentMp());
    }


}