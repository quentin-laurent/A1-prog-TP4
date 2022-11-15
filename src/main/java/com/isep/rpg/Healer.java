package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Healer extends SpellCaster
{
    // Attributes
    public static final int BASE_HP = 75;
    public static final int BASE_DAMAGE = 10;
    public static final int BASE_MANA = 100;
    public static final int BASE_SPELL_HEAL = 30;
    public static final int SPELL_MANA_COST = 30;

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
    public void attack(Enemy enemy)
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((BASE_DAMAGE + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = BASE_DAMAGE;

        // Updating enemy hp
        enemy.applyDamage(damage);
    }

    /**
     * Heals the target
     * @param target The Combattant to receive the heal
     */
    @Override
    public void castSpell(Combatant target)
    {
        if(!target.isAlive())
            throw new RuntimeException("You can't heal a dead combattant !");

        // Updating the mana amount
        int mana = this.mana - SPELL_MANA_COST;

        if(mana < 0)
            this.mana = 0;
        else
            this.mana = mana;

        // Updating the target hp
        int heal = BASE_SPELL_HEAL;

        if((target.getHp() + heal) > target.getMaxHP())
            target.setHp(target.getMaxHP());
        else
            target.setHp(target.getHp() + heal);
    }
}
