package com.isep.utils;

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
     * Asks the user to provide the hero count though the standard input.
     * @return A non-zero positive integer representing the hero count.
     */
    @Override
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
}
