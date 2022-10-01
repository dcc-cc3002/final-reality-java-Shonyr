package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and Jonathan Riquelme
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

/**
 * A {@link PlayerCharacter} that has uses magic power.
 */
public interface Mage extends PlayerCharacter {

  /**
   * Returns the character's current MP.
   */
  int getCurrentMp();

  /**
   * Sets the character's current MP.
   */
  void setCurrentMp(final int currentMp) throws InvalidStatValueException;

  /**
   * Returns the character's max MP.
   */
  int getMaxMp();
}