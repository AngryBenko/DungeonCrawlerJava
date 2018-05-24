package Entities;

import javax.swing.*;

public class Bat extends Entity {
    private static final String name = "Bat";
    private static final int maxHealth = 10;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 20;
    private static final int defense = 2;

    public Bat() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, defense, new JLabel(new ImageIcon(Bat.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
