package com.isep.utils;

import com.isep.rpg.*;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.heroes.Hero;
import com.isep.rpg.heroes.SpellCaster;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.Item;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

/**
 * An interface used to display information about the actions happening in the {@link Game}.
 */
public interface OutputManager
{
    /**
     * Displays all the {@link Hero}es contained in the provided list.
     * @param heroes The list containing the {@link Hero}es to display.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayHeroes(List<Hero> heroes) throws ExecutionControl.NotImplementedException;

    /**
     * Displays all the {@link Enemy}s contained in the provided list.
     * @param enemies The list containing the {@link Enemy}s to display.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayEnemies(List<Enemy> enemies) throws ExecutionControl.NotImplementedException;

    /**
     * Displays the title of a stage.
     * @param stageNumber The number of the stage.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayStageTitle(int stageNumber) throws ExecutionControl.NotImplementedException;

    /**
     * Displays the title of a round.
     * @param roundNumber The number of the round.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayRoundTitle(int roundNumber) throws ExecutionControl.NotImplementedException;

    /**
     * Displays the title of the "rewards" part of a stage.
     * @throws ExecutionControl.NotImplementedException
     */
    //TODO: rename method to displayLootTitle
    public void displayLootMessage() throws ExecutionControl.NotImplementedException;

    /**
     * Displays the title of the "upgrades" part of a stage.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayUpgradesTitle() throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message containing the information of the {@link Hero} being upgraded.
     * @param hero The {@link Hero} being upgraded.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayUpgradeMessage(Hero hero) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message containing the information of the {@link Hero} currently playing.
     * @param hero The {@link Hero} currently playing.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayHero(Hero hero) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message containing the information of the {@link Enemy} currently playing.
     * @param enemy The {@link Enemy} currently playing.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayEnemy(Enemy enemy) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message indicating who attacked who as well as the damage inflicted.
     * @param attacker The {@link Combatant} attacking.
     * @param target The {@link Combatant} being attacked.
     * @param damage The damage inflicted by the attacker to the target.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayAttackMessage(Combatant attacker, Combatant target, int damage) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message giving details on the cast spell (whether if it is an attack spell or a healing spell)
     * @param caster The {@link SpellCaster} who cast the spell.
     * @param target The {@link Combatant} targeted by the spell.
     * @param manaCost The amount of mana consumed by the spell.
     * @param damageOrHeal The damage inflicted if the spell is an attack spell or the healing applied if
     *                     the spell is a healing spell
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayCastSpellMessage(SpellCaster caster, Combatant target, int damageOrHeal, int manaCost) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message indicating the percentage of damage reduced by a defending {@link Combatant}.
     * @param combatant The {@link Combatant} defending itself.
     * @param damageReductionPercentage The damage reduction percentage.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayDefendMessage(Combatant combatant, int damageReductionPercentage) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message indicating the {@link Consumable} used and its effect.
     * @param target The {@link Combatant} consuming the {@link Consumable}.
     * @param consumable The {@link Consumable} used.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayConsumableUsed(Combatant target, Consumable consumable, int appliedEffectValue) throws ExecutionControl.NotImplementedException;

    /**
     * Displays a message containing information about the {@link Item} (and its quantity) awarded to a {@link Hero}.
     * @param hero The {@link Hero} receiving the {@link Item}.
     * @param item The {@link Item} awarded to the {@link Hero}.
     * @param quantity The {@link Item}'s quantity.
     * @throws ExecutionControl.NotImplementedException
     */
    //TODO: rename method to displayRewardMessage
    public void displayItemAddMessage(Hero hero, Item item, int quantity) throws ExecutionControl.NotImplementedException;

    /**
     * Displays the provided error message.
     * @param message The error message to display.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayErrorMessage(String message) throws ExecutionControl.NotImplementedException;

    /**
     * Displays the end screen of the {@link Game}.
     * @param victory A boolean indicating if the player won.
     * @throws ExecutionControl.NotImplementedException
     */
    public void displayEndScreen(boolean victory) throws ExecutionControl.NotImplementedException;
}
