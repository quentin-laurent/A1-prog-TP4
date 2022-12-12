package com.isep.rpg.items;

import com.isep.rpg.heroes.Hero;

/**
 * A class representing an armor: a specific type of {@link Item} that can be equipped by a {@link Hero}
 * to reduce (or increase) the received damage.
 */
public class Armor extends Item
{
    // Attributes
    private final float damageMultiplier;

    // Constructor
    /**
     * Creates a new {@link Armor}.
     * @param name The name of the armor.
     * @param damageMultiplier The multiplier applied on the received damage.
     */
    public Armor(String name, float damageMultiplier)
    {
        super(name);
        this.damageMultiplier = damageMultiplier;
    }
}
