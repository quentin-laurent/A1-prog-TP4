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

    /**
     * Creates a Mage with the default values for hp and mana
     * @param name The name of the Mage
     */
    public Mage(String name)
    {
        super(name, Mage.BASE_HP, Mage.BASE_HP, Mage.BASE_MANA, Mage.BASE_MANA);
    }

    /**
     * Creates a mage by specifying all its attributes
     * @param name The name of the Mage
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     * @param maxMana The maximum mana value
     * @param mana The current mana value
     */
    public Mage(String name, int maxHP, int hp, int maxMana, int mana)
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
    public void useConsumable(Consumable consumable) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
