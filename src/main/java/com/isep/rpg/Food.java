package com.isep.rpg;

/**
 * A class representing a food item: a specific type of {@link Consumable} that restores hp.
 * It can be used by any {@link Hero}.
 */
public class Food extends Consumable
{
    // Attributes
    private final int healValue;

    // Constructor
    /**
     * Creates a new {@link Food} item.
     * @param name The name of the food.
     * @param healValue The amount of hp restored when consumed.
     */
    public Food(String name, int healValue)
    {
        super(name);
        this.healValue = healValue;
    }

    // Getters & Setters
    public int getHealValue()
    {
        return this.healValue;
    }

    // Methods
    @Override
    public int applyEffect(Hero target)
    {
        return target.applyHeal(this.healValue);
    }

    @Override
    public int hashCode()
    {
        return (this.name.hashCode() + this.healValue);
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Food))
            return false;

        Food food = (Food) o;
        return ((this.name.equals(food.getName())) && (this.healValue == food.getHealValue()));
    }
}
