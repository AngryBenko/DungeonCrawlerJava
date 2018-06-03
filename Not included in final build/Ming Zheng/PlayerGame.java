//
//  PlayerGame.java
//  
//
//  Created by Ming Zheng on 5/17/18.
//



import java.util.*;
import java.lang.*;
import java.io.*;



// Player protoype, everyone has this
public class Player {
    
    int shield, health, armor;
    int dollar, gold;
    
    int getHealth() { return health; }
    int getShield() { return shield; }
    int getArmor() { return armor; }    //   Armor: 0: unattacked, 1: Head, 2: Torso, 3: Leg
    int getDollar()  { return dollar;}
    int getGold()  { return gold;}
    
}

public class A_Player extends  Player {
    
    String attacktype;
    Inventory inventory;
    int atkCount;
    int life;
    int damage;
    double attackspeed;
    boolean isOnGame, isOnTurn;   // isOnGame: you are in the game,  isOnTurn: your turn.
    int level, positionX, positionY;
    
    
    int dollar, gold;
    A_Player() {                              //Initial Constructor for a major player.
        attacktype = "Psi Blades";
        shield = 100;
        health = 100;
        damage = 8 * 2;
        attackspeed = 1.2;
        dollar = 200;
        gold = 0;
    }
    double getAttackSpeed()  {return attackspeed;}
    int getLife() {return life;}
    boolean getIsOnGame() {return isOnGame;}
    boolean getIsOnTurn()  {return isOnTurn;}
    int getLevel()  {return level;}
    int getPositionX() {return positionX;}
    int getPositionY()  {return positionY;}
    boolean  getHasInventory(int ivt) {return this.inventory.inven[ivt].hasIvt;}
    void setAttackType(String atktype) {attacktype=atktype; atkCount++;}
    void setLife() { life--;}
    void setIsOnGame() {  isOnGame=!isOnGame;}
    void setIsOnTurn()  { isOnTurn=!isOnTurn;}
    void setLevel()  { level++;}
    void setPositionX(int moveX) {positionX+=moveX;}
    void setPositionY(int moveY)  {positionY+=moveY;}
    void setHasInventory(int ivt) { this.inventory.inven[ivt].hasIvt=true;}
    void setDamage(int dmg)  { damage=dmg;}
    
}

public class W_Player extends Player {
    
    String attacktype;
    Inventory inventory;
    int atkCount;
    int life;
    int damage;
    double attackspeed;
    
    boolean isOnGame, isOnTurn;   // isOnGame: you are in the game,  isOnTurn: your turn.
    int level, positionX, positionY;
    
    
    int dollar, gold;
    W_Player() {
        attacktype = "Psi Blades";
        shield = 50;
        health = 100;
        damage = 8 * 2;
        attackspeed = 1.2;
        dollar = 100;
        gold = 0;
    }
    double getAttackSpeed()  {return attackspeed;}
    int getLife() {return life;}
    boolean getIsOnGame() {return isOnGame;}
    boolean getIsOnTurn()  {return isOnTurn;}
    int getLevel()  {return level;}
    int getPositionX() {return positionX;}
    int getPositionY()  {return positionY;}
    boolean  getHasInventory(char ivt) {return this.inventory.inven[ivt].hasIvt;}
    void setAttackType(String atktype) {attacktype=atktype; atkCount++;}
    void setLife() {life--;}
    void setIsOnGame() { isOnGame=!isOnGame;}
    void setIsOnTurn()  { isOnTurn=!isOnTurn;}
    void setLevel()  {  ++level;}
    void setPositionX(int moveX) { positionX+=moveX;}
    void setPositionY(int moveY)  { positionY+=moveY;}
    void setHasInventory(int ivt) { this.inventory.inven[ivt].hasIvt=true;}
    void setDamage(int dmg)  { damage=dmg;}
    
}

// Enemy
public class Dungeon {
    
    int a_shield, health, armor;
    int dollar, gold;
    
    int getHealth() { return health; }
    int getShield() { return a_shield; }
    int getArmor() { return armor; }
    int getDollar()  { return dollar;}
    int getGold()  { return gold;}
    
}

public class A_Dungeon extends  Dungeon {
    
    String attacktype;
    Inventory inventory;
    int atkCount;
    int damage;
    double attackspeed;
    int positionX, positionY;
    boolean isOnGame, isOnTurn;
    
    char atkType[]= new char[128];
    A_Dungeon() {
        attacktype = "Psi Blades";
        a_shield = 50;
        health = 100;
        damage = 8 * 2;
        attackspeed = 1.2;
        dollar = 100;
        gold = 0;
    }
    double getAttackSpeed()  {return attackspeed;}
    
    //  boolean getIsOnGame() {return isOnGame;}
    //  boolean getIsOnTurn()  {return isOnTurn;}
    //  int getLevel()  {return level;}
    int getPositionX() {return positionX;}
    int getPositionY()  {return positionY;}
    boolean  getHasInventory(char ivt) {return this.inventory.inven[ivt].hasIvt;}
    void setAttackType(String atktype) {attacktype=atktype; atkCount++;}
    //  void setLife() {life--;}
    void setIsOnGame() {isOnGame=!isOnGame;}
    void getIsOnTurn()  {isOnTurn=!isOnTurn;}
    //   void setLevel()  {level++;}
    void setPositionX(int moveX) {positionX+=moveX;}
    void setPositionY(int moveY)  {positionY+=moveY;}
    void setHasInventory(int ivt) { this.inventory.inven[ivt].hasIvt=true;}
    void setDamage(int dmg)  { damage=dmg;}
}

public class B_Dungeon extends Dungeon {
    
    String attacktype;
    Inventory inventory;
    int atkCount;
    int ivtCount;
    int damage;
    double attackspeed;
    int positionX, positionY;
    boolean isOnGame, isOnTurn;
    
    char atkType[]= new char[128];
    B_Dungeon() {
        attacktype = "Ranged";
        a_shield = 80;
        health = 80;
        damage = 10;
        attackspeed = 1.44;
        
    }
    double getAttackSpeed()  {return attackspeed;}
    
    //  boolean getIsOnGame() {return isOnGame;}
    //   boolean getIsOnTurn()  {return isOnTurn;}
    //  int getLevel()  {return level;}
    int getPositionX() {return positionX;}
    int getPositionY()  {return positionY;}
    boolean  getHasInventory(char ivt) {return this.inventory.inven[ivt].hasIvt;}
    void setAttackType(String atktype) {attacktype=atktype; atkCount++;}
    
    //    void setIsOnGame() {isOnGasme=!isOnGame;}
    //   void getIsOnTurn()  {isOnTurn=!isOnTurn;}
    //   void setLevel()  {level++;}
    void setPositionX(int moveX) {positionX+=moveX;}
    void setPositionY(int moveY)  {positionY+=moveY;}
    void setHasInventory(int ivt) { this.inventory.inven[ivt].hasIvt=true;}
    void setDamage(int dmg)  { damage=dmg;}
}

// List of all attacks
class Attack {
    Attack atk[]=new Attack[128];
    String attacktype;
    int damage;
    double attackspeed;
    
    Attack(String aName, int dmg, int aspeed) {
        attacktype = aName;
        damage = dmg;
        attackspeed = aspeed;
    }
    int getDamage()  {return damage;}
    double getAttackSpeed()  {return attackspeed;}
    String getAttackType()  {return attacktype;}
    
}  //initilization of Attack and assignment of varaibles to the array.

class Inventory{
    Inventory inven[]=new Inventory[128];
    boolean hasIvt;
    String inventorytype;
    
    //others;
}
