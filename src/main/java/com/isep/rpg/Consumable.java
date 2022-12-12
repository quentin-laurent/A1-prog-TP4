package com.isep.rpg;

/**
 * An abstract class representing a consumable: a specific type of {@link Item} that can be consumed by a {@link Hero}
 * to gain certain effects (e.g. restoring health, restoring mana etc.).
 */
public abstract class Consumable extends Item
{
    // Constructor
    /**
     * Creates a new {@link Consumable}.
     * @param name The name of the consumable.
     */
    public Consumable(String name)
    {
        super(name);
    }

    // Methods
    /**
     * Applies the effect of this {@link Consumable} to the specified target.
     * @param target The {@link Hero} to receive the effect of this consumable.
     * @return The numeric value of the applied effect (e.g. the amount of health or mana restored).
     * @throws RuntimeException if the effect of this consumable cannot be applied to the target.
     */
    abstract int applyEffect(Hero target) throws RuntimeException;
}
