package Entities;

import javax.swing.*;

public class EleWater extends Entity {
    private static final String name = "ele_water";
    private static final int maxHealth = 14;
    private static final int lightAttack = 5;
    private static final int heavyAttack = 9;
    private static final int speed = 6;
    private static final int numOfAttacks = 2;

    public EleWater() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleWater.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
