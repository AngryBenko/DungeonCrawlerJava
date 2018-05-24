package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Beard extends Entity {
    private static final String name = "beard";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public Beard() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(Beard.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}