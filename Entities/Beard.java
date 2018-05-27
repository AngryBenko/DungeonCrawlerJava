package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Beard extends Entity {
    private static final String name = "beard";
    private static final int maxHealth = 55;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 16;
    private static final int speed = 5;
    private static final int numOfAttacks = 3;

    public Beard() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Beard.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
        super.setIsPlayer(true);
    }
}