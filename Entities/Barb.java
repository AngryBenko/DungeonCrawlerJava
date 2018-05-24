package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Barb extends Entity {
    private static final String name = "barbarian1";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public Barb() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Barb.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
