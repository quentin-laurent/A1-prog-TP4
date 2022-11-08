package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Mage extends SpellCaster
{
    // Attributes
    public static final int BASE_HP = 80;
    public static final int BASE_DAMAGE = 10;
    public static final int BASE_MANA = 100;
    public static final int BASE_SPELL_DAMAGE = 25;
    public static final int SPELL_MANA_COST = 40;

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
     * Creates a Mage by specifying all its attributes
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
    public void attack(Enemy enemy) throws ExecutionControl.NotImplementedException
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");
        if(this.mana < SPELL_MANA_COST)
            throw new RuntimeException("You don't have enough mana !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((BASE_DAMAGE + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = BASE_DAMAGE;

        enemy.setHp(enemy.getHp() - damage);
    }

    /**
     * Applies damage to the target using mana
     * @param target The Combattant to receive the damage
     */
    @Override
    public void castSpell(Combatant target) throws ExecutionControl.NotImplementedException
    {
        if(!target.isAlive())
            throw new RuntimeException("You can't attack a dead combattant !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((BASE_SPELL_DAMAGE + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = BASE_DAMAGE;

        // Updating the mana amount
        int mana = this.mana - SPELL_MANA_COST;

        if(mana < 0)
            this.mana = 0;
        else
            this.mana = mana;

        // Updating the target hp
        target.applyDamage(damage);
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
