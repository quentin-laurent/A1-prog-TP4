package com.isep.rpg.heroes;

import com.isep.rpg.enemies.Enemy;

/**
 * A class representing a warrior: a specific type of {@link Hero} that has a high damage potential.
 */
public class Warrior extends Hero
{
    // Attributes
    public static final int BASE_HP = 100;
    public static final int BASE_DAMAGE = 35;

    // Constructors
    /**
     * Creates a new {@link Warrior} with the specified name and all values set to default.
     * @param name The name of the warrior.
     */
    public Warrior(String name)
    {
        super(name, Warrior.BASE_DAMAGE, Warrior.BASE_HP, Warrior.BASE_HP);
    }

    /**
     * Creates a new {@link Warrior}.
     * @param name The name of the warrior.
     * @param baseDamage The base damage inflicted by the warrior on each attack.
     * @param maxHP The maximum hp of the warrior.
     * @param hp The current hp of the warrior.
     */
    public Warrior(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
    }
}
