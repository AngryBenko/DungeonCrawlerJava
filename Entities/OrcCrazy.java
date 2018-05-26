package Entities;

import javax.swing.*;

public class OrcCrazy extends Entity {
    private static final String name = "orc_crazy";
    private static final int maxHealth = 51;
    private static final int lightAttack = 4;
    private static final int heavyAttack = 8;
    private static final int speed = 9;
    private static final int numOfAttacks = 2;

    public OrcCrazy() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(OrcCrazy.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
