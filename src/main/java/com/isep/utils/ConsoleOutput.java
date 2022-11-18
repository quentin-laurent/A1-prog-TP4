package com.isep.utils;

import com.isep.rpg.Enemy;
import com.isep.rpg.Game;
import com.isep.rpg.Hero;

import java.util.Collection;

public class ConsoleOutput implements OutputManager
{
    /**
     * Displays the list of the {@link Hero}es in the {@link Game}.
     * For each {@link Hero}, indicates if it's dead.
     * @param heroes The list of {@link Hero}es of the {@link Game}.
     */
    @Override
    public void displayHeroes(Collection<Hero> heroes)
    {
        StringBuilder s = new StringBuilder("[");
        for(Hero hero: heroes)
        {
            s.append(hero.toString());
            s.append(" | ");
        }
        int lastIndex = s.length();
        s.replace(lastIndex - 3, lastIndex, "]");

        System.out.println(s);
    }

    /**
     * Displays the list of all {@link Enemy} instances in the {@link Game}.
     * For each {@link Enemy}, indicates if it's dead.
     * @param enemies The list of all {@link Enemy} instances in the {@link Game}.
     */
    @Override
    public void displayEnemies(Collection<Enemy> enemies)
    {
        StringBuilder s = new StringBuilder("[");
        for(Enemy enemy: enemies)
        {
            s.append(enemy.toString());
            s.append(" | ");
        }
        int lastIndex = s.length();
        s.replace(lastIndex - 3, lastIndex, "]");

        System.out.println(s);
    }
}
