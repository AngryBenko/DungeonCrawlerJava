package Entities;

import javax.swing.*;

public class Orc extends Entity {
    private static final String name = "orc";
    private static final int maxHealth = 8;
    private static final int lightAttack = 3;
    private static final int heavyAttack = 7;
    private static final int speed = 5;
    private static final int numOfAttacks = 2;

    public Orc() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Orc.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
