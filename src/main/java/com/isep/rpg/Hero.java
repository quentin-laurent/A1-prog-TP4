package com.isep.rpg;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero extends Combatant
{
    // Attributes
    protected Weapon weapon;
    protected Armor armor;
    protected Map<Item, Integer> items;

    // Constructor
    /**
     * Creates a new {@link Hero}
     * @param name The name of the Hero
     * @param baseDamage The base damage value
     * @param maxHP The maximum hp value
     * @param hp The hp value
     */
    public Hero(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
        this.items = new HashMap<Item, Integer>();
    }

    // Getters & Setters
    public Map<Item, Integer> getItems()
    {
        return this.items;
    }

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor)
    {
        this.armor = armor;
    }

    // Methods

    /**
     * Adds an {@link Item} to the {@link Hero}'s inventory
     * @param item The {@link Item} to add
     * @param quantity The quantity of the {@link Item} to add
     */
    public void addItem(Item item, int quantity)
    {
        this.items.put(item, quantity);
    }

    /**
     * Consumes a {@link Consumable} on a {@link Hero} and updates its inventory
     * @param consumable The {@link Consumable} to consume
     */
    public void consumeItem(Consumable consumable) throws RuntimeException
    {
        if(this.items.entrySet().contains(consumable))
            throw new RuntimeException("Consumable not in inventory !");


        consumable.applyEffect(this);

        // Updating the inventory
        int quantity = this.items.get(consumable);
        if(quantity > 1)
            this.items.put(consumable, quantity - 1);
        else
            this.items.remove(consumable);

    }

    public boolean hasAnyConsumableItem()
    {
        for(var entry: this.items.entrySet())
        {
            if(entry.getKey() instanceof Consumable)
                return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("");
        if(this.isAlive())
            s.append(String.format("%s (%d/%d) [%s]", this.name, this.hp, this.maxHP, this.getClass().getSimpleName()));
        else
            s.append(String.format("%s (*DEAD*) [%s]", this.name, this.getClass().getSimpleName()));

        return s.toString();
    }

    abstract int[] attack(Enemy enemy);
}
