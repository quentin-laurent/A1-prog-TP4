package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Warrior extends Hero
{
    // Attributes
    public static final int BASE_HP = 100;
    public static final int BASE_DAMAGE = 35;

    // Constructor

    /**
     * Creates a Warrior with the default values for hp
     * @param name The name of the Warrior
     */
    public Warrior(String name)
    {
        super(name, Warrior.BASE_HP, Warrior.BASE_HP);
    }

    /**
     * Creates a Warrior by specifying all its attributes
     * @param name The name of the Warrior
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     */
    public Warrior(String name, int maxHP, int hp)
    {
        super(name, maxHP, hp);
    }

    // Methods

    @Override
    public void attack(Enemy enemy) throws ExecutionControl.NotImplementedException
    {
        if(enemy.isAlive())
        {
            // Calculating damage output
            int damage;
            if(this.weapon != null)
                damage = Math.round((BASE_DAMAGE + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
            else
                damage = BASE_DAMAGE;

            enemy.applyDamage(damage);
        }
    }

    @Override
    public void useFood(Consumable consumable) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
