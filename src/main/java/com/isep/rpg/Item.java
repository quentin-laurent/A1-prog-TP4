package com.isep.rpg;

public abstract class Item
{
    // Attributes
    protected final String name;

    // Constructor
    public Item(String name)
    {
        this.name = name;
    }

    // Getters & Setters
    public String getName()
    {
        return this.name;
    }

    // Methods
    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Item))
            return false;

        Item item = (Item) o;
        return (this.name.equals(item.getName()));
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
