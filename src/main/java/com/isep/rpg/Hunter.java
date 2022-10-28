package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Hunter extends Hero
{
    // Attributes
    public static final int BASE_HP = 125;
    public static final int BASE_DAMAGE = 15;

    // Constructor

    /**
     * Creates a Hunter with the default values for hp
     * @param name The name of the Hunter
     */
    public Hunter(String name)
    {
        super(name, Hunter.BASE_HP, Hunter.BASE_HP);
    }

    /**
     * Creates a Hunter by specifying all its attributes
     * @param name The name of the Hunter
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     */
    public Hunter(String name, int maxHP, int hp)
    {
        super(name, maxHP, hp);
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
