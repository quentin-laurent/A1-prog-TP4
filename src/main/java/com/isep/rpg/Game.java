package com.isep.rpg;

import com.isep.utils.InputParser;
import com.isep.utils.OutputManager;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Collection;
public class Game
{
    // Attributes
    private InputParser inputParser;
    private OutputManager outputManager;
    private Collection<Hero> heroes;
    private Collection<Enemy> enemies;
    private int heroCount;

    // Constructor

    /**
     * Creates a new Game with the provided InputParser
     * @param inputParser The input parser to be used in the Game
     */
    public Game(InputParser inputParser, OutputManager outputManager)
    {
        this.inputParser = inputParser;
        this.outputManager = outputManager;
        this.heroes = new ArrayList<Hero>();
        this.enemies = new ArrayList<Enemy>();
    }

    // Methods

    /**
     * Creates the instances of the heroes that are going to participate in the game
     */
    private void initializeHeroes() throws ExecutionControl.NotImplementedException
    {
        // Initializing the number of heroes
        this.heroCount = this.inputParser.chooseHeroCount();

        // Initializing heroes
        String heroClass;
        String heroName;
        Hero hero;
        for(int i = 0; i < this.heroCount; i++)
        {
            System.out.printf("==== Hero n°%d ====%n", i+1);
            heroClass = this.inputParser.chooseHeroClass();
            heroName = this.inputParser.chooseCombatantName();

            switch (heroClass)
            {
                case "hunter":
                    hero = new Hunter(heroName);
                    hero.items.put(new Arrow("Wooden Arrow", 5), 10);
                    this.heroes.add(hero);
                    break;
                case "warrior":
                    hero = new Warrior(heroName);
                    this.heroes.add(hero);
                    break;
                case "mage":
                    hero = new Mage(heroName);
                    this.heroes.add(hero);
                    break;
                case "healer":
                    hero = new Healer(heroName);
                    this.heroes.add(hero);
                    break;
                default:
                    throw new RuntimeException("Got an invalid hero class while creating heroes");
            }
        }
    }
}
