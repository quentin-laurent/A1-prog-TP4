package com.isep.rpg.items;

import com.isep.rpg.heroes.Hero;

/**
 * An abstract class representing an item: something that a {@link Hero} can store in its inventory.
 */
public abstract class Item
{
    // Attributes
    protected final String name;

    // Constructor

    /**
     * Creates a new {@link Item}.
     * @param name The name of the item.
     */
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
