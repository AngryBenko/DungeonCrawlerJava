package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class OldMan extends Entity {
    private static final String name = "oldman";
    private static final int maxHealth = 10;
    private static final int attackDamage = 2;
    private static final int defense = 2;

    public OldMan() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(OldMan.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
