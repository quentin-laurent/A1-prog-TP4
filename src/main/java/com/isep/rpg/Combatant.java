package com.isep.rpg;

public abstract class Combatant
{
    // Attributes
    protected final String name;
    protected int maxHP;
    protected int hp;

    // Constructor
    public Combatant(String name, int maxHP, int hp)
    {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = hp;
    }

    // Getters & Setters

    public int getHp()
    {
        return this.hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
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
    public void applyDamage(int damage)
    {
        if((this.hp - damage) < 0)
            this.hp = 0;
        else
            this.hp -= damage;
    }
}
