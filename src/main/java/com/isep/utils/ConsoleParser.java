package com.isep.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
     * Asks the user to provide the hero count though the standard input.
     * @return A non-zero positive integer representing the hero count.
     */
    public int getHeroCount()
    {
        System.out.println("Provide the number of heroes:");
        int heroCount = this.getInt();

        while(heroCount < 0)
        {
            System.out.println("You must use at least one hero !");
            System.out.println("Provide the number of heroes:");
            heroCount = this.getInt();
        }

        return heroCount;
    }

    public String getHeroName()
    {
        System.out.println("Select a name:");
        String name = this.getString();

        while(name.isBlank())
        {
            System.out.println("You must choose a non-blank name !");
            System.out.println("Select a name:");
            name = this.getString();
        }

        return name;
    }

    public String getHeroClass()
    {
        ArrayList<String> validClasses = new ArrayList<>();
        validClasses.add("hunter");
        validClasses.add("warrior");
        validClasses.add("mage");
        validClasses.add("healer");

        System.out.println("Select a class [Hunter, Warrior, Mage, Healer]:");
        String heroClass = this.getString();

        while(!validClasses.contains(heroClass.toLowerCase()))
        {
            System.out.println("You must select a valid class !");
            System.out.println("Select a class [Hunter, Warrior, Mage, Healer]:");
            heroClass = this.getString();
        }

        return heroClass.toLowerCase();
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
