package com.isep.rpg.heroes;

import com.isep.rpg.Combatant;
import com.isep.rpg.enemies.Enemy;

/**
 * A class representing a mage: a specific type of {@link SpellCaster} that has the ability to use spells to inflict damage
 * on any {@link Combatant};
 */
public class Mage extends SpellCaster
{
    // Attributes
    protected int baseSpellDamage;

    public static final int BASE_HP = 80;
    public static final int BASE_DAMAGE = 10;
    public static final int BASE_MANA = 100;
    public static final int BASE_SPELL_DAMAGE = 25;
    public static final int SPELL_MANA_COST = 40;

    // Constructors
    /**
     * Creates a new {@link Mage} with the specified name and all values set to default.
     * @param name The name of the mage.
     */
    public Mage(String name)
    {
        super(name, Mage.BASE_DAMAGE, Mage.BASE_HP, Mage.BASE_HP, Mage.BASE_MANA, Mage.BASE_MANA, Mage.SPELL_MANA_COST);
        this.baseSpellDamage = BASE_SPELL_DAMAGE;
    }

    /**
     * Creates a new {@link Mage}.
     * @param name The name of the mage.
     * @param baseDamage The base damage inflicted by the mage on each attack.
     * @param maxHP The maximum hp of the mage.
     * @param hp The current hp of the mage.
     * @param maxMana The maximum mana of the mage.
     * @param mana The current mana of the mage.
     */
    public Mage(String name, int baseDamage, int maxHP, int hp, int maxMana, int mana)
    {
        super(name, baseDamage, maxHP, hp, maxMana, mana, Mage.SPELL_MANA_COST);
        this.baseSpellDamage = BASE_SPELL_DAMAGE;
    }

    // Getters & Setters
    public int getBaseSpellDamage()
    {
        return this.baseSpellDamage;
    }

    public void setBaseSpellDamage(int baseSpellDamage)
    {
        this.baseSpellDamage = baseSpellDamage;
    }

    // Methods
    @Override
    public int[] attack(Enemy enemy)
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");
        if(this.mana < this.spellManaCost)
            throw new RuntimeException("You don't have enough mana !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((this.baseDamage + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = this.baseDamage;

        return enemy.applyDamage(damage);
    }

    /**
     * Inflicts damage to the specified target.
     * @param target The {@link Combatant} to attack.
     * @return The damage inflicted.
     * @throws RuntimeException if the attack spell cannot be cast.
     */
    @Override
    public int[] castSpell(Combatant target) throws RuntimeException
    {
        if(!target.isAlive())
            throw new RuntimeException("You can't attack a dead combatant !");

        if(this.mana < this.spellManaCost)
            throw new RuntimeException("You don't have enough mana !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((this.baseSpellDamage + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = this.baseSpellDamage;

        // Updating the mana amount
        int mana = this.mana - this.spellManaCost;

        if(mana < 0)
            this.mana = 0;
        else
            this.mana = mana;

        int[] damageAndManaCost = new int[2];
        damageAndManaCost[0] = target.applyDamage(damage)[0];
        damageAndManaCost[1] = this.spellManaCost;

        return damageAndManaCost;
    }
}
