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
        super(Snake.class.getSimpleName(), Snake.BASE_HP, Snake.BASE_HP);
    }

    /**
     * Creates a new {@link Snake} using all default values.
     * @param name The name of the new {@link Snake}.
     */
    public Snake(String name)
    {
        super(name, Snake.BASE_HP, Snake.BASE_HP);
    }

    /**
     * Creates a new {@link Snake}.
     * @param name The name of the new {@link Snake}.
     * @param maxHp The maximum hp value of the new {@link Snake}.
     * @param hp The hp value of the new {@link Snake}
     */
    public Snake(String name, int maxHp, int hp)
    {
        super(name, maxHp, hp);
    }

    // Methods
    @Override
    public int[] attack(Hero hero)
    {
        if(hero.isAlive())
            return hero.applyDamage(BASE_DAMAGE);
        return new int[]{0, 0};
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
