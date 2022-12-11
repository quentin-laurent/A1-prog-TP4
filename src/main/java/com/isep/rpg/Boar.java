package com.isep.rpg;


public class Boar extends Enemy
{
    // Attributes
    public static final int BASE_HP = 30;
    public static final int BASE_DAMAGE = 8;

    // Constructors

    /**
     * Creates a new {@link Boar} using all default values and the class name as its name.
     */
    public Boar()
    {
        super(Boar.class.getSimpleName(), Boar.BASE_DAMAGE, Boar.BASE_HP, Boar.BASE_HP);
    }

    /**
     * Creates a new {@link Boar} using all default values.
     * @param name The name of the new {@link Boar}.
     */
    public Boar(String name)
    {
        super(name, Boar.BASE_DAMAGE, Boar.BASE_HP, Boar.BASE_HP);
    }

    /**
     * Creates a new {@link Boar}.
     * @param name The name of the new {@link Boar}.
     * @param baseDamage The base damage value of the new {@link Boar}
     * @param maxHp The maximum hp value of the new {@link Boar}.
     * @param hp The hp value of the new {@link Boar}
     */
    public Boar(String name, int baseDamage, int maxHp, int hp)
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
