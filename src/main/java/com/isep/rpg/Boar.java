package com.isep.rpg;


public class Boar extends Enemy
{
    // Attributes
    public static final int BASE_HP = 30;
    public static final int BASE_DAMAGE = 8;

    // Constructors
    public Boar(String name)
    {
        super(name, Boar.BASE_HP, Boar.BASE_HP);
    }

    public Boar(String name, int hp, int baseDamage)
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
