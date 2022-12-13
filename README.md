Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

Implementation for T1

To run the program you only need to run the Main class inside the finalreality folder. Inside Main there are all the tests used to check if all the methods of all the implemented classes are working as intended.

The only assumption made when making this implementation is that Staff is going to be a weapon 'unique' in functionality (Not yet implemented for T1), because if there is going to be other weapons that work in the same way, is better to add an extra Abstract Class in where we can implement all the shared functiontabilities and extend Staff and any other weapon from that class

All classes are implemented using inheritance. Making an AbstractCharacter class that has all the basic information of the characters from where we can extend the Enemy class and the PlayerCharacter class and then extend from PlayerCharacter all the character classes that the player can use and the AbstractMagical class, in where we can add the shared methods and atributes that involve MP, an attribute only used for BlackMages and WhiteMages, classes that extend the AbstractMagical class
For weapons there is the AbstractWeapon class, this class has all the basic information regarding the atributes of the different types of weapons, from which all other weapon classes extend from (Sword, Axe, ... etc.)

The changes realized to the original implementation handed to us are:
    - The creation of the abstract class AbstractMage and its interface Mage. this class was given the attributes and methods shared between the originals BlackMage and WhiteMage, making them subclasses of this new abstract
    - The creation AbstractWeapon, an abstract class that has all the basic information of the weapons implemented in the game. An interface for AbstractWeapon was also created, called Weapon
    - The creation of classes for each weapon type enumerated in WeaponType, making them subclasses of AbstractWeapon

---

Implementation for T2

The program no longer has a Main class, for checking the tests and the coverage of these you need to run the 'TEST AND COVERAGE CHECK' thats on your IDE (IntelliJ in my case) 
Other things that are implemented this time around are the checks for when the characters equip a weapon, if they can't use the weapon that they are trying to equip, the program will do nothing, if the character can, it will be equipped. This was implemented using the double dispatch design pattern, the character sending a message to the weapon that they want to equip, the weapon knows who (their class) send the message and executes the corresponding method, if it does nothing, then the character is not able to use that kind of weapon, if it is equipped, then the character is able to use that weapon

In summary, the changes realized from T1 to T2 are:
    - Deletion of the Main class that had all the Tests using prints and implementation of real java tests
    - Addition restrictions at the time of equipping a weapon depending on the type of weapon and the class of the character

---

Implementation for T3

The implementation is not complete, it has all the elements, classes and methods needed to work, but the game in itself has not been implemented, it lacks the turn-based combat system that needs to be playable.

The program implements attacks and spells and a basic controller that can handle everything that a player would want to do
The implementation of the new features used a variety of different design patterns, like double dispatch for performing attacks and spells and receiving them, observer for the abnormal statuses like poison, and paralysis.
The central controller is implemented using the design pattern of singleton
The implementation of the controller simplifies the creation of enemies, characters and weapons, also simplifing other actions, like using spells and equipping weapons. It also has other methods, like being able to reselt the whole controller.
