package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class FireMage extends Entity {
    private static final String name = "mage_fire";
    private static final int maxHealth = 43;
    private static final int lightAttack = 9;
    private static final int heavyAttack = 16;
    private static final int speed = 7;
    private static final int numOfAttacks = 3;

    public FireMage() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(FireMage.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
        super.setIsPlayer(true);
    }
}
