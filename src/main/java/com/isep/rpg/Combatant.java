package com.isep.rpg;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * An abstract class representing a combatant: an entity of the {@link Game} that has different attributes
 * and is able to perform different actions such as attacking, defending, using {@link Consumable}s etc.
 */
public abstract class Combatant
{
    // Attributes
    protected final String name;
    protected int baseDamage;
    protected int maxHP;
    protected int hp;
    protected boolean defend;

    private static final int DEFEND_MIN_REDUCTION = 20;
    private static final int DEFEND_MAX_REDUCTION = 50;

    // Constructor
    /**
     * Creates a new {@link Combatant}.
     * @param name The name of the combatant.
     * @param baseDamage The base damage inflicted by the combatant on each attack.
     * @param maxHP The maximum hp of the combatant.
     * @param hp The current hp of the combatant.
     */
    public Combatant(String name, int baseDamage, int maxHP, int hp)
    {
        this.name = name;
        this.baseDamage = baseDamage;
        this.maxHP = maxHP;
        this.hp = hp;
    }

    // Getters & Setters
    public String getName()
    {
        return this.name;
    }

    public int getBaseDamage()
    {
        return this.baseDamage;
    }

    public void setBaseDamage(int baseDamage)
    {
        this.baseDamage = baseDamage;
    }

    public int getHp()
    {
        return this.hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getMaxHP()
    {
        return this.maxHP;
    }

    public void setMaxHp(int maxHP)
    {
        this.maxHP = maxHP;
    }

    // Methods
    /**
     * Indicates if this {@link Combatant} is alive.
     * @return true if this {@link Combatant} is alive, false otherwise.
     */
    public boolean isAlive()
    {
        return (this.hp > 0);
    }

    /**
     * Applies damage to this {@link Combatant}.
     * @param damage The damage to apply to this {@link Combatant}.
     * @return A 2-value array containing the damage applied and the damage reduction percentage applied.
     */
    public int[] applyDamage(int damage)
    {
        // A 2-value array containing the damage inflicted and the applied damage reduction percentage
        // TODO: it might be more scalable to use a Map here
        int[] damageAndReductionPercentage = {0, 0};

        // Applying damage reduction if the target is defending itself
        if(this.defend)
        {
            int reductionPercentage = this.calculateDefendReductionPercentage();
            float damageMultiplier = this.calculateDefendDamageMultiplier(reductionPercentage);
            damage *= damageMultiplier;

            damageAndReductionPercentage[1] = reductionPercentage;
            this.defend = false;
        }

        int inflictedDamage = damage;

        if((this.hp - damage) < 0)
        {
            inflictedDamage = this.getHp();
            this.hp = 0;
        }
        else
            this.hp -= damage;

        damageAndReductionPercentage[0] = inflictedDamage;

        return damageAndReductionPercentage;
    }

    /**
     * Restores hp to this {@link Combatant}.
     * @param heal The amount of hp to restore.
     * @return The actual amount of hp restored.
     */
    //TODO: rename method to restoreHp and rename param to healValue
    public int applyHeal(int heal)
    {
        int initialHp = this.hp;
        if((this.hp + heal) > this.maxHP)
            this.hp = this.maxHP;
        else
            this.hp += heal;

        return (this.hp - initialHp);
    }

    /**
     * Enables this @{@link Combatant} to reduce the damage of the next attack from {@value DEFEND_MIN_REDUCTION}%
     * to {@value DEFEND_MAX_REDUCTION}%.
     */
    public void defend()
    {
        this.defend = true;
    }

    /**
     * Calculates the percentage to be used in the {@link #calculateDefendDamageMultiplier} method.
     * @return An integer between {@value DEFEND_MIN_REDUCTION} and {@value DEFEND_MAX_REDUCTION} representing
     * the damage reduction percentage.
     */
    //TODO: rename method to calculateDamageReductionPercentage
    private int calculateDefendReductionPercentage()
    {
        Random random = new Random();
        int reductionPercentage = DEFEND_MIN_REDUCTION + random.nextInt(DEFEND_MAX_REDUCTION - DEFEND_MIN_REDUCTION + 1);
        return reductionPercentage;
    }

    /**
     * Converts a damage reduction percentage (int) to a damage multiplier (float).
     * @param reductionPercentage The damage reduction percentage to convert.
     * @return The calculated damage multiplier.
     */
    //TODO: rename method to calculateDamageMultiplier
    //TODO: change param name to damageReductionPercentage
    private float calculateDefendDamageMultiplier(int reductionPercentage)
    {
        BigDecimal damageMultiplier = BigDecimal.valueOf(1 - (reductionPercentage / 100f));
        damageMultiplier = damageMultiplier.setScale(2, RoundingMode.HALF_EVEN);
        return damageMultiplier.floatValue();
    }
}
