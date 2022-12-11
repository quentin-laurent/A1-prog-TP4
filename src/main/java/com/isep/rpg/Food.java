package com.isep.rpg;

public class Food extends Consumable
{
    // Attributes
    private final int healValue;

    // Constructor
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
