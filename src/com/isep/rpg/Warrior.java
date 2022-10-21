package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Warrior extends Hero
{
    // Constructor
    public Warrior(String name, int hp, int baseDamage)
    {
        super(name, hp, baseDamage);
    }

    // Metmods

    @Override
    public void attack(Enemy enemy) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void defend() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void useConsumable(Consumable consumable) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
