package Entities;

import javax.swing.*;

public class Bat extends Entity {
    private static final String name = "bat";
    private static final int maxHealth = 12;
    private static final int lightAttack = 2;
    private static final int heavyAttack = 4;
    private static final int speed = 10;
    private static final int numOfAttacks = 2;

    public Bat() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Bat.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
