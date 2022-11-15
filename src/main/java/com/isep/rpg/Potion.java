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

    // Methods
    @Override
    public void applyEffect(Hero target)
    {
        if(!(target instanceof SpellCaster))
            throw new RuntimeException("You can't use a mana potion !");

        ((SpellCaster)target).restoreMana(this.manaValue);
    }
}
