package Entities;

import javax.swing.*;

public class EleFire extends Entity {
    private static final String name = "ele_fire";
    private static final int maxHealth = 21;
    private static final int lightAttack = 3;
    private static final int heavyAttack = 7;
    private static final int speed = 3;
    private static final int numOfAttacks = 2;

    public EleFire() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleFire.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
