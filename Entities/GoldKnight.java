package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class GoldKnight extends Entity {
    private static final String name = "knight_gold";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public GoldKnight() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(GoldKnight.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
