package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Healer extends SpellCaster
{
    // Attributes
    public static final int BASE_HP = 75;
    public static final int BASE_DAMAGE = 10;
    public static final int BASE_MANA = 100;
    public static final int BASE_SPELL_HEAL = 30;

    // Constructor
    public Healer(String name, int hp, int baseDamage, int mana)
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
