package com.isep.rpg;

/**
 * A class representing a weapon: a specific type of {@link Item} that can be equipped by a {@link Hero} to increase
 * (or reduce) its damage on each attack.
 */
public class Weapon extends Item
{
    // Attributes
    private final int baseDamage;
    private final float damageMultiplier;

    // Constructor

    /**
     * Creates a new {@link Weapon}.
     * @param name The name of the weapon.
     * @param baseDamage The base damage inflicted by the weapon on each attack.
     * @param damageMultiplier The damage multiplier applied on each attack.
     */
    public Weapon(String name, int baseDamage, float damageMultiplier)
    {
        super(name);
        this.baseDamage = baseDamage;
        this.damageMultiplier = damageMultiplier;
    }

    // Getters & Setters
    public int getBaseDamage()
    {
        return this.baseDamage;
    }

    public float getDamageMultiplier()
    {
        return this.damageMultiplier;
    }
}
