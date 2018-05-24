package Entities;

import javax.swing.*;

public class OrcBoss extends Entity {
    private static final String name = "boss_orc";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public OrcBoss() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(OrcBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }

    public OrcBoss(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
