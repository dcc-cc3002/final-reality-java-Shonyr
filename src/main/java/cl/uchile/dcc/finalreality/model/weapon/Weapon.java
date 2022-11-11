package cl.uchile.dcc.finalreality.model.weapon;


import cl.uchile.dcc.finalreality.model.character.player.*;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 */
public interface Weapon {

  /*
   * Returns the name of the weapon
   */
  String getName();

  /*
   * returns the damage of the weapon
   */
  int getDamage();

  /*
   * returns the weight of the weapon
   */
  int getWeight();

  /*
   * Equip the weapon or not depending on whether a thief can use it
   */
  void equippedByThief(Thief thief);

  /*
   * Equip the weapon or not depending on whether a BlackMage can use it
   */
  void equippedByBlackMage(BlackMage blackmage);

  /*
   * Equip the weapon or not depending on whether a Engineer can use it
   */
  void equippedByEngineer(Engineer engineer);

  /*
   * Equip the weapon or not depending on whether a Knight can use it
   */
  void equippedByKnight(Knight knight);

  /*
   * Equip the weapon or not depending on whether a WhiteMage can use it
   */
  void equippedByWhiteMage(WhiteMage whiteMage);
}
