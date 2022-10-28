package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public abstract class Hero extends Combatant
{
    // Attributes
    protected Weapon weapon;
    protected Armor armor;
    protected List<Consumable> consumables;

    // Constructor
    public Hero(String name, int hp, int baseDamage)
    {
        super(name, hp, baseDamage);
    }

    // Methods
    abstract void attack(Enemy enemy) throws ExecutionControl.NotImplementedException;
    abstract void defend() throws ExecutionControl.NotImplementedException;
    abstract void useConsumable(Consumable consumable) throws ExecutionControl.NotImplementedException;
}
