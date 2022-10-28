package com.isep.rpg;

public abstract class Combatant
{
    // Attributes
    protected final String name;
    protected int maxHP;
    protected int hp;

    // Constructor
    public Combatant(String name, int maxHP, int hp)
    {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = hp;
    }
}
