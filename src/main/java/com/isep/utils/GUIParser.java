package com.isep.utils;

import com.isep.rpg.Consumable;
import com.isep.rpg.Enemy;
import com.isep.rpg.Item;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Map;

public class GUIParser implements InputParser
{
    // Methods
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
    public Consumable chooseConsumable(Map<Item, Integer> items) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public Enemy chooseEnemyTarget(List<Enemy> enemies) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
