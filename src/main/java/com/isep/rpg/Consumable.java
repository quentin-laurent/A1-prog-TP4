package com.isep.rpg;

public abstract class Consumable extends Item
{
    // Constructor
    public Consumable(String name)
    {
        super(name);
    }

    // Methods

    /**
     * Applies a {@link Consumable} effect on a target
     * @param target The {@link Hero} targeted by the item's effect
     * @throws RuntimeException if the {@link Consumable}'s effect cannot be applied
     */
    abstract void applyEffect(Hero target) throws RuntimeException;
}
