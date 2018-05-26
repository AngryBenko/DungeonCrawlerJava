package Entities;

import java.util.ArrayList;
import javax.swing.*;

public class Monster {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int attackDamage;
    protected int defense;
    protected ArrayList<Loot> drops;
    protected JLabel label;
    protected JTextArea healthText;

    public Monster(String name, int health, int atk, int def, JLabel label) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackDamage = atk;
        this.defense = def;
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
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public ArrayList<Loot> getDrops() {
        return drops;
    }

    public void setDrops(ArrayList<Loot> drops) {
        this.drops = drops;
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
        return health + "/" + maxHealth;
    }
}
