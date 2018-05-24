package Entities;

import javax.swing.*;

public class OrcCrazy extends Entity {
    private static final String name = "orc_crazy";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public OrcCrazy() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(OrcCrazy.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public OrcCrazy(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
