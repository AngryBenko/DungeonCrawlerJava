package item;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Minmin
 */
public class Shop{

    public Shop() {
    }


    public Item getPotion(PotionType potionType) {
        return potions.get(potionType);
    }

    public void purchase(Item itemToPurchase) {
        Items.remove(itemToPurchase);
    }

    private ArrayList<Item> Items = new ArrayList<Item>();
    private Map<PotionType, Item> potions = new HashMap<PotionType, Item>();
    private Map<Treasure, Item> treasure = new HashMap<Treasure, Item>();
   

    private void populateShop() {
        Items.add(new Item("Lightning Sword", 1000, 300, 100, 500));
        Items.add(new Item("Steel Sword", 700, 200 , 100, 400));
        Items.add(new Item("Bloodrage Whip", 400, 500, 80, 500));
        Items.add(new Item("Hero Axe", 1000, 400, 300, 600));
        Items.add(new Item("Lunge", 500, 1000, 100, 800));
        Items.add(new Item("Mirage Bow", 500,1500, 200, 600));
        Items.add(new Item("Needle Spear", 400, 300, 100, 300));
        Items.add(new Item("Nightmare Bomb", 5000, 800, 50, 1000));
        Items.add(new Item("Nirvana Hammer", 300, 400, 600, 300));
        Items.add(new Item("Scar Rifle", 1000, 2000, 50, 600));
        Items.add(new Item("Thunder Claw", 600, 100, 50, 200));
        Items.add(new Item("Vengeance shotgun", 1000, 1000, 30, 1000));


        potions.put(PotionType.Full, new Item("FullyRecover", 1000, PotionType.Full));
        potions.put(PotionType.Most, new Item("MostlyRecover ", 800, PotionType.Most));
        potions.put(PotionType.Half, new Item("HalfRecover", 500, PotionType.Half));
        potions.put(PotionType.Quarter, new Item("QuarterRecover", 250, PotionType.Quarter));
        
        treasure.put(Treasure.d, new Item("Diamond", 1200, Treasure.d));
        treasure.put(Treasure.g, new Item("Gold bar", 800, Treasure.g));
        treasure.put(Treasure.s, new Item("Silver bar", 400, Treasure.s));
    }
  
}
