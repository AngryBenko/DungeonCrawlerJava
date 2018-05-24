package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class FireMage extends Entity {
    private static final String name = "mage_fire";
    private static final int maxHealth = 10;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 5;
    private static final int defense = 2;

    public FireMage() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, defense, new JLabel(new ImageIcon(FireMage.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
