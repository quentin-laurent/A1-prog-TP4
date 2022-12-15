package com.isep.rpg.enemies;

import com.isep.rpg.Combatant;
import com.isep.rpg.heroes.Hero;

/**
 * An abstract class representing an enemy: a specific type of {@link Combatant} that cannot be controlled
 * by the player. It has the ability to attack or defend itself.
 */
public abstract class Enemy extends Combatant
{
    // Constructor
    /**
     * Creates a new {@link Enemy}.
     * @param name The name of the enemy.
     * @param baseDamage The base damage inflicted by the enemy of each attack.
     * @param maxHP The maximum hp of the enemy.
     * @param hp The current hp of the enemy.
     */
    public Enemy(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
    }

    // Methods
    /**
     * Attacks a {@link Hero};
     * @param hero The targeted {@link Hero};
     * @return A 2-value array containing the damage inflicted and the damage reduction percentage applied.
     */
    public int[] attack(Hero hero)
    {
        if(hero.isAlive())
            return hero.applyDamage(this.baseDamage);
        return new int[]{0, 0};
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("");
        if(this.isAlive())
            s.append(String.format("%s (%d/%d HP)", this.name, this.hp, this.maxHP));
        else
            s.append(String.format("%s (*DEAD*)", this.name));
        return s.toString();
    }
}
