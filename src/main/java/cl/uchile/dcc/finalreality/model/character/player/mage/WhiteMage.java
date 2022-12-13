/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 */
public class WhiteMage extends AbstractMage {

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param maxMp
   *     the character's max mp
   */

  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
                   int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public void equip(Weapon weapon) {
    weapon.equippedByWhiteMage(this);
  }


  /**
   * Throws a poison spell at an enemy
   */
  public void poisonSpell(Enemy e) throws InvalidStatValueException {
    if (this.getCurrentMp() >= 40) {
      this.setCurrentMp(getCurrentMp() - 40);
      e.affectedByPoison(this.getEquippedWeapon().spellDamage());
    }
  }

  /**
   * Throws a paralysis spell at an enemy
   */
  public void paralysisSpell(Enemy e) throws InvalidStatValueException {
    if (this.getCurrentMp() >= 25) {
      this.setCurrentMp(getCurrentMp() - 25);
      e.affectedByParalysis();
    }
  }

  /**
   * Throws a healing spell at an ally
   */
  public void healSpell(PlayerCharacter pc) throws InvalidStatValueException {
    if (this.getCurrentMp() >= 15) {
      this.setCurrentMp(this.getCurrentMp() - 15);
      pc.affectedByHeal();
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && maxMp == that.maxMp
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, defense, maxMp);
  }

  @Override
  public String toString() {
    return "WhiteMage{maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(maxMp, maxHp, defense, name);
  }

}
