package com.isep.rpg;

public class Healer extends SpellCaster
{
    // Attributes
    protected int baseSpellHeal;

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
        super(name, Healer.BASE_DAMAGE, Healer.BASE_HP, Healer.BASE_HP, Healer.BASE_MANA, Healer.BASE_MANA, Healer.SPELL_MANA_COST);
        this.baseSpellHeal = BASE_SPELL_HEAL;
    }

    /**
     * Creates a Healer by specifying all its attributes
     * @param name The name of the Healer
     * @param baseDamage The base damage value
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     * @param maxMana The maximum mana value
     * @param mana The current mana value
     */
    public Healer(String name, int baseDamage, int maxHP, int hp, int maxMana, int mana)
    {
        super(name, baseDamage, maxHP, hp, maxMana, mana, Healer.SPELL_MANA_COST);
        this.baseSpellHeal = BASE_SPELL_HEAL;
    }

    // Metmods

    @Override
    public int[] attack(Enemy enemy)
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((this.baseDamage + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = this.baseDamage;

        // Updating enemy hp
        return enemy.applyDamage(damage);
    }

    /**
     * Heals the target
     *
     * @param target The Combattant to receive the heal
     * @return A 2-value array containing the damage applied and the mana cost of the spell
     */
    @Override
    public int[] castSpell(Combatant target)
    {
        if(!target.isAlive())
            throw new RuntimeException("You can't heal a dead combattant !");

        // Updating the mana amount
        int mana = this.mana - this.spellManaCost;

        if(mana < 0)
            this.mana = 0;
        else
            this.mana = mana;

        int[] healAndManaCost = new int[2];
        healAndManaCost[0] = target.applyHeal(this.baseSpellHeal);
        healAndManaCost[1] = this.spellManaCost;
        return healAndManaCost;
    }
}
