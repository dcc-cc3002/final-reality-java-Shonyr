package cl.uchile.dcc.finalreality.model.weapon;


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
}
