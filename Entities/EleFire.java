package Entities;

        import javax.swing.*;

public class EleFire extends Entity {
    private static final String name = "ele_fire";
    private static final int maxHealth = 15;
    private static final int attackDamage = 3;
    private static final int defense = 2;

    public EleFire() {
        super(name, maxHealth, attackDamage, defense, new JLabel(new ImageIcon(EleFire.class.getClassLoader().getResource("res/entity/enemies/" + name + ".gif"))));
    }

    public EleFire(String name, int maxHealth, JLabel label) {
        super(name, maxHealth, attackDamage, defense, label);
    }
}
