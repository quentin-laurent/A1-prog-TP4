package com.isep.rpg;

/**
 * A class representing an arrow: a specific type of {@link Item} that is required by a {@link Hunter} to attack.
 */
public class Arrow extends Item
{
    // Constructor
    /**
     * Creates a new {@link Arrow}
     * @param name The name of the arrow.
     * @param baseDamage The base damage inflicted by the arrow.
     */
    public Arrow(String name, int baseDamage)
    {
        super(name);
    }
}
