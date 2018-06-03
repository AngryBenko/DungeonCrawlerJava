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
 public enum PotionType {
    Full(100,"FullyRecover"),
    Most(80,"MostlyRecover"),
    Half(50,"HalfRecover"),
    Quarter(25,"QuarterRecover"),
    NONE(0,"None");

    PotionType(int percentage, String name) {
        this.percentage = percentage;
        this.name = name;
    }
   
    String name;
    int percentage;
}

