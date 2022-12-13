package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {

    Knight k;
    Sword s;
    BlockingQueue<GameCharacter> turnsQueue;
    @BeforeEach
    void setUp() throws InvalidStatValueException {
        k = new Knight("Callabero", 2, 3, turnsQueue);
        s = new Sword("Sword", 1, 1);
        turnsQueue = new LinkedBlockingQueue<>();
    }

    @Test
    void getEquippedWeapon() {
        k.equip(s);

        assertEquals(s, k.getEquippedWeapon());
    }

    @Test
    void waitTurn() {
        k.waitTurn();
        assertEquals(Objects.requireNonNull(turnsQueue.poll()).toString(), k.toString());
    }
}