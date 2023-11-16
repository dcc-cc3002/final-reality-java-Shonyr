package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int attack;

  Random random = new Random();

  public List<Effect> adverseEffects = new ArrayList<Effect>();


  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int attack, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.attack = attack;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Attacks a character
   */
  public void attack(GameCharacter gc) throws InvalidStatValueException {
    gc.attacked(this.attack);
  }

  /**
   * Effects that happen when hit by a thunder spell
   */
  public void affectedByThunder(int dmg) throws InvalidStatValueException {
    this.setCurrentHp(getCurrentHp() - dmg);
    if (random.nextInt(9) < 3){
      this.adverseEffects.add(new Paralyzed());
    }
  }

  /**
   * Effects that happen when hit by a fire spell
   */
  public void affectedByFire(int dmg) throws InvalidStatValueException {
    this.setCurrentHp(getCurrentHp() - dmg);
    if (random.nextInt(9) < 2){
      this.adverseEffects.add(new Burned(dmg));
    }
  }

  /**
   * Effect that happens when burned
   */
  public void statusBurned(int magicDmg) throws InvalidStatValueException {
    this.setCurrentHp(this.getCurrentHp() - magicDmg/2);
  }

  /**
   * Effect that happens when hit by a poison spell
   */
  public void affectedByPoison(int magicDmg){
    this.adverseEffects.add(new Poisoned(magicDmg));
  }


  /**
   * Effect that happens when poisoned
   */
  public void statusPoisoned(int magicDmg) throws InvalidStatValueException {
    this.setCurrentHp(this.getCurrentHp() - magicDmg/3);
  }

  /**
   * Effects that happen when hit by a thunder paralysis spell
   */
  public void affectedByParalysis(){
    this.adverseEffects.add(new Paralyzed());
  }


  /**
   * Fuction that notifies all the effects that the enemy is afected by
   */
  public void notifyEffects() throws InvalidStatValueException {
    for (Effect ef :  this.adverseEffects){
      ef.activate(this);
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && weight == enemy.weight
        && maxHp == enemy.maxHp
        && defense == enemy.defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ enemy.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);
  }
}
