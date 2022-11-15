package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero extends Combatant
{
    // Attributes
    protected Weapon weapon;
    protected Armor armor;
    protected Map<Item, Integer> items;

    // Getters & Setters
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
            throw new RuntimeException("Consumble not in inventory !");

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

    abstract void attack(Enemy enemy) throws ExecutionControl.NotImplementedException;
}
