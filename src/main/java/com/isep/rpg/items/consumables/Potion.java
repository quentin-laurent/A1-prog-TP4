package com.isep.rpg.items.consumables;

import com.isep.rpg.heroes.Hero;
import com.isep.rpg.heroes.SpellCaster;

/**
 * A class representing a potion: a specific type of {@link Consumable} that restores mana.
 * It can only be used by {@link SpellCaster}s.
 */
public class Potion extends Consumable
{
    // Attributes
    private final int manaValue;

    // Constructor
    /**
     * Creates a new {@link Potion}.
     * @param name The name of the potion.
     * @param manaValue The amount of mana restored when consumed.
     */
    public Potion(String name, int manaValue)
    {
        super(name);
        this.manaValue = manaValue;
    }

    // Getters & Setters
    public int getManaValue()
    {
        return this.manaValue;
    }

    // Methods
    @Override
    public int applyEffect(Hero target) throws RuntimeException
    {
        if(!(target instanceof SpellCaster))
            throw new RuntimeException("You can't use a mana potion !");

        return ((SpellCaster)target).restoreMana(this.manaValue);
    }

    @Override
    public int hashCode()
    {
        return (this.name.hashCode() + this.manaValue);
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Potion))
            return false;

        Potion potion = (Potion) o;
        return ((this.name.equals(potion.getName())) && (this.manaValue == potion.getManaValue()));
    }
}
