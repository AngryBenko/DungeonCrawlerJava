package Entities;

import javax.swing.*;

public class HellishBoss extends Entity {
    private static final String name = "boss_hellish";
    private static final int maxHealth = 15;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 5;
    private static final int defense = 2;

    public HellishBoss() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, defense, new JLabel(new ImageIcon(HellishBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }}
