package com.isep.rpg;

public abstract class SpellCaster extends Hero
{
    // Attributes
    protected int maxMana;
    protected int mana;

    // Constructor
    public SpellCaster(String name, int maxHP, int hp, int maxMana, int mana)
    {
        super(name, maxHP, hp);
        this.maxMana = maxMana;
        this.mana = mana;
    }
}
