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
    public int attack(Enemy enemy)
    {
        // TODO: throw exception when enemy is dead
        if(enemy.isAlive())
        {
            // Calculating damage output
            int damage;
            if(this.weapon != null)
                damage = Math.round((BASE_DAMAGE + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
            else
                damage = BASE_DAMAGE;

            return enemy.applyDamage(damage);
        }
        return 0;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("");
        if(!(this.isAlive()))
            s.append("*dead* ");

        s.append(this.name);
        s.append(" (").append(this.getClass().getSimpleName()).append(")");

        return s.toString();
    }
}
