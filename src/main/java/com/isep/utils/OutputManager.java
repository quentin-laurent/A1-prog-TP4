package com.isep.utils;

import com.isep.rpg.Combatant;
import com.isep.rpg.Enemy;
import com.isep.rpg.Hero;

import java.util.Collection;

public interface OutputManager
{
    public void displayHeroes(Collection<Hero> heroes);

    public void displayEnemies(Collection<Enemy> enemies);

    public void displayStageTitle(int stageNumber);

    public void displayHero(Hero hero);

    public void displayAttackMessage(Combatant attacker, Combatant target, int damage);

    public void displayEndScreen();
}
