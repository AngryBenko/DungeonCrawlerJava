package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Barb2 extends Entity {
    private static final String name = "barbarian2";
    private static final int maxHealth = 25;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12;
    private static final int speed = 8;
    private static final int numOfAttacks = 2;

    public Barb2() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Barb2.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
