package com.isep.rpg;


public abstract class Enemy extends Combatant
{
    // Constructor
    public Enemy(String name, int maxHP, int hp)
    {
        super(name, maxHP, hp);
    }

    // Methods
    abstract void attack(Hero hero);
}
