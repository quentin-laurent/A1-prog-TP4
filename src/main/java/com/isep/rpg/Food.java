package com.isep.rpg;

public class Food extends Consumable
{
    // Attributes
    private final int healValue;

    // Constructor
    public Food(String name, int healValue)
    {
        super(name);
        this.healValue = healValue;
    }
}
