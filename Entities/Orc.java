package Entities;

import javax.swing.*;

public class Orc extends Entity {
    private static final String name = "Orc";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public Orc() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Orc.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public Orc(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
