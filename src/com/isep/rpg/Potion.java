package com.isep.rpg;

public class Potion extends Consumable
{
    // Attributes
    private final int manaValue;

    // Constructor
    public Potion(String name, int manaValue)
    {
        super(name);
        this.manaValue = manaValue;
    }
}
