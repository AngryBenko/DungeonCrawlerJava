package Entities;

import javax.swing.*;

public class HellishBoss extends Entity {
    private static final String name = "boss_hellish";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public HellishBoss() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(HellishBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }

    public HellishBoss(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
