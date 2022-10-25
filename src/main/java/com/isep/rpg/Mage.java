package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Mage extends SpellCaster
{
    // Constructor
    public Mage(String name, int hp, int baseDamage, int mana)
    {
        super(name, hp, baseDamage, mana);
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
