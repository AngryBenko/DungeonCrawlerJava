package Entities;

import javax.swing.*;

public class Bat extends Entity {
    private static final String name = "Bat";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public Bat() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Bat.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public Bat(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
