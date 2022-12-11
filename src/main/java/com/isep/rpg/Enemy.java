package com.isep.rpg;


public abstract class Enemy extends Combatant
{
    // Constructor

    /**
     * Creates a new {@link Enemy}
     * @param name The name of the Enemy
     * @param baseDamage The base damage value
     * @param maxHP The maximum hp value
     * @param hp The hp value
     */
    public Enemy(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
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
