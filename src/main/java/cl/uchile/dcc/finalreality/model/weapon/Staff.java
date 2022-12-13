package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;

import java.util.Objects;

/**
 * A class that represents a type of weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 */
public class Staff extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, and weight.
   */
  public Staff(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equippedByBlackMage(BlackMage blackmage) {
    blackmage.equipfr(this);
  }

  @Override
  public void equippedByWhiteMage(WhiteMage whiteMage) {
    whiteMage.equipfr(this);
  }


  @Override
  public int spellDamage(){
    return this.getDamage();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Staff weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
            && damage == weapon.damage
            && weight == weapon.weight
            && name.equals(weapon.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, name, damage, weight);
  }

  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, weight=%d}"
            .formatted(name, damage, weight);
  }
}
