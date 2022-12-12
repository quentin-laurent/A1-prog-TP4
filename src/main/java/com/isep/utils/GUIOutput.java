package com.isep.utils;

import com.isep.rpg.*;
import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;

/**
 * An implementation of the {@link OutputManager} interface that uses a graphical user interface (a.k.a a GUI)
 * to display information about the actions happening in the {@link Game}.
 */
public class GUIOutput implements OutputManager
{
    @Override
    public void displayHeroes(Collection<Hero> heroes) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayEnemies(Collection<Enemy> enemies) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayStageTitle(int stageNumber) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayRoundTitle(int roundNumber) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayLootMessage() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayUpgradesTitle() throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayUpgradeMessage(Hero hero) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayHero(Hero hero) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayEnemy(Enemy enemy) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayAttackMessage(Combatant attacker, Combatant target, int damage) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayCastSpellMessage(SpellCaster caster, Combatant target, int damageOrHeal, int manaCost) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayDefendMessage(Combatant combatant, int damageReductionPercentage) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayConsumableUsed(Combatant target, Consumable consumable, int appliedEffectValue) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayItemAddMessage(Hero hero, Item item, int quantity) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayErrorMessage(String message) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void displayEndScreen(boolean victory) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }
}
