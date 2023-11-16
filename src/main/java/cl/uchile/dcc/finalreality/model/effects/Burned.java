package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;

public class Burned implements Effect {
    private int magicDmg;

    public Burned(int magicDmg) {
        this.magicDmg = magicDmg;
    }

    public void activate(Enemy e) throws InvalidStatValueException {
        e.statusBurned(this.magicDmg);
    }
}
