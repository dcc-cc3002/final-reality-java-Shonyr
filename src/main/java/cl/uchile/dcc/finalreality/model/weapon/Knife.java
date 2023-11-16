package cl.uchile.dcc.finalreality.model.weapon;



import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief;

import java.util.Objects;

/**
 * A class that represents a type of weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Jonathan Riquelme
 */
public class Knife extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, and weight.
   */
  public Knife(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equippedByThief(Thief thief) {
    thief.equipfr(this);
  }

  @Override
  public void equippedByKnight(Knight knight) {
    knight.equipfr(this);
  }

  @Override
  public void equippedByBlackMage(BlackMage blackMage) {
    blackMage.equipfr(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Knife weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
            && damage == weapon.damage
            && weight == weapon.weight
            && name.equals(weapon.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Knife.class, name, damage, weight);
  }

  @Override
  public String toString() {
    return "Knife{name='%s', damage=%d, weight=%d}"
            .formatted(name, damage, weight);
  }
}
