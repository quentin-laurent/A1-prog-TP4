package com.isep.utils;

import com.isep.rpg.*;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.Item;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;

/**
 * An implementation of the {@link InputParser} interface that uses the standard input (a.k.a console or terminal)
 * to parse the inputs of the player.
 */
public class ConsoleParser implements InputParser
{
    // Attributes
    private Scanner sc;

    // Constructor
    public ConsoleParser()
    {
        this.sc = new Scanner(System.in);
    }

    // Methods
    @Override
    public int chooseHeroCount()
    {
        System.out.print("Provide the number of heroes: ");
        int heroCount = this.getInt();

        while(heroCount <= 0)
        {
            System.out.println("You must use at least one hero !");
            System.out.print("Provide the number of heroes: ");
            heroCount = this.getInt();
        }

        return heroCount;
    }

    @Override
    public String chooseCombatantName()
    {
        System.out.print("Select a name: ");
        String name = this.getString();

        while(name.isBlank())
        {
            System.out.println("You must choose a non-blank name !");
            System.out.print("Select a name: ");
            name = this.getString();
        }

        return name;
    }

    @Override
    public String chooseHeroClass()
    {
        ArrayList<String> validClasses = new ArrayList<>();
        validClasses.add("hunter");
        validClasses.add("warrior");
        validClasses.add("mage");
        validClasses.add("healer");

        System.out.print("Select a class [Hunter, Warrior, Mage, Healer]: ");
        String heroClass = this.getString();

        while(!validClasses.contains(heroClass.toLowerCase()))
        {
            System.out.println("You must select a valid class !");
            System.out.print("Select a class [Hunter, Warrior, Mage, Healer]: ");
            heroClass = this.getString();
        }

        return heroClass.toLowerCase();
    }

    @Override
    public String chooseAction()
    {
        ArrayList<String> validActions = new ArrayList<String>();
        validActions.add("attack");
        validActions.add("spell");
        validActions.add("defend");
        validActions.add("consume");

        System.out.print("Select an action [Attack, Spell, Defend, Consume]: ");
        String action = this.getString();

        while(!validActions.contains(action.toLowerCase()))
        {
            System.out.println("You must select a valid action !");
            System.out.print("Select an action [Attack, Spell, Defend, Consume]: ");
            action = this.getString();
        }

        return action.toLowerCase();
    }

    @Override
    public String chooseUpgrade()
    {
        ArrayList<String> upgrades = new ArrayList<String>();
        upgrades.add("increaseBaseDamage");
        upgrades.add("increaseMaxHp");
        upgrades.add("increaseSpellDamage");
        upgrades.add("increaseSpellHeal");
        upgrades.add("decreaseManaCost");

        StringBuilder s = new StringBuilder("Upgrades available:\n");
        s.append("[0] Increase your base damage by 10%\n");
        s.append("[1] Increase your maximum hp by 15%\n");
        s.append("[2] Increase the damage of your spells by 10%\n");
        s.append("[3] Increase the heal of your spells by 15%\n");
        s.append("[4] Decrease the mana cost of your spells by 10%\n");
        s.append("Choose an upgrade: ");

        System.out.print(s);
        int index = this.getInt();

        while(index < 0 || index >= upgrades.size())
        {
            System.out.println("You must select a valid upgrade (use the number between the brackets) !");
            System.out.print(s);
            index = this.getInt();
        }

        return upgrades.get(index);
    }

    @Override
    public Consumable chooseConsumable(Map<Item, Integer> items)
    {
        // Building the items list to be displayed
        StringBuilder s = new StringBuilder("[");
        int i = 0;
        for(var entry: items.entrySet())
        {
            s.append(String.format("[%d] %s (qty: %d) | ", i, entry.getKey().toString(), entry.getValue()));
            i++;
        }

        int lastIndex = s.length();
        s.replace(lastIndex - 3, lastIndex, "]");

        int index;
        System.out.printf("Choose an item %s:%n", s.toString());
        index = this.getInt();

        while(index < 0 || index >= items.size())
        {
            System.out.println("You must choose a valid item (use the number between the brackets) !");
            System.out.printf("Choose an item %s:%n", s.toString());
            index = this.getInt();
        }

        // This is not ideal because entries are not ordered in a HashMap
        // However , the order of the entries should not change between the printed output at the beginning
        // of this method and the selection below.
        int j = 0;
        for(var entry: items.entrySet())
        {
            if(index == j)
            {
                Item item = entry.getKey();
                if(item instanceof Consumable)
                    return (Consumable) item;
                else
                {
                    System.out.println("You must choose a consumable item !");
                    this.chooseConsumable(items);
                }
            }
            j++;
        }
        throw new RuntimeException("Couldn't find the requested item in the Items Map (index is out of bounds).");
    }

    @Override
    public Enemy chooseEnemyTarget(List<Enemy> enemies) throws ExecutionControl.NotImplementedException
    {
        // Building the enemies list to be displayed
        StringBuilder s = new StringBuilder("[");
        int i = 0;
        for(Enemy enemy: enemies)
        {
            s.append(String.format("[%d] %s (%d/%d) (%s) | ", i, enemy.getName(), enemy.getHp(), enemy.getMaxHP(), enemy.getClass().getSimpleName()));
            i++;
        }
        int lastIndex = s.length();
        s.replace(lastIndex - 3, lastIndex, "]");

        int index;
        System.out.printf("Choose a target %s:%n", s.toString());
        index = this.getInt();

        while(index < 0 || index >= enemies.size())
        {
            System.out.println("You must choose a valid target (use the number between the brackets) !");
            System.out.printf("Choose a target %s:%n", s.toString());
            index = this.getInt();
        }

        return enemies.get(index);
    }

    @Override
    public Combatant chooseCombatantTarget(List<Combatant> combatants)
    {
        // Building the combatants list to be displayed
        StringBuilder s = new StringBuilder("[");
        int i = 0;
        for(Combatant combatant: combatants)
        {
            s.append(String.format("[%d] %s (%d/%d) (%s) | ", i, combatant.getName(), combatant.getHp(), combatant.getMaxHP(), combatant.getClass().getSimpleName()));
            i++;
        }
        int lastIndex = s.length();
        s.replace(lastIndex - 3, lastIndex, "]");

        int index;
        System.out.printf("Choose a target %s:%n", s.toString());
        index = this.getInt();

        while(index < 0 || index >= combatants.size())
        {
            System.out.println("You must choose a valid target (use the number between the brackets) !");
            System.out.printf("Choose a target %s:%n", s.toString());
            index = this.getInt();
        }

        return combatants.get(index);
    }

    //TODO: to remove. this is not necessary as this instance will die as soon as the game ends
    public void closeScanner()
    {
        this.sc.close();
    }

    /**
     * Asks the player to provide an integer though the standard input.
     * This checks for {@link InputMismatchException}.
     * @return The integer provided by the player.
     */
    private int getInt()
    {
        boolean validInput = false;
        int value = 0;

        // Looping until an integer is provided
        do {
            try
            {
                value = this.sc.nextInt();
                // Consumming the \n char so it doesn't break the next call for nextLine()
                this.sc.nextLine();
                validInput = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("/!\\ Invalid value (not a number).\nPlease provide a number:");
                sc.nextLine();
            }
        } while(!validInput);

        return value;
    }

    /**
     * Asks the player to provide a {@link String} though the standard input.
     * This checks for {@link InputMismatchException}.
     * @return The String provided by the player.
     */
    private String getString()
    {
        boolean validInput = false;
        String s = null;

        // Looping until a string is provided
        do {
            try
            {
                s = this.sc.nextLine();
                validInput = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("/!\\ Invalid value (not a string).\nPlease provide a string:");
                sc.nextLine();
            }
        } while(!validInput);

        return s;
    }
}
