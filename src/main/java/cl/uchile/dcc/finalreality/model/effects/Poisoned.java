package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;

public class Poisoned implements Effect {
    private int magicDmg;

    public Poisoned(int magicDmg) {
        this.magicDmg = magicDmg;
    }


    public void activate(Enemy e) throws InvalidStatValueException {
        e.statusPoisoned(this.magicDmg);
    }
}
