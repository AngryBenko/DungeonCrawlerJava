package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Barb extends Entity {
    private static final String name = "barbarian1";
    private static final int maxHealth = 20;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 12; 
    private static final int speed = 5;
    private static final int defense = 5;

    public Barb() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, defense, new JLabel(new ImageIcon(Barb.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
