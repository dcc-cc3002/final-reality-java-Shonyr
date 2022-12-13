package cl.uchile.dcc.finalreality.model.weapon;













import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief;


/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 */
public abstract class AbstractWeapon implements Weapon {
  protected final String name;
  protected final int damage;
  protected final int weight;


  /**
   * Creates a weapon with a name, a base damage, and weight.
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getName() {
    return name;
  }


  @Override
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void equippedByThief(Thief thief) {
    ;
  }

  @Override
  public void equippedByBlackMage(BlackMage blackmage) {
    ;
  }

  @Override
  public void equippedByEngineer(Engineer engineer) {
    ;
  }

  @Override
  public void equippedByKnight(Knight knight) {
    ;
  }

  @Override
  public void equippedByWhiteMage(WhiteMage whitemage) {
    ;
  }

  @Override
  public int spellDamage(){
    return this.getDamage()*3/4;
  }

}
