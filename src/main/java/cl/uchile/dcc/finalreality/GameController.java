package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * Principal control center for the aplication.
 */
public class GameController {

  private static GameController gc;

  /**
   * Sets up an instace of GameController to use.
   */
  public GameController controller() {
    if (gc == null) {
      gc = new GameController();
    }
    return gc;
  }

  private final BlockingQueue<GameCharacter>
          turnsQueue = new LinkedBlockingQueue<GameCharacter>();
  protected List<PlayerCharacter> playerCharacters = new ArrayList<PlayerCharacter>();
  protected List<Enemy> enemyCharacters = new ArrayList<Enemy>();
  protected List<Weapon> weaponList = new ArrayList<Weapon>();


  /**
   * Creates and adds an Engineer to the PlayerCharacters List.
   */
  public void createPlayerEngineer(final @NotNull String name, final int maxHp, final int defense)
          throws InvalidStatValueException {
    playerCharacters.add(new Engineer(name, maxHp, defense, turnsQueue));
  }

  /**
   * Creates and adds a Black Mage to the PlayerCharacters List.
   */
  public void createPlayerBlackMage(final @NotNull String name, final int maxHp, final int defense,
                                    final int maxMp) throws InvalidStatValueException {
    playerCharacters.add(new BlackMage(name, maxHp, defense, maxMp, turnsQueue));
  }

  /**
   * Creates and adds a White Mage to the PlayerCharacters List.
   */
  public void createPlayerWhiteMage(final @NotNull String name, final int maxHp, final int defense,
                                    final int maxMp) throws InvalidStatValueException {
    playerCharacters.add(new WhiteMage(name, maxHp, defense, maxMp, turnsQueue));
  }

  /**
   * Creates and adds a Knight to the PlayerCharacters List.
   */
  public void createPlayerKnight(final @NotNull String name, final int maxHp, final int defense)
          throws InvalidStatValueException {
    playerCharacters.add(new Knight(name, maxHp, defense, turnsQueue));
  }

  /**
   * Creates and adds a Thief to the PlayerCharacters List.
   */
  public void createPlayerThief(final @NotNull String name, final int maxHp, final int defense)
          throws InvalidStatValueException {
    playerCharacters.add(new Thief(name, maxHp, defense, turnsQueue));
  }

  /**
   * Creates and adds an Axe to Weapons List.
   */
  public void createAxe(String name, int damage, int weight) {
    weaponList.add(new Axe(name, damage, weight));
  }

  /**
   * Creates and adds a Bow to Weapons List.
   */
  public void createBow(String name, int damage, int weight) {
    weaponList.add(new Bow(name, damage, weight));
  }

  /**
   * Creates and adds a Knife to Weapons List.
   */
  public void createKnife(String name, int damage, int weight) {
    weaponList.add(new Knife(name, damage, weight));
  }

  /**
   * Creates and adds a Staff to Weapons List.
   */
  public void createStaff(String name, int damage, int weight) {
    weaponList.add(new Staff(name, damage, weight));
  }

  /**
   * Creates and adds a Sword to Weapons List.
   */
  public void createSword(String name, int damage, int weight) {
    weaponList.add(new Sword(name, damage, weight));
  }

  /**
   * Equips a Weapon to a Character.
   */
  public void equipWeaponToCharacter(PlayerCharacter pc, Weapon w) {
    pc.equip(w);
  }

  /**
   * Creates and adds an Enemy to Weapons EnemyCharacters.
   */
  public void createEnemy(@NotNull final String name, final int weight, int maxHp, int attack,
                          int defense) throws InvalidStatValueException {
    enemyCharacters.add(new Enemy(name, weight, maxHp, attack, defense, turnsQueue));
  }

  /**
   * An attacker character attacks a target character.
   */
  public void attackTarget(GameCharacter attacker, GameCharacter target)
          throws InvalidStatValueException {
    attacker.attack(target);
  }

  /**
   * A white mage uses a poison spell on an Enemy.
   */
  public void useSpellPoison(WhiteMage mage, Enemy target)
          throws InvalidStatValueException {
    mage.poisonSpell(target);
  }

  /**
   * A white mage uses a paralysis spell on an Enemy.
   */
  public void useSpellParalysis(WhiteMage mage, Enemy target)
          throws InvalidStatValueException {
    mage.paralysisSpell(target);
  }

  /**
   * A white mage uses a healing spell on an PlayerCharacter.
   */
  public void useSpellHeal(WhiteMage mage, PlayerCharacter target)
          throws InvalidStatValueException {
    mage.healSpell(target);
  }

  /**
   * A black mage uses a thunder spell on an Enemy.
   */
  public void useSpellThunder(BlackMage mage, Enemy target)
          throws InvalidStatValueException {
    mage.thunderSpell(target);
  }

  /**
   * A black mage uses a fire spell on an Enemy.
   */
  public void useSpellFire(BlackMage mage, Enemy target)
          throws InvalidStatValueException {
    mage.fireSpell(target);
  }

  /**
   * Removes a Player character from the PlayerCharacters list.
   */
  public void removePlauerCharacter(int i) {
    playerCharacters.remove(i);
  }

  /**
   * Removes an Enemy character from the EnemyCharacters list.
   */
  public void removeEnemy(int i) {
    enemyCharacters.remove(i);
  }

  /**
   * Removes a Weapon from the Weapons list.
   */
  public void removeWeapons(int i) {
    weaponList.remove(i);
  }

  /**
   * Makes the GameCharacter use waitTurn.
   */
  public void waitTurn(GameCharacter gc) {
    gc.waitTurn();
  }

  /**
   * When the Player wins, return 1.
   */
  public int onPlayerWin() {
    return 1;
  }

  /**
   * When the Enemies win, return 0.
   */
  public int onEnemyWin() {
    return 0;
  }

  /**
   * Resets the controller.
   */
  public void resetCotroller() {
    gc = new GameController();
  }
}
