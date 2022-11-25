package com.isep.rpg;


public class Snake extends Enemy
{
    // Attributes
    public static final int BASE_HP = 15;
    public static final int BASE_DAMAGE = 30;

    // Constructor
    public Snake(String name)
    {
        super(name, Snake.BASE_HP, Snake.BASE_HP);
    }

    public Snake(String name, int hp, int baseDamage)
    {
        super(name, hp, baseDamage);
    }

    // Methods
    @Override
    public int attack(Hero hero)
    {
        if(hero.isAlive())
            return hero.applyDamage(BASE_DAMAGE);
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
