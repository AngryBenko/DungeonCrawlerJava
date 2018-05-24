package Entities;

import javax.swing.*;

public class Zombie extends Entity {
    private static final String name = "Zombie";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public Zombie() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Zombie.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public Zombie(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
