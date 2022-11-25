package com.isep.rpg;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public abstract class Combatant
{
    // Attributes
    protected final String name;
    protected int maxHP;
    protected int hp;
    protected boolean defend;

    private static final int DEFEND_MIN_REDUCTION = 20;
    private static final int DEFEND_MAX_REDUCTION = 50;

    // Constructor
    public Combatant(String name, int maxHP, int hp)
    {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = hp;
    }

    // Getters & Setters

    public String getName()
    {
        return this.name;
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

    // Methods

    /***
     * Indicates if the current Combattant is alive
     * @return true if the current Combattant is alive, false otherwise
     */
    public boolean isAlive()
    {
        return (this.hp > 0);
    }

    /**
     * Applies damage to the Combattant
     * @param damage The damage to applu to the Combattant
     */
    public int applyDamage(int damage)
    {
        // Applying damage reduction if the target is defending itself
        if(this.defend)
        {
            int reductionPercentage = this.calculateDefendReductionPercentage();
            float damageMultiplier = this.calculateDefendDamageMultiplier(reductionPercentage);
            damage *= damageMultiplier;

            System.out.printf("%s reduced the damage by %d%% !%n", this.name, reductionPercentage);
            this.defend = false;
        }

        if((this.hp - damage) < 0)
            this.hp = 0;
        else
            this.hp -= damage;

        return damage;
    }

    /**
     * Adds hp to a {@link Combatant}
     * @param heal The hp amount to add to the {@link Combatant}
     */
    public void applyHeal(int heal)
    {
        if((this.hp + heal) > this.maxHP)
            this.hp = this.maxHP;
        else
            this.hp += heal;
    }

    /**
     * Reduces the damage inflicted by the next attack randomly from 20 to 50%
     */
    public void defend()
    {
        this.defend = true;
    }

    /**
     * Calculates the percentage to be used in the {@link #calculateDefendDamageMultiplier(int)} method.
     * @return An integer between {@value DEFEND_MIN_REDUCTION} and {@value DEFEND_MAX_REDUCTION} representing the percentage of damage to be absorbed by the combatant.
     */
    private int calculateDefendReductionPercentage()
    {
        Random random = new Random();
        int reductionPercentage = DEFEND_MIN_REDUCTION + random.nextInt(DEFEND_MAX_REDUCTION - DEFEND_MIN_REDUCTION + 1);
        return reductionPercentage;
    }

    /**
     * Converts a damage reduction percentage to a float value to be used as a multiplier.
     * @param reductionPercentage The reduction percentage to apply to the damage.
     * @return A float to be used as a multiplier with the damage taken by the combatant.
     */
    private float calculateDefendDamageMultiplier(int reductionPercentage)
    {
        BigDecimal damageMultiplier = BigDecimal.valueOf(1 - (reductionPercentage / 100f));
        damageMultiplier = damageMultiplier.setScale(2, RoundingMode.HALF_EVEN);
        return damageMultiplier.floatValue();
    }
}
