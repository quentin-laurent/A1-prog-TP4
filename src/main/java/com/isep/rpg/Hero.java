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
    abstract void attack(Enemy enemy) throws ExecutionControl.NotImplementedException;
    abstract void defend() throws ExecutionControl.NotImplementedException;
    abstract void useFood(Consumable consumable) throws ExecutionControl.NotImplementedException;
}
