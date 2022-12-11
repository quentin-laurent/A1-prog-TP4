package com.isep.rpg;

public class Potion extends Consumable
{
    // Attributes
    private final int manaValue;

    // Constructor
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
    public void applyEffect(Hero target) throws RuntimeException
    {
        if(!(target instanceof SpellCaster))
            throw new RuntimeException("You can't use a mana potion !");

        ((SpellCaster)target).restoreMana(this.manaValue);
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
