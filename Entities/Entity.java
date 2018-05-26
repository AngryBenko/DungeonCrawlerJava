package Entities;

import java.util.ArrayList;
import javax.swing.*;

// TODO display health underneath entity, remove that function from dungeon
public class Entity {
    protected String name;
    protected boolean isTurn;
    protected boolean isAlive = true;
    protected int maxHealth;
    protected int health;
    protected int numOfAttacks;
    protected int lightAttack;
    protected int heavyAttack;
    protected int defense;
    protected int speed;
    protected JLabel label; // add border based on turn order
    protected JTextArea healthText;

    public Entity(String name, int health, int lAtk, int hAtk, int spd, int nAtks, JLabel label) {
        this.isTurn = false;
        this.name = name;
        this.numOfAttacks = nAtks;
        this.health = health;
        this.maxHealth = health;
        this.lightAttack = lAtk;
        this.heavyAttack = hAtk;
        this.speed = spd;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0) {
            this.health = 0;
        } else if(health > maxHealth) {
            this.health = maxHealth;
        } else {
            this.health = health;
        }
    }

    public int getNAtks() { return this.numOfAttacks; }

    public int getLightAttack() { return this.lightAttack; }

    public int getHeavyAttack() { return this.heavyAttack; }

    public int getSpeed() { return this.speed; }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setBounds(int x, int y, int w, int h) {
        label.setBounds(x, y, w, h);
    }

    public String healthString() {
        return (health + "/" + maxHealth);
    }

    public boolean isDead() {
        return (health <= 0);
    }

    public void setTurn(boolean value) { isTurn = value; }
}
