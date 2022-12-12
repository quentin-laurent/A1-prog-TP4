package com.isep.utils;

import com.isep.rpg.*;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.heroes.Hero;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.Item;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Map;

/**
 * An interface used to parse the player's inputs.
 */
public interface InputParser
{
    /**
     * Asks the player to provide the number of heroes to use in the {@link Game}.
     * @return The number of heroes chosen by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public int chooseHeroCount() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to provide a {@link Combatant}'s name.
     * @return The name chosen by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public String chooseCombatantName() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to provide a {@link Hero} class.
     * @return The class chosen by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public String chooseHeroClass() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to choose an action to perform.
     * @return The actions chosen by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public String chooseAction() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to choose an upgrade to apply to a {@link Hero};
     * @return The upgrade chosen by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public String chooseUpgrade() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to select a {@link Consumable} in the provided inventory.
     * @param items The inventory to select a {@link Consumable} from.
     * @return The {@link Consumable} selected by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public Consumable chooseConsumable(Map<Item, Integer> items) throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to select a target from the provided list of {@link Enemy}s.
     * @param enemies The list of {@link Enemy}s to select a target from.
     * @return The {@link Enemy} selected by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public Enemy chooseEnemyTarget(List<Enemy> enemies) throws ExecutionControl.NotImplementedException;

    /**
     * Asks the player to select a target from the provided list of {@link Combatant}s.
     * @param combatants The list of {@link Combatant}s to select a target from.
     * @return The {@link Combatant} selected by the player.
     * @throws ExecutionControl.NotImplementedException
     */
    public Combatant chooseCombatantTarget(List<Combatant> combatants) throws ExecutionControl.NotImplementedException;
}
