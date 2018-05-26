package Entities;

import javax.swing.*;

public class EleEarth extends Entity {
    private static final String name = "ele_earth";
    private static final int maxHealth = 22;
    private static final int lightAttack = 5;
    private static final int heavyAttack = 11;
    private static final int speed = 4;
    private static final int numOfAttacks = 2;

    public EleEarth() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleEarth.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
