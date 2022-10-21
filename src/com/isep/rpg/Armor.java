package com.isep.rpg;

public class Armor extends Item
{
    // Attributes
    private final float damageMultiplier;

    // Constructor
    public Armor(String name, float damageMultiplier)
    {
        super(name);
        this.damageMultiplier = damageMultiplier;
    }
}
