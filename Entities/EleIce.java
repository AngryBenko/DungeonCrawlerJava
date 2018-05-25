package Entities;

import javax.swing.*;

public class EleIce extends Entity {
    private static final String name = "ele_ice";
    private static final int maxHealth = 15;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 15;
    private static final int numOfAttacks = 2;

    public EleIce() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleIce.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
