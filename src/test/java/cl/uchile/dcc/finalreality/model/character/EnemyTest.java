package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Knight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Enemy e;
    Enemy n;
    Enemy m;

    Knight k;
    BlockingQueue<GameCharacter> turnsQueue;

    @BeforeEach
    void setUp() throws InvalidStatValueException {
        e = new Enemy("Enemigo", 1, 1, 1, turnsQueue);
        n = new Enemy("Enemigo", 1, 1, 1, turnsQueue);
        m = new Enemy("Enemig", 2, 2, 2, turnsQueue);
        turnsQueue = new LinkedBlockingQueue<>();

        k = new Knight("Knight", 1, 1, turnsQueue);
    }

    @Test
    void getWeight() {
        assertEquals(1, e.getWeight());
        assertEquals(2, m.getWeight());
    }

    @Test
    void testEquals() {
        assertEquals(e, e);
        assertEquals(e, n);
        assertNotEquals(e, m);
        assertNotEquals(e, k);
    }

    @Test
    void testHashCode() {
        assertEquals(e, n);
        assertNotEquals(e, m);

    }

    @Test
    void waitTurn() {
        e.waitTurn();
        assertEquals(Objects.requireNonNull(turnsQueue.poll()).toString(), e.toString());
    }
}