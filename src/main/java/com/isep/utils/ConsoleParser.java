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

    private static final int NAME_CHAR_LIMIT = 20;

    // Constructor
    public ConsoleParser()
    {
        this.sc = new Scanner(System.in);
    }

    // Methods
    @Override
    public int chooseNumberOfStages() throws ExecutionControl.NotImplementedException
    {
        System.out.print("Provide the number of stages: ");
        int numberOfStages = this.getInt("Provide the number of stages");

        while(numberOfStages <= 0)
        {
            System.out.println("You must play at least one stage !");
            System.out.print("Provide the number of stages: ");
            numberOfStages = this.getInt("Provide the number of stages");
        }

        return numberOfStages;
    }

    @Override
    public int chooseHeroCount()
    {
        System.out.print("Provide the number of heroes: ");
        int heroCount = this.getInt("Provide the number of heroes");

        while(heroCount <= 0)
        {
            System.out.println("You must use at least one hero !");
            System.out.print("Provide the number of heroes: ");
            heroCount = this.getInt("Provide the number of heroes");
        }

        return heroCount;
    }

    @Override
    public String chooseCombatantName()
    {
        String name;
        boolean repeat = true;
        do
        {
            repeat = false;
            System.out.print("Select a name: ");
            name = this.getString();

            if(name.isBlank())
            {
                System.out.println("You must choose a non-blank name !");
                repeat = true;
            }
            else if(name.length() > NAME_CHAR_LIMIT)
            {
                System.out.println("Name must not exceed 20 characters !");
                repeat = true;
            }
        } while(repeat);

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
        s.append("\nChoose an upgrade: ");

        System.out.print(s);
        int index = this.getInt("Choose an upgrade");

        while(index < 0 || index >= upgrades.size())
        {
            System.out.println("You must select a valid upgrade (use the number between the brackets) !");
            System.out.print(s);
            index = this.getInt("Choose an upgrade");
        }

        return upgrades.get(index);
    }

    @Override
    public Consumable chooseConsumable(Map<Item, Integer> items)
    {
        // Building the items list to be displayed
        StringBuilder s = new StringBuilder("Inventory:\n");
        int i = 0;
        for(var entry: items.entrySet())
        {
            s.append(String.format("[%d] %s x%d%n", i, entry.getKey().toString(), entry.getValue()));
            i++;
        }

        int index;
        System.out.print(s);
        System.out.print("\nChoose an item: ");
        index = this.getInt("Choose an item");

        while(index < 0 || index >= items.size())
        {
            System.out.println("You must choose a valid item (use the number between the brackets) !");
            System.out.print(s);
            System.out.print("\nChoose an item: ");
            index = this.getInt("Choose an item");
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
        StringBuilder s = new StringBuilder("\nAvailable targets:\n");
        int i = 0;
        for(Enemy enemy: enemies)
        {
            s.append(String.format("[%d] %s%n", i, enemy.toString()));
            i++;
        }

        int index;
        System.out.print(s);
        System.out.print("\nChoose a target: ");
        index = this.getInt("Choose a target");

        while(index < 0 || index >= enemies.size())
        {
            System.out.println("You must choose a valid target (use the number between the brackets) !");
            System.out.print(s);
            System.out.print("\nChoose a target: ");
            index = this.getInt("Choose a target");
        }

        return enemies.get(index);
    }

    @Override
    public Combatant chooseCombatantTarget(List<Combatant> combatants)
    {
        // Building the combatants list to be displayed
        StringBuilder s = new StringBuilder("\nAvailable targets:\n");
        int i = 0;
        for(Combatant combatant: combatants)
        {
            s.append(String.format("[%d] %s%n", i, combatant.toString()));
            i++;
        }

        int index;
        System.out.print(s);
        System.out.print("\nChoose a target: ");
        index = this.getInt("Choose a target");

        while(index < 0 || index >= combatants.size())
        {
            System.out.println("You must choose a valid target (use the number between the brackets) !");
            System.out.print(s);
            System.out.print("\nChoose a target: ");
            index = this.getInt("Choose a target");
        }

        return combatants.get(index);
    }

    /**
     * Asks the player to provide an integer though the standard input.
     * This checks for {@link InputMismatchException}.
     * @return The integer provided by the player.
     */
    private int getInt(String messageWhenMismatch)
    {
        boolean validInput = false;
        int value = 0;

        // Looping until an integer is provided
        do {
            try
            {
                value = this.sc.nextInt();
                // Consuming the \n char so it doesn't break the next call for nextLine()
                this.sc.nextLine();
                validInput = true;
            }
            catch (InputMismatchException e)
            {
                //System.out.print("/!\\ Invalid value (not a number).\nPlease provide a number: ");
                System.out.printf("/!\\ Invalid value (not a number)%n%s: ", messageWhenMismatch);
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
