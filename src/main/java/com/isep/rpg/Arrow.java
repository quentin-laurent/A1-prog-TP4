package com.isep.rpg;

public class Arrow extends Item
{
    // Attributes
    private final int baseDamage;

    // Constructor
    public Arrow(String name, int baseDamage)
    {
        super(name);
        this.baseDamage = baseDamage;
    }

    // Getters & Setters
    public int getBaseDamage()
    {
        return this.baseDamage;
    }
}
