package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Maniac1 extends Entity {
    private static final String name = "maniac1";
    private static final int maxHealth = 46;
    private static final int lightAttack = 11;
    private static final int heavyAttack = 20;
    private static final int speed = 9;
    private static final int numOfAttacks = 2;

    public Maniac1() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Maniac1.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
