package Entities;

import javax.swing.*;

public class Skeleton extends Entity {
    private static final String name = "Skeleton";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public Skeleton() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Skeleton.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public Skeleton(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
