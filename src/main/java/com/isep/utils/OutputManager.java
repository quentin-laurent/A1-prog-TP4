package com.isep.utils;

import com.isep.rpg.*;
import jdk.jshell.spi.ExecutionControl;

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
     * Displays the title of the current round
     * @param roundNumber The number of the current round
     */
    public void displayRoundTitle(int roundNumber);

    public void displayLootMessage();

    public void displayUpgradesTitle();

    public void displayUpgradeMessage(Hero hero);

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

    /**
     * Displays a message giving details on the cast spell (whether it is an attack spell or a heal spell)
     * @param caster The {@link SpellCaster} who cast the spell
     * @param target The {@link Combatant} being targeted by the spell
     * @param manaCost The amount of mana consumed by the spell
     * @param damageOrHeal The damage inflicted if the spell is an attack spell or the heal applied is a healing spell
     */
    public void displayCastSpellMessage(SpellCaster caster, Combatant target, int damageOrHeal, int manaCost);

    // TODO: integrate this into displayAttackMessage()
    // TODO: add @Deprecated
    /**
     * Displays a message indicating the damage reduction percentage of a defending {@link Combatant}
     * @param combatant The {@link Combatant} defending itself
     * @param damageReductionPercentage The percentage of damage being reduced
     */
    public void displayDefendMessage(Combatant combatant, int damageReductionPercentage);

    /**
     * Displays a message indicating the {@link Consumable} used and its effect
     * @param target The {@link Combatant} consuming the {@link Consumable}
     * @param consumable The {@link Consumable} used
     */
    public void displayConsumableUsed(Combatant target, Consumable consumable);

    public void displayItemAddMessage(Hero hero, Item item, int quantity);

    /**
     * Displays a message indicating that the inventory of the {@link Hero} currently playing is empty.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayErrorMessage(String message) throws ExecutionControl.NotImplementedException;

    /**
     * Displays the end screen of the current {@link Game}
     */
    public void displayEndScreen();
}
