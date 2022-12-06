package com.isep.utils;

import com.isep.rpg.*;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Map;

public interface InputParser
{
    /**
     * Asks the user to provide the hero count though the standard input.
     * @return A non-zero positive integer representing the hero count.
     */
    public int chooseHeroCount() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the user to provide the hero name though the standard input.
     * @return A non-blank string representing the hero name.
     */
    public String chooseCombatantName() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the user to provide the hero class though the standard input.
     * @return A string representing the hero class.
     */
    public String chooseHeroClass() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the user to choose an action to perform.
     * Possibles choices are: attack, defend, consume
     * @return A string representing the chosen action
     */
    public String chooseAction() throws ExecutionControl.NotImplementedException;

    public Consumable chooseConsumable(Map<Item, Integer> items) throws ExecutionControl.NotImplementedException;

    public Enemy chooseEnemyTarget(List<Enemy> enemies) throws ExecutionControl.NotImplementedException;

    public Combatant chooseCombatantTarget(List<Combatant> combatants) throws ExecutionControl.NotImplementedException;
}
