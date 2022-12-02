package com.isep.utils;

import com.isep.rpg.Combatant;
import com.isep.rpg.Enemy;
import com.isep.rpg.Game;
import com.isep.rpg.Hero;

import java.util.Collection;

public interface OutputManager
{
    /**
     * Displays the list of the {@link Hero}es in the {@link Game}.
     * For each {@link Hero}, indicates if it's dead.
     * @param heroes The list of {@link Hero}es of the {@link Game}.
     */
    public void displayHeroes(Collection<Hero> heroes);

    /**
     * Displays the list of all {@link Enemy} instances in the {@link Game}.
     * For each {@link Enemy}, indicates if it's dead.
     * @param enemies The list of all {@link Enemy} instances in the {@link Game}.
     */
    public void displayEnemies(Collection<Enemy> enemies);

    /**
     * Displays the title of the current stage
     * @param stageNumber The number of the current stage
     */
    public void displayStageTitle(int stageNumber);

    /**
     * Displays a message containing the information of the {@link Hero} currently playing
     * @param hero The {@link Hero} currently plqying
     */
    public void displayHero(Hero hero);

    /**
     * Displays a message containing the information of the {@link Enemy} currently playing
     * @param enemy The {@link Enemy} currently plqying
     */
    public void displayEnemy(Enemy enemy);

    /**
     * Displays a message indicating who attacked who and the damage inflicted
     * @param attacker The {@link Combatant} attacking
     * @param target The {@link Combatant} being attacked
     * @param damage The damage inflicted
     */
    public void displayAttackMessage(Combatant attacker, Combatant target, int damage);

    // TODO: integrate this into displayAttackMessage()
    // TODO: add @Deprecated
    /**
     * Displays a message indicating the damage reduction percentage of a defending {@link Combatant}
     * @param combatant The {@link Combatant} defending itself
     * @param damageReductionPercentage The percentage of damage being reduced
     */
    public void displayDefendMessage(Combatant combatant, int damageReductionPercentage);

    /**
     * Displays the end screen of the current {@link Game}
     */
    public void displayEndScreen();
}
