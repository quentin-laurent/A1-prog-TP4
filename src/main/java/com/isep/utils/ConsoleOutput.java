package com.isep.utils;

import com.isep.rpg.Combatant;
import com.isep.rpg.Enemy;
import com.isep.rpg.Game;
import com.isep.rpg.Hero;

import java.util.Collection;

public class ConsoleOutput implements OutputManager
{
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

    @Override
    public void displayEnemies(Collection<Enemy> enemies)
    {
        StringBuilder s = new StringBuilder("[");
        int i = 0;
        for(Enemy enemy: enemies)
        {
            s.append(String.format("[%d] ", i));
            s.append(enemy.toString());
            s.append(" | ");
            i++;
        }
        int lastIndex = s.length();
        s.replace(lastIndex - 3, lastIndex, "]");

        System.out.print(s);
    }

    @Override
    public void displayStageTitle(int stageNumber)
    {
        System.out.printf("==== STAGE %d ====%n", stageNumber);
    }

    @Override
    public void displayEndScreen()
    {
        System.out.println("==== END ====");
    }

    @Override
    public void displayHero(Hero hero)
    {
        System.out.printf("**** Now playing: %s (%d/%d) [%s]****%n",hero.getName(), hero.getHp(), hero.getMaxHP(),hero.getClass().getSimpleName());
    }

    @Override
    public void displayAttackMessage(Combatant attacker, Combatant target, int damage)
    {
        System.out.printf("%s attacks %s !%n", attacker.getName(), target.getName());
        if(target.isAlive())
            System.out.printf("%s: -%dHP%n", target.getName(), damage);
        else
            System.out.printf("%s: -%dHP (dead)%n", target.getName(), damage);
    }

    @Override
    public void displayDefendMessage(Combatant combatant, int damageReductionPercentage)
    {
        if(damageReductionPercentage != 0)
            System.out.printf("%s reduced the damage by %d%% !%n", combatant.getName(), damageReductionPercentage);
    }
}
