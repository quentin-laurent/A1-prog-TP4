package com.isep.rpg.heroes;

import com.isep.rpg.Combatant;
import com.isep.rpg.enemies.Enemy;

/**
 * A class representing a healer: a specific type of {@link SpellCaster} that has the ability to use spells to heal
 * any {@link Combatant}.
 */
public class Healer extends SpellCaster
{
    // Attributes
    protected int baseSpellHeal;

    public static final int BASE_HP = 75;
    public static final int BASE_DAMAGE = 10;
    public static final int BASE_MANA = 100;
    public static final int BASE_SPELL_HEAL = 30;
    public static final int SPELL_MANA_COST = 30;

    // Constructors
    /**
     * Creates a new {@link Healer} with the specified name and all values set to default.
     * @param name The name of the healer.
     */
    public Healer(String name)
    {
        super(name, Healer.BASE_DAMAGE, Healer.BASE_HP, Healer.BASE_HP, Healer.BASE_MANA, Healer.BASE_MANA, Healer.SPELL_MANA_COST);
        this.baseSpellHeal = BASE_SPELL_HEAL;
    }

    /**
     * Creates a new {@link Healer}.
     * @param name The name of the healer.
     * @param baseDamage The base damage inflicted by the healer on each attack.
     * @param maxHP The maximum hp of the healer.
     * @param hp The current hp of the healer.
     * @param maxMana The maximum mana of the healer.
     * @param mana The current mana of the healer.
     */
    public Healer(String name, int baseDamage, int maxHP, int hp, int maxMana, int mana)
    {
        super(name, baseDamage, maxHP, hp, maxMana, mana, Healer.SPELL_MANA_COST);
        this.baseSpellHeal = BASE_SPELL_HEAL;
    }

    // Getters & Setters
    public int getBaseSpellHeal()
    {
        return this.baseSpellHeal;
    }

    public void setBaseSpellHeal(int baseSpellHeal)
    {
        this.baseSpellHeal = baseSpellHeal;
    }

    // Methods
    /**
     * Heals the specified target.
     * @param target The {@link Combatant} to heal.
     * @return The amount of hp restored.
     * @throws RuntimeException if the healing spell cannot be cast.
     */
    @Override
    public int[] castSpell(Combatant target)
    {
        if(!target.isAlive())
            throw new RuntimeException("You can't heal a dead combattant !");

        if(this.mana < this.spellManaCost)
            throw new RuntimeException("You don't have enough mana !");

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
