package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Knight1 extends Entity {
    private static final String name = "knight1";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public Knight1() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Knight1.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
