package com.isep.rpg.enemies;

import com.isep.rpg.heroes.Hero;

/**
 * A class representing a boar: a specific type of {@link Enemy}.
 * It is a relatively weak enemy that has both low hp and damage.
 */
public class Boar extends Enemy
{
    // Attributes
    public static final int BASE_HP = 30;
    public static final int BASE_DAMAGE = 8;

    // Constructors
    /**
     * Creates a new {@link Boar} with all values set to default.
     */
    public Boar()
    {
        super(Boar.class.getSimpleName(), Boar.BASE_DAMAGE, Boar.BASE_HP, Boar.BASE_HP);
    }

    /**
     * Creates a new {@link Boar} with the specified name and all values set to default.
     * @param name The name of the boar.
     */
    public Boar(String name)
    {
        super(name, Boar.BASE_DAMAGE, Boar.BASE_HP, Boar.BASE_HP);
    }

    /**
     * Creates a new {@link Boar}.
     * @param name The name of the boar.
     * @param baseDamage The base damage inflicted by the boar on each attack.
     * @param maxHp The maximum hp of the boar.
     * @param hp The current hp of the boar.
     */
    public Boar(String name, int baseDamage, int maxHp, int hp)
    {
        super(name, baseDamage, maxHp, hp);
    }
}
