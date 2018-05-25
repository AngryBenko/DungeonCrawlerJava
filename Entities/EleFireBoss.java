package Entities;

import javax.swing.*;

public class EleFireBoss extends Entity {
    private static final String name = "boss_ele_fire";
    private static final int maxHealth = 105;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 5;
    private static final int numOfAttacks = 2;

    public EleFireBoss() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleFireBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }
}
