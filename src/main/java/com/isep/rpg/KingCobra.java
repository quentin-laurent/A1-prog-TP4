package com.isep.rpg;


public class KingCobra extends Enemy
{
    // Attributes
    public static final int BASE_HP = 200;
    public static final int BASE_DAMAGE = 50;

    // Constructors

    /**
     * Creates a new {@link KingCobra} using all default values and the class name as its name.
     */
    public KingCobra()
    {
        super(KingCobra.class.getSimpleName(), KingCobra.BASE_DAMAGE, KingCobra.BASE_HP, KingCobra.BASE_HP);
    }

    /**
     * Creates a new {@link KingCobra} using all default values.
     * @param name The name of the new {@link KingCobra}.
     */
    public KingCobra(String name)
    {
        super(name, KingCobra.BASE_DAMAGE, KingCobra.BASE_HP, KingCobra.BASE_HP);
    }

    /**
     * Creates a new {@link KingCobra}.
     * @param name The name of the new {@link KingCobra}.
     * @param baseDamage The base damage value of the new {@link KingCobra}
     * @param maxHp The maximum hp value of the new {@link KingCobra}.
     * @param hp The hp value of the new {@link KingCobra}
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
