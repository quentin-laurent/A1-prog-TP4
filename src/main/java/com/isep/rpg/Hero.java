package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public abstract class Hero extends Combatant
{
    // Attributes
    protected Weapon weapon;
    protected Armor armor;
    protected List<Consumable> consumables;

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
    }

    // Methods
    abstract void attack(Enemy enemy) throws ExecutionControl.NotImplementedException;
    abstract void defend() throws ExecutionControl.NotImplementedException;
    abstract void useConsumable(Consumable consumable) throws ExecutionControl.NotImplementedException;
}
