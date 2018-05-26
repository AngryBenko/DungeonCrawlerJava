package Entities;

import javax.swing.*;

public class EleIce extends Entity {
    private static final String name = "ele_ice";
    private static final int maxHealth = 19;
    private static final int lightAttack = 3;
    private static final int heavyAttack = 5;
    private static final int speed = 0;
    private static final int numOfAttacks = 2;

    public EleIce() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleIce.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
