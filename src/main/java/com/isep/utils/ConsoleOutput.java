package com.isep.utils;

import com.isep.rpg.Combatant;
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

    /**
     * Displays the title of the current stage
     * @param stageNumber The number of the current stage
     */
    @Override
    public void displayStageTitle(int stageNumber)
    {
        System.out.printf("==== STAGE %d ====%n", stageNumber);
    }

    /**
     * Displays the end screen of the current {@link Game}
     */
    @Override
    public void displayEndScreen()
    {
        System.out.println("==== END ====");
    }

    /**
     * Displays a message containing the information of the {@link Hero} currently playing
     * @param hero The {@link Hero} currently plqying
     */
    public void displayHero(Hero hero)
    {
        System.out.printf("**** Now playing: %s (%d/%d) [%s]****%n",hero.getName(), hero.getHp(), hero.getMaxHP(),hero.getClass().getSimpleName());
    }

    public void displayAttackMessage(Combatant attacker, Combatant target, int damage)
    {
        System.out.printf("%s attacks %s !%n", attacker.getName(), target.getName());
        if(target.isAlive())
            System.out.printf("%s: -%dHP%n", target.getName(), damage);
        else
            System.out.printf("%s: -%dHP (dead)%n", target.getName(), damage);
    }
}
