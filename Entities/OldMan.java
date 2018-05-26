package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class OldMan extends Entity {
    private static final String name = "oldman";
    private static final int maxHealth = 35;
    private static final int lightAttack = 7;
    private static final int heavyAttack = 13;
    private static final int speed = 8;
    private static final int numOfAttacks = 3;

    public OldMan() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(OldMan.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
