package com.isep.rpg;

public class Weapon extends Item
{
    // Attributes
    private final int baseDamage;
    private final float damageMultiplier;

    // Constructor
    public Weapon(String name, int baseDamage, float damageMultiplier)
    {
        super(name);
        this.baseDamage = baseDamage;
        this.damageMultiplier = damageMultiplier;
    }
}
