package com.isep.rpg;

import com.isep.utils.ConsoleParser;
import com.isep.utils.InputParser;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Game
{
    // Attributes
    private InputParser inputParser;
    private List<Combatant> combatants;
    private int heroCount;

    // Constructor
    public Game()
    {
        this.inputParser = new ConsoleParser();
    }

    // Methods
    public void initialize() throws ExecutionControl.NotImplementedException
    {
        // Initializing the number of heroes
        this.heroCount = this.inputParser.getHeroCount();

        // Initializing heroes
        String heroClass;
        String heroName;
        for(int i = 0; i < this.heroCount; i++)
        {
            StringBuilder s = new StringBuilder("");
            s.append("==== Hero ").append(i).append(" ====");
            System.out.println(s.toString());
            heroClass = this.inputParser.getHeroClass();
            heroName = this.inputParser.getCombatantName();

            switch (heroClass)
            {
                case "hunter":
                    this.combatants.add(new Hunter(heroName, Hunter.BASE_HP, Hunter.BASE_DAMAGE));
                    break;
                case "warrior":
                    this.combatants.add(new Warrior(heroName, Warrior.BASE_HP, Warrior.BASE_DAMAGE));
                    break;
                case "mage":
                    this.combatants.add(new Mage(heroName, Mage.BASE_HP, Mage.BASE_DAMAGE, Mage.BASE_MANA));
                    break;
                case "Healer":
                    this.combatants.add(new Healer(heroName, Healer.BASE_HP, Healer.BASE_DAMAGE, Mage.BASE_MANA));
                    break;
                default:
                    throw new RuntimeException("Got an invalid hero class while creating heroes");
            }

            // Initializing enemies
            
        }
    }
}
