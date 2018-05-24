package Entities;

import javax.swing.*;

public class Ent extends Entity {
    private static final String name = "Ent";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public Ent() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Ent.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public Ent(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
