package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Boar extends Enemy
{
    // Attributes
    public static final int BASE_HP = 30;
    public static final int BASE_DAMAGE = 8;

    // Constructor
    public Boar(String name, int hp, int baseDamage)
    {
        super(name, hp, baseDamage);
    }

    // Methods
    @Override
    public void attack(Hero hero) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
