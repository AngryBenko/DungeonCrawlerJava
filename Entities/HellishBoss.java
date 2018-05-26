package Entities;

import javax.swing.*;

public class HellishBoss extends Entity {
    private static final String name = "boss_hellish";
    private static final int maxHealth = 77;
    private static final int lightAttack = 7;
    private static final int heavyAttack = 13;
    private static final int speed = 0;
    private static final int numOfAttacks = 2;

    public HellishBoss() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(HellishBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }}
