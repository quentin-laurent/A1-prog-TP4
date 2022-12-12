package com.isep.rpg;

/**
 * A class representing a snake: a specific type of {@link Enemy}.
 * It is a relatively strong enemy that has low hp but high damage.
 */
public class Snake extends Enemy
{
    // Attributes
    public static final int BASE_HP = 15;
    public static final int BASE_DAMAGE = 30;

    // Constructors
    /**
     * Creates a new {@link Snake} with all values set to default.
     */
    public Snake()
    {
        super(Snake.class.getSimpleName(), Snake.BASE_DAMAGE, Snake.BASE_HP, Snake.BASE_HP);
    }

    /**
     * Creates a new {@link Snake} with the specified name and all values set to default.
     * @param name The name of the snake.
     */
    public Snake(String name)
    {
        super(name, Snake.BASE_DAMAGE, Snake.BASE_HP, Snake.BASE_HP);
    }

    /**
     * Creates a new {@link Snake}.
     * @param name The name of the snake.
     * @param baseDamage The base damage inflicted by the snake on each attack.
     * @param maxHp The maximum hp of the snake.
     * @param hp The current hp of the snake.
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
