package com.isep.utils;

import com.isep.rpg.Combatant;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.items.Item;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Map;

/**
 * An implementation of the {@link InputParser} interface that uses a graphical user interface (a.k.a a GUI)
 * to parse the inputs of the player.
 */
public class GUIParser implements InputParser
{
    // Methods
    @Override
    public int chooseNumberOfStages() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public int chooseHeroCount() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public String chooseHeroClass() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public String chooseCombatantName() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public String chooseAction() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public String chooseUpgrade() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public Consumable chooseConsumable(Map<Item, Integer> items) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public Enemy chooseEnemyTarget(List<Enemy> enemies) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public Combatant chooseCombatantTarget(List<Combatant> combatants) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
