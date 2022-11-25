package com.isep.utils;

import com.isep.rpg.Consumable;
import com.isep.rpg.Enemy;
import com.isep.rpg.Item;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;

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

    /**
     * Asks the user to provide the hero count through the standard input.
     * @return A non-zero positive integer representing the hero count.
     */
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

    /**
     * Asks the user to provide a name for a combattant through the standard input.
     * @return A string representing the combattant name.
     */
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

    /**
     * Asks the user to provide a valid hero class through the standard input.
     * @return A string representing the hero class.
     */
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
        validActions.add("defend");
        validActions.add("consume");

        System.out.print("Select an action [Attack, Defend, Consume]: ");
        String action = this.getString();

        while(!validActions.contains(action.toLowerCase()))
        {
            System.out.println("You must select a valid action !");
            System.out.print("Select an action [Attack, Defend, Consume]: ");
            action = this.getString();
        }

        return action.toLowerCase();
    }

    @Override
    public Consumable chooseConsumable(Map<Item, Integer> items) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
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
            System.out.println("[DEBUG] i= " + i);
            System.out.println("[DEBUG] index= " + index);
            System.out.println("You must choose a valid target (use the number between the brackets) !");
            System.out.printf("Choose a target %s:%n", s.toString());
            index = this.getInt();
        }

        return enemies.get(index);
    }

    public void closeScanner()
    {
        this.sc.close();
    }

    /**
     * Gets an integer provided by the user though the standard input
     * @return An integer provided though the standard input
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
     * Gets a string provided by the user though the standard input
     * @return A string provided though the standard input
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
