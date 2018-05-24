package Entities;

import javax.swing.*;

public class EleEarth extends Entity {
    private static final String name = "ele_earth";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public EleEarth() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(EleEarth.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public EleEarth(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
