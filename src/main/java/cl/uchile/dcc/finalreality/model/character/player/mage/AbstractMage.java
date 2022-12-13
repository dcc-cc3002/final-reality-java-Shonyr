/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the MP related information and methods for magic-oriented characters.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 * @version 2.0
 */
public abstract class AbstractMage extends AbstractPlayerCharacter implements Mage {
  protected int currentMp;
  protected final int maxMp;

  /**
  * Creates a new Black Mage.
  *
  * @param name       the character's name
  * @param maxHp      the character's max hp
  * @param defense    the character's defense
  * @param turnsQueue the queue with the characters waiting for their turn
  */


  public AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                         int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }


  // region : ACCESSORS

  @Override
  public int getCurrentMp() {
    return currentMp;
  }


  @Override
  public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }


  @Override
  public int getMaxMp() {
    return maxMp;
  }
  // endregion
}