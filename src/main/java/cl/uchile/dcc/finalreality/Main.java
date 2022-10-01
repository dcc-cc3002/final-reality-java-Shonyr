package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main for testing the implemented classes and their methods.
 */
public class Main {
  /**
   * Main function with all the tests.
   */
  public static void main(String[] args) throws InvalidStatValueException {

    System.out.println("----------------------------- Test weapons ------------------------------");
    Weapon s = new Sword("Espada", 1, 1);
    System.out.println(s.getName() + ' ' + s.getDamage() + ' ' + s.getWeight());
    Weapon b = new Bow("Arco", 1, 1);
    System.out.println(b.getName() + ' ' + b.getDamage() + ' ' + b.getWeight());
    Weapon st = new Staff("Palo", 1, 1);
    System.out.println(st.getName() + ' ' + st.getDamage() + ' ' + st.getWeight());
    Weapon a = new Axe("Hacha", 1, 1);
    System.out.println(a.getName() + ' ' + a.getDamage() + ' ' + a.getWeight());
    Weapon k = new Knife("Cuchillo", 1, 1);
    System.out.println(k.getName() + ' ' + k.getDamage() + ' ' + k.getWeight());

    Weapon s4 = new Bow("Espada", 1, 1);
    Weapon s3 = new Sword("Espadita", 1, 1);
    Weapon s2 = new Sword("Espada", 1, 1);

    System.out.println("Objetos de igual clase y atributos: "
            + s.equals(s2));
    System.out.println("Objetos de igual clase y distintos atributos: "
            + s.equals(s3));

    System.out.println("Objetos de clases diferentes y atributos diferentes: "
            + s.equals(b));

    System.out.println("Objetos de diferente clase e iguales atributos: "
            + s.equals(s4));

    BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();

    System.out.println("----------------------------- Test Enemy ------------------------------");

    Enemy e = new Enemy("Enemigo", 1, 3, 1, q);
    System.out.println(e.getName() + ' ' + e.getMaxHp() + ' '
            + e.getCurrentHp() + ' ' + e.getDefense() + ' ' + e.getWeight());
    e.setCurrentHp(1);
    System.out.println("Vida actual Enemigo luego de cambiarla a 1: " + e.getCurrentHp());
    Enemy e2 = new Enemy("Enemigo", 1, 3, 1, q);
    Enemy e3 = new Enemy("Misery", 1, 3, 1, q);

    System.out.println("Objetos de igual clase y atributos: "
            + e.equals(e2));
    System.out.println("Objetos de igual clase y distintos atributos: "
            + e.equals(e3));

    System.out.println("---------------------------- Test P Jugables ----------------------------");
    Engineer en = new Engineer("Ingeniero", 1, 1, q);
    en.equip(a);
    System.out.println(en.getName() + ' ' + en.getMaxHp() + ' '
            + en.getCurrentHp() + ' ' + en.getDefense() + ' ' + en.getEquippedWeapon());

    Knight kn = new Knight("Caballero", 1, 1, q);
    kn.equip(s);
    System.out.println(kn.getName() + ' ' + kn.getMaxHp() + ' '
            + kn.getCurrentHp() + ' ' + kn.getDefense() + ' ' + kn.getEquippedWeapon());

    Thief t = new Thief("Ladron", 1, 1, q);
    t.equip(b);
    System.out.println(t.getName() + ' ' + t.getMaxHp() + ' '
            + t.getCurrentHp() + ' ' + t.getDefense() + ' ' + t.getEquippedWeapon());

    Knight kn2 = new Knight("Caballero", 1, 1, q);
    Knight kn3 = new Knight("Callabero", 1, 1, q);

    System.out.println("Objetos de igual clase y atributos: "
            + kn.equals(kn2));
    System.out.println("Objetos de igual clase y distintos atributos: "
            + kn.equals(kn3));

    Engineer en2 = new Engineer("Caballero", 1, 1, q);
    System.out.println("Objetos de distinta clase e igualles atributos: "
            + kn.equals(en2));

    System.out.println(" ----------- Test Magos -----------");
    BlackMage bm = new BlackMage("Mago negro", 1, 1, 1, q);
    bm.equip(st);
    System.out.println(bm.getName() + ' ' + bm.getMaxHp() + ' ' + bm.getCurrentHp() + ' '
            + bm.getDefense() + ' ' + bm.getMaxMp() + ' '
            + bm.getCurrentMp() + ' ' + bm.getEquippedWeapon());
    WhiteMage wm = new WhiteMage("Mago blanco", 1, 1, 1, q);
    wm.equip(k);
    System.out.println(wm.getName() + ' ' + wm.getMaxHp() + ' ' + wm.getCurrentHp() + ' '
            + wm.getDefense() + ' ' + wm.getMaxMp() + ' '
            + wm.getCurrentMp() + ' ' + wm.getEquippedWeapon());

    BlackMage bm2 = new BlackMage("Mago negro", 1, 1, 1, q);
    BlackMage bm3 = new BlackMage("Mago oscuro", 1, 1, 1, q);
    WhiteMage wm2 = new WhiteMage("Mago blanco", 1, 1, 1, q);
    System.out.println("Arma equipada por defecto en un personaje: "
            + bm2.getEquippedWeapon());
    System.out.println("Objetos de igual clase y atributos: "
            + bm.equals(bm2));
    System.out.println("Objetos de igual clase y diferentes atributos: "
            + bm.equals(bm3));

    System.out.println("Objetos de igual clase y atributos: "
            + wm.equals(wm2));
    System.out.println("Objetos de diferente clase y diferentes atributos: "
            + bm.equals(wm));

    System.out.println(" ");
    System.out.println("* Aquellas clases que no fueron probadas de manera directa con un test "
            +
            "es porque alguna otra clase de su mismo 'tipo' "
            +
            "(PlayerCharacter, Weapon u otro) ya fue probada, "
            +
            "y ya que tiene la mismas funcionalidades, por extencion tambien funciona");
  }
}
