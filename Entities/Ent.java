package Entities;

import javax.swing.*;

public class Ent extends Entity {
    private static final String name = "Ent";
    private static final int maxHealth = 10;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 5;
    private static final int numOfAttacks = 2;

    public Ent() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Ent.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
