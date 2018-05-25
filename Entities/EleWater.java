package Entities;

import javax.swing.*;

public class EleWater extends Entity {
    private static final String name = "ele_water";
    private static final int maxHealth = 15;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 17;
    private static final int numOfAttacks = 2;

    public EleWater() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(EleWater.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }
}
