package com.isep.rpg;


public class Snake extends Enemy
{
    // Attributes
    public static final int BASE_HP = 15;
    public static final int BASE_DAMAGE = 30;

    // Constructor
    public Snake(String name, int hp, int baseDamage)
    {
        super(name, hp, baseDamage);
    }

    // Methods
    @Override
    public void attack(Hero hero)
    {
        if(hero.isAlive())
            hero.applyDamage(BASE_DAMAGE);
    }
}
