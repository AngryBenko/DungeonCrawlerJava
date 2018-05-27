package Entities;

import javax.swing.*;

public class Skeleton extends Entity {
    private static final String name = "skeleton";
    private static final int maxHealth = 15;
    private static final int lightAttack = 3;
    private static final int heavyAttack = 5;
    private static final int speed = 0;
    private static final int numOfAttacks = 2;

    public Skeleton() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Skeleton.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
