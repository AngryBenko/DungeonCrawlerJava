/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author Minmin
 */
public enum Treasure {
 
    d("Diamond"),
    g("Gold bar"),
    s("Sliver bar"),
    NONE("None");

    private Treasure(String name) {
        this.name = name;
    }   
   
    String name;
  
}

