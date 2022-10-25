package com.isep.rpg;

public abstract class SpellCaster extends Hero
{
    // Attributes
    protected int mana;

    // Constructor
    public SpellCaster(String name, int hp, int baseDamage, int mana)
    {
        super(name, hp, baseDamage);
        this.mana = mana;
    }
}
