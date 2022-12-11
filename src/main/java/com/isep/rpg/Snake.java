package com.isep.rpg;


public class Snake extends Enemy
{
    // Attributes
    public static final int BASE_HP = 15;
    public static final int BASE_DAMAGE = 30;

    // Constructor

    /**
     * Creates a new {@link Snake} using all default values and the class name as its name.
     */
    public Snake()
    {
        super(Snake.class.getSimpleName(), Snake.BASE_DAMAGE, Snake.BASE_HP, Snake.BASE_HP);
    }

    /**
     * Creates a new {@link Snake} using all default values.
     * @param name The name of the new {@link Snake}.
     */
    public Snake(String name)
    {
        super(name, Snake.BASE_DAMAGE, Snake.BASE_HP, Snake.BASE_HP);
    }

    /**
     * Creates a new {@link Snake}.
     * @param name The name of the new {@link Snake}.
     * @param baseDamage The base damage value of the new {@link Snake}
     * @param maxHp The maximum hp value of the new {@link Snake}.
     * @param hp The hp value of the new {@link Snake}
     */
    public Snake(String name, int baseDamage, int maxHp, int hp)
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
