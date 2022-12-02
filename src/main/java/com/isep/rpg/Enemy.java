package com.isep.rpg;


public abstract class Enemy extends Combatant
{
    // Constructor
    public Enemy(String name, int maxHP, int hp)
    {
        super(name, maxHP, hp);
    }

    // Methods
    abstract int[] attack(Hero hero);

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("");
        if(this.isAlive())
            s.append(String.format("%s (%d/%d)", this.name, this.hp, this.maxHP));
        else
            s.append(String.format("%s (*DEAD*)", this.name));
        return s.toString();
    }
}
