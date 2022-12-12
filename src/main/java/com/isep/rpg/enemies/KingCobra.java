package com.isep.rpg.enemies;

import com.isep.rpg.heroes.Hero;

/**
 * A class representing a king cobra: a specific type of {@link Enemy}.
 * It is a very strong enemy that has high hp and very high damage.
 */
public class KingCobra extends Enemy
{
    // Attributes
    public static final int BASE_HP = 200;
    public static final int BASE_DAMAGE = 50;

    // Constructors
    /**
     * Creates a new {@link KingCobra} with all values set to default.
     */
    public KingCobra()
    {
        super(KingCobra.class.getSimpleName(), KingCobra.BASE_DAMAGE, KingCobra.BASE_HP, KingCobra.BASE_HP);
    }

    /**
     * Creates a new {@link KingCobra} with the specified name and all values set to default.
     * @param name The name of the king cobra.
     */
    public KingCobra(String name)
    {
        super(name, KingCobra.BASE_DAMAGE, KingCobra.BASE_HP, KingCobra.BASE_HP);
    }

    /**
     * Creates a new {@link KingCobra}.
     * @param name The name of the king cobra.
     * @param baseDamage The base damage inflicted by the king cobra on each attack.
     * @param maxHp The maximum hp of the king cobra.
     * @param hp The current hp of the king cobra.
     */
    public KingCobra(String name, int baseDamage, int maxHp, int hp)
    {
        super(name, baseDamage, maxHp, hp);
    }

    // Methods
    @Override
    public int[] attack(Hero hero)
    {
        if(hero.isAlive())
            return hero.applyDamage(BASE_DAMAGE);
        return new int[]{0, 0};
    }
}
