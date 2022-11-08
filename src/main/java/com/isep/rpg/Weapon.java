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

    // Getters & Setters

    public int getBaseDamage()
    {
        return this.baseDamage;
    }

    public float getDamageMultiplier()
    {
        return this.damageMultiplier;
    }
}
