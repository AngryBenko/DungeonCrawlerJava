package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Beard extends Entity {
    private static final String name = "beard";
    private static final int maxHealth = 10;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 7;
    private static final int numOfAttacks = 2;

    public Beard() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Beard.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}