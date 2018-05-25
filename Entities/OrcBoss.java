package Entities;

import javax.swing.*;

public class OrcBoss extends Entity {
    private static final String name = "boss_orc";
    private static final int maxHealth = 100;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 5;
    private static final int numOfAttacks = 2;

    public OrcBoss() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(OrcBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }
}
