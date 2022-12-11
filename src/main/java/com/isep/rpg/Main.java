package com.isep.rpg;

import com.isep.utils.ConsoleOutput;
import com.isep.utils.ConsoleParser;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Game game = new Game(new ConsoleParser(), new ConsoleOutput());
        game.play();
    }
}
