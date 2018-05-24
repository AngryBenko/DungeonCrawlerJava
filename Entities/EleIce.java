package Entities;

import javax.swing.*;

public class EleIce extends Entity {
    private static final String name = "ele_ice";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public EleIce() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(EleIce.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public EleIce(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
