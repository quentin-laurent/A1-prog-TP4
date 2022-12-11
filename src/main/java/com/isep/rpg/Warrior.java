package com.isep.rpg;

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
        super(name, Warrior.BASE_DAMAGE, Warrior.BASE_HP, Warrior.BASE_HP);
    }

    /**
     * Creates a Warrior by specifying all its attributes
     * @param name The name of the Warrior
     * @param baseDamage The base damage value
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     */
    public Warrior(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
    }

    // Methods

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

        return enemy.applyDamage(damage);
    }
}
