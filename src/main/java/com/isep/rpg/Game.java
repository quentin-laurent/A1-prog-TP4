package com.isep.rpg;

import com.isep.utils.ConsoleParser;
import com.isep.utils.InputParser;

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
    public void start()
    {
        this.heroCount = this.inputParser.getHeroCount();
    }
}
