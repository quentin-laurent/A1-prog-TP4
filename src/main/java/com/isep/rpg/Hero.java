package com.isep.rpg;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero extends Combatant
{
    // Attributes
    protected Weapon weapon;
    protected Armor armor;
    protected Map<Item, Integer> items;

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

    // Constructor
    public Hero(String name, int maxHP, int hp)
    {
        super(name, maxHP, hp);
        this.items = new HashMap<Item, Integer>();
    }

    // Methods

    /**
     * Consumes a {@link Consumable} on a {@link Hero} and updates its inventory
     * @param consumable The {@link Consumable} to consume
     */
    public void consumeItem(Consumable consumable)
    {
        if(this.items.entrySet().contains(consumable))
            throw new RuntimeException("Consumable not in inventory !");

        try
        {
            consumable.applyEffect(this);

            // Updating the inventory
            int quantity = this.items.get(consumable);
            if(quantity > 1)
                this.items.put(consumable, quantity - 1);
            else
                this.items.remove(consumable);
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
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
