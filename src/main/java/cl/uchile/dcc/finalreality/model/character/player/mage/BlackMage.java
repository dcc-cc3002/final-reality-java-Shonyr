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

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 * @version 2.0
 */
public class BlackMage extends AbstractMage {


  /**
   * Creates a new Black Mage.
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
   *      the character's max mp
   */

  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
                   int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public void equip(Weapon weapon) {
    weapon.equippedByBlackMage(this);
  }


  /**
   * Throws a thunder spell at an enemy
   */
  public void thunderSpell(Enemy e) throws InvalidStatValueException {
    if (this.getCurrentMp() >= 15) {
      this.setCurrentMp(this.getCurrentMp() - 15);
      e.affectedByThunder(this.getEquippedWeapon().spellDamage());
    }
  }

  /**
   * Throws a fire spell at an enemy
   */  public void fireSpell(Enemy e) throws InvalidStatValueException {
    if (this.getCurrentMp() >= 15) {
      this.setCurrentMp(this.getCurrentMp() - 15);
      e.affectedByFire(this.getEquippedWeapon().spellDamage());
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && maxHp == that.maxHp
            && defense == that.defense
            && maxMp == that.maxMp;
  }

  @Override
  public String toString() {
    return "BlackMage{maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
            .formatted(maxMp, maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, maxHp, defense, maxMp);
  }
}
