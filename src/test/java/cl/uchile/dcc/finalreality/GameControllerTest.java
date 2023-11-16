package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight;
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    GameController x;
    GameController y;
    BlockingQueue<GameCharacter> turnsQueue;

    @BeforeEach
    void setUp() {
        x = new GameController().controller();
        y = new GameController().controller();
        turnsQueue =  new LinkedBlockingQueue<GameCharacter>();
    }

    @Test
    void controller() {
        assertEquals(x, y);
    }

    @Test
    void createPlayerEngineer() throws InvalidStatValueException {
        x.createPlayerEngineer("Engineer", 1, 1);
        assertEquals(x.playerCharacters.get(0), new Engineer("Engineer", 1, 1, turnsQueue));
    }

    @Test
    void createPlayerBlackMage() throws InvalidStatValueException {
        x.createPlayerBlackMage("BlackMage",1 ,1, 1);
        assertEquals(x.playerCharacters.get(0), new BlackMage("BlackMage", 1, 1, 1, turnsQueue));
    }

    @Test
    void createPlayerWhiteMage() throws InvalidStatValueException {
        x.createPlayerWhiteMage("WhiteMage", 1, 1, 1);
        assertEquals(x.playerCharacters.get(0), new WhiteMage("WhiteMage", 1, 1, 1, turnsQueue));
    }

    @Test
    void createPlayerKnight() throws InvalidStatValueException {
        x.createPlayerKnight("Knight",1 , 1);
        assertEquals(x.playerCharacters.get(0), new Knight("Knight", 1, 1, turnsQueue));
    }

    @Test
    void createPlayerThief() throws InvalidStatValueException {
        x.createPlayerThief("Thief", 1, 1);
        assertEquals(x.playerCharacters.get(0), new Thief("Thief", 1, 1, turnsQueue));
    }

    @Test
    void createAxe() {
        x.createAxe("Axe", 1, 1);
        assertEquals(x.weaponList.get(0), new Axe("Axe", 1, 1));
    }

    @Test
    void createBow() {
        x.createBow("Bow", 1, 1);
        assertEquals(x.weaponList.get(0), new Bow("Bow", 1, 1));
    }


    @Test
    void createKnife() {
        x.createKnife("Knife", 1, 1);
        assertEquals(x.weaponList.get(0), new Knife("Knife", 1, 1));
    }

    @Test
    void createStaff() {
        x.createStaff("Staff", 1, 1);
        assertEquals(x.weaponList.get(0), new Staff("Staff", 1, 1));
    }

    @Test
    void createSword() {
        x.createSword("Sword", 1, 1);
        assertEquals(x.weaponList.get(0), new Sword("Sword", 1, 1));
    }

    @Test
    void equipWeaponToCharacter() throws InvalidStatValueException {
        x.createPlayerKnight("Knight",1 , 1);
        x.createSword("Sword", 1, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        assertEquals(x.playerCharacters.get(0).getEquippedWeapon(), x.weaponList.get(0));
    }

    @Test
    void createEnemy() throws InvalidStatValueException {
        x.createEnemy("Enemy", 1, 1, 1, 1);
        assertEquals(x.enemyCharacters.get(0), new Enemy("Enemy", 1, 1, 1, 1, turnsQueue));
    }

    @Test
    void attackTarget() throws InvalidStatValueException {
        x.createPlayerKnight("Knight",1 , 1);
        x.createSword("Sword", 2, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        x.createEnemy("Enemy", 1, 3, 1, 1);
        x.attackTarget(x.playerCharacters.get(0), x.enemyCharacters.get(0));
        assertEquals(x.enemyCharacters.get(0).getCurrentHp(), 2);
    }

    @Test
    void useSpellPoison() throws InvalidStatValueException {
        x.createPlayerWhiteMage("WhiteMage", 1, 1, 50);
        x.createStaff("Staff", 15, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        x.createEnemy("Enemy", 1, 500, 1, 1);
        x.useSpellPoison((WhiteMage) x.playerCharacters.get(0), x.enemyCharacters.get(0));
        assertNotNull(x.enemyCharacters.get(0).adverseEffects.get(0));
    }

    @Test
    void useSpellParalysis() throws InvalidStatValueException {
        x.createPlayerWhiteMage("WhiteMage", 1, 1, 50);
        x.createStaff("Staff", 15, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        x.createEnemy("Enemy", 1, 500, 1, 1);
        x.useSpellParalysis((WhiteMage) x.playerCharacters.get(0), x.enemyCharacters.get(0));
        assertNotNull(x.enemyCharacters.get(0).adverseEffects.get(0));
    }

    @Test
    void useSpellHeal() throws InvalidStatValueException {
        x.createPlayerWhiteMage("WhiteMage", 1, 1, 50);
        x.createStaff("Staff", 1, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        x.createPlayerKnight("Knight",10, 1);
        x.playerCharacters.get(1).setCurrentHp(7);
        x.useSpellHeal((WhiteMage) x.playerCharacters.get(0), x.playerCharacters.get(1));
        assertEquals(x.playerCharacters.get(1).getCurrentHp(), 10);
    }

    @Test
    void useSpellThunder() throws InvalidStatValueException {
        x.createPlayerBlackMage("BlackMage", 1, 1, 50);
        x.createStaff("Staff", 15, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        x.createEnemy("Enemy", 1, 500, 1, 1);
        x.useSpellThunder((BlackMage) x.playerCharacters.get(0), x.enemyCharacters.get(0));
        assertEquals(x.enemyCharacters.get(0).getCurrentHp(), 485);
    }

    @Test
    void useSpellFire() throws InvalidStatValueException {
        x.createPlayerBlackMage("BlackMage", 1, 1, 50);
        x.createStaff("Staff", 15, 1);
        x.equipWeaponToCharacter(x.playerCharacters.get(0), x.weaponList.get(0));
        x.createEnemy("Enemy", 1, 500, 1, 1);
        x.useSpellFire((BlackMage) x.playerCharacters.get(0), x.enemyCharacters.get(0));
        assertEquals(x.enemyCharacters.get(0).getCurrentHp(), 485);
    }

    @Test
    void waitTurn() {
    }

    @Test
    void onPlayerWin() {
        assertEquals(x.onPlayerWin(), 1);
    }

    @Test
    void onEnemyWin() {
        assertEquals(x.onEnemyWin(), 0);
    }

    @AfterEach
    public void teardown(){
        x.resetCotroller();
    }
}