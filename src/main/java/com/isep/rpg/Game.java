package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.Collection;
public class Game
{
    // Attributes
    private InputParser inputParser;
    private Collection<Combatant> combatants;
    private int heroCount;

    // Constructor

    /**
     * Creates a new Game with the provided InputParser
     * @param inputParser The input parser to be used in the Game
     */
    public Game(InputParser inputParser)
    {
        this.inputParser = inputParser;
        this.combatants = new ArrayList<Combatant>();
    }

    // Methods

    /**
     * Creates the instances of the heroes that are going to participate in the game
     */
    private void initializeHeroes()
    {
        // Initializing the number of heroes
        this.heroCount = this.inputParser.getHeroCount();

        // Initializing heroes
        String heroClass;
        String heroName;
        Hero hero;
        for(int i = 0; i < this.heroCount; i++)
        {
            System.out.printf("==== Hero n°%d ====%n", i);
            heroClass = this.inputParser.getHeroClass();
            heroName = this.inputParser.getCombatantName();

            switch (heroClass)
            {
                case "hunter":
                    hero = new Hunter(heroName);
                    hero.items.put(new Arrow("Wooden Arrow", 5), 10);
                    this.combatants.add(hero);
                    break;
                case "warrior":
                    hero = new Warrior(heroName);
                    this.combatants.add(hero);
                    break;
                case "mage":
                    hero = new Mage(heroName);
                    this.combatants.add(hero);
                    break;
                case "healer":
                    hero = new Healer(heroName);
                    this.combatants.add(hero);
                    break;
                default:
                    throw new RuntimeException("Got an invalid hero class while creating heroes");
            }
        }
    }
}
