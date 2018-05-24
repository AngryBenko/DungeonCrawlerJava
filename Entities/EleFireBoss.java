package Entities;

import javax.swing.*;

public class EleFireBoss extends Entity {
    private static final String name = "boss_ele_fire";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public EleFireBoss() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(EleFireBoss.class.getClassLoader().getResource("res/entity/enemies/boss/" + name + ".png"))));
    }

    public EleFireBoss(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
