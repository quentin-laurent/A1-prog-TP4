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

    /**
     * Creates a Healer with the default values for hp and mana
     * @param name The name of the Healer
     */
    public Healer(String name)
    {
        super(name, Healer.BASE_HP, Healer.BASE_HP, Healer.BASE_MANA, Healer.BASE_MANA);
    }

    /**
     * Creates a Healer by specifying all its attributes
     * @param name The name of the Healer
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     * @param maxMana The maximum mana value
     * @param mana The current mana value
     */
    public Healer(String name, int maxHP, int hp, int maxMana, int mana)
    {
        super(name, maxHP, hp, maxMana, mana);
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
    public void useFood(Consumable consumable) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
