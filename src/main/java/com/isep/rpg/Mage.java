package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Mage extends SpellCaster
{
    // Attributes
    public static final int BASE_HP = 80;
    public static final int BASE_DAMAGE = 10;
    public static final int BASE_MANA = 100;
    public static final int BASE_SPELL_DAMAGE = 25;

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
