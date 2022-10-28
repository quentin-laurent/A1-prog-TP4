package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Hunter extends Hero
{
    // Attributes
    public static final int BASE_HP = 125;
    public static final int BASE_DAMAGE = 15;

    // Constructor
    public Hunter(String name, int hp, int baseDamage)
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
