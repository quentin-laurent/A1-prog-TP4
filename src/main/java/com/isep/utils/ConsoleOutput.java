package com.isep.utils;

import com.isep.rpg.*;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.heroes.Healer;
import com.isep.rpg.heroes.Hero;
import com.isep.rpg.heroes.Mage;
import com.isep.rpg.heroes.SpellCaster;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.Item;
import com.isep.rpg.items.consumables.Potion;

import java.util.List;

/**
 * An implementation of the {@link OutputManager} interface that uses the standard output (a.k.a console or terminal)
 * to display information about the actions happening in the {@link Game}.
 */
public class ConsoleOutput implements OutputManager
{
    @Override
    public void displayHeroes(List<Hero> heroes)
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
    public void displayEnemies(List<Enemy> enemies)
    {
        StringBuilder s = new StringBuilder("Enemies: [");
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

        System.out.println(s);
    }

    @Override
    public void displayStageTitle(int stageNumber)
    {
        String s =
                "################################\n" +
                "#            STAGE %d           #\n" +
                "################################%n";
        System.out.printf(s, stageNumber);
    }

    @Override
    public void displayRoundTitle(int roundNumber)
    {
        String s =
                "================================\n" +
                "|            ROUND %d           |\n" +
                "================================%n";
        System.out.printf(s, roundNumber);
    }

    @Override
    public void displayLootTitle()
    {
        String s =
                "################################\n" +
                "#            REWARDS           #\n" +
                "################################\n";
        System.out.println(s);
    }

    @Override
    public void displayUpgradesTitle()
    {
        String s =
                "################################\n" +
                "#           UPGRADES           #\n" +
                "################################";
        System.out.println(s);
    }

    @Override
    public void displayUpgradeMessage(Hero hero)
    {
        StringBuilder s = new StringBuilder();
        s.append("************************************************\n");
        s.append("*                   UPGRADING                  *\n");
        s.append("*                                              *\n");

        String heroString = hero.toString();
        int spaces = 46 - heroString.length();
        int spacesLeft = spaces / 2;
        int spacesRight = spaces - spacesLeft;

        s.append("*");
        s.append(" ".repeat(Math.max(0, spacesLeft)));
        s.append(heroString);
        s.append(" ".repeat(Math.max(0, spacesRight)));
        s.append("*\n");

        s.append("************************************************\n");

        System.out.println(s);
    }

    @Override
    public void displayEndScreen(boolean victory)
    {
        String s;
        if(victory)
        {
            s =
                    "################################\n" +
                    "#                              #\n" +
                    "#            VICTORY           #\n" +
                    "#                              #\n" +
                    "################################";
        }
        else
            s =
                    "################################\n" +
                    "#                              #\n" +
                    "#            DEFEAT            #\n" +
                    "#                              #\n" +
                    "################################";
        System.out.println(s);
    }

    @Override
    public void displayHero(Hero hero)
    {
        StringBuilder s = new StringBuilder();
        s.append("************************************************\n");
        s.append("*                  NOW PLAYING                 *\n");
        s.append("*                                              *\n");

        String heroString = hero.toString();
        int spaces = 46 - heroString.length();
        int spacesLeft = spaces / 2;
        int spacesRight = spaces - spacesLeft;

        s.append("*");
        s.append(" ".repeat(Math.max(0, spacesLeft)));
        s.append(heroString);
        s.append(" ".repeat(Math.max(0, spacesRight)));
        s.append("*\n");

        s.append("************************************************\n");

        System.out.println(s);
    }

    @Override
    public void displayEnemy(Enemy enemy)
    {
        StringBuilder s = new StringBuilder();
        s.append("************************************************\n");
        s.append("*                  NOW PLAYING                 *\n");
        s.append("*                                              *\n");

        String enemyString = enemy.toString();
        int spaces = 46 - enemyString.length();
        int spacesLeft = spaces / 2;
        int spacesRight = spaces - spacesLeft;

        s.append("*");
        s.append(" ".repeat(Math.max(0, spacesLeft)));
        s.append(enemyString);
        s.append(" ".repeat(Math.max(0, spacesRight)));
        s.append("*\n");

        s.append("************************************************\n");

        System.out.println(s);
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
    public void displayCastSpellMessage(SpellCaster caster, Combatant target, int damageOrHeal, int manaCost)
    {
        if(caster instanceof Mage)
        {
            System.out.printf("%s attacks %s with magic !%n", caster.getName(), target.getName());
            System.out.printf("%s: -%dHP%n", target.getName(), damageOrHeal);
        }
        else if(caster instanceof Healer)
        {
            System.out.printf("%s heals %s with magic !%n", caster.getName(), target.getName());
            System.out.printf("%s: +%dHP%n", target.getName(), damageOrHeal);
        }
        System.out.printf("%s: -%d Mana%n", caster.getName(), manaCost);
    }

    @Override
    public void displayDefendMessage(Combatant combatant, int damageReductionPercentage)
    {
        if(damageReductionPercentage != 0)
            System.out.printf("%s reduced the damage by %d%% !%n", combatant.getName(), damageReductionPercentage);
    }

    @Override
    public void displayConsumableUsed(Combatant target, Consumable consumable, int appliedEffectValue)
    {
        System.out.printf("%s used %s !%n", target.getName(), consumable.getName());
        if(consumable instanceof Food)
            System.out.printf("%s: +%dHP%n", target.getName(), appliedEffectValue);
        else if(consumable instanceof Potion)
            System.out.printf("%s: +%d Mana%n", target.getName(), appliedEffectValue);
    }

    @Override
    public void displayRewardMessage(Hero hero, Item item, int quantity)
    {
        System.out.printf("%s found %d %s !%n", hero.getName(), quantity, item.getName());
    }

    @Override
    public void displayErrorMessage(String message)
    {
        System.out.println(message);
    }
}
