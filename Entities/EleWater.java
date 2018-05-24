package Entities;

import javax.swing.*;

public class EleWater extends Entity {
    private static final String name = "ele_water";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public EleWater() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(EleWater.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public EleWater(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
