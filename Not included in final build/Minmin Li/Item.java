/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import static item.ItemType.Potion;

/**
 *
 * @author Minmin
 */

  public class Item {
   
	public String wname;   
	public int force;       
	public int killRange;  
        public int weight;
        public int value;
        PotionType potionType;
        Treasure treasure;
        ItemType itemType;
        
    public Item(String wname, int force, int killRange, int weight, int value, PotionType potionType, ItemType itemType) {
        this.wname = wname;
        this.force = force;
        this.killRange = killRange;
        this.weight = weight;
        this.value = value;
        this.potionType = potionType;
        this.itemType = itemType;
    }

       public Item(String wname,int force,int killRange,int weight,int value){
       this(wname,force,killRange,weight,value,PotionType.NONE,ItemType.Weapon);
   }  
        public Item(String wname,int value,PotionType potionType){
        this(wname,0,0,0,value,potionType,ItemType.Potion);    
        }
        public Item(String wname,int value,Treasure treasure){
        this(wname,0,0,0,value,PotionType.NONE,ItemType.Treasure);       
        }

    private Item(String wname, int i, int i0, int i1, int value, Treasure treasure, ItemType itemType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public PotionType potionType() {
            
        return potionType;
    }




    
}
