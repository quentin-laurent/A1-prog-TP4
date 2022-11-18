package com.isep.utils;

import com.isep.rpg.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleOutputTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStream()
    {
        System.setOut(new PrintStream(this.outContent));
    }

    @AfterEach
    public void restoreStream()
    {
        System.setOut(this.originalOut);
    }

    @Test
    public void testDisplayHeroesAllAlive()
    {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new Mage("Alice"));
        heroes.add(new Warrior("Bob"));
        heroes.add(new Hunter("Charlie"));
        heroes.add(new Healer("David"));

        String expectedOutput = "[Alice (Mage) | Bob (Warrior) | Charlie (Hunter) | David (Healer)]";

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayHeroes(heroes);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayHeroesSomeDead()
    {
        ArrayList<Hero> heroes = new ArrayList<>();
        Mage a = new Mage("Alice");
        Warrior b = new Warrior("Bob");
        b.applyDamage(b.getMaxHP());
        Hunter c = new Hunter("Charlie");
        Healer d = new Healer("David");
        d.applyDamage(d.getMaxHP());

        heroes.add(a);
        heroes.add(b);
        heroes.add(c);
        heroes.add(d);

        String expectedOutput = "[Alice (Mage) | *dead* Bob (Warrior) | Charlie (Hunter) | *dead* David (Healer)]";

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayHeroes(heroes);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayEnemiesAllAlive()
    {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Boar("borr"));
        enemies.add(new Snake("snek"));
        enemies.add(new Snake("snek"));

        String expectedOutput = "[borr (Boar) | snek (Snake) | snek (Snake)]";

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayEnemies(enemies);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayEnemiesSomeDead()
    {
        ArrayList<Enemy> enemies = new ArrayList<>();
        Boar b1 = new Boar("borr");
        Snake s1 = new Snake("snek");
        s1.applyDamage(s1.getMaxHP());
        Snake s2 = new Snake("snek");
        s2.applyDamage(s2.getMaxHP());

        enemies.add(b1);
        enemies.add(s1);
        enemies.add(s2);

        String expectedOutput = "[borr (Boar) | *dead* snek (Snake) | *dead* snek (Snake)]";

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayEnemies(enemies);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }
}