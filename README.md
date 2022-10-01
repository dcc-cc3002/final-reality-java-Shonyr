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