package Entities;

import javax.swing.*;

public class EleEarth extends Entity {
    private static final String name = "ele_earth";
    private static final int maxHealth = 15;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 6;
    private static final int defense = 2;

    public EleEarth() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, defense, new JLabel(new ImageIcon(EleEarth.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
