package com.isep.rpg;

public abstract class Combatant
{
    // Attributes
    protected final String name;
    protected final int hp;
    protected final int baseDamage;

    // Constructor
    public Combatant(String name, int hp, int baseDamage)
    {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }
}
