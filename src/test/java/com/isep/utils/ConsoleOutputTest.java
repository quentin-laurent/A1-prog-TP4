package com.isep.utils;

import com.isep.rpg.enemies.Boar;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.enemies.Snake;
import com.isep.rpg.heroes.*;
import jdk.jshell.spi.ExecutionControl;
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
    public void testDisplayHeroesAllAlive() throws ExecutionControl.NotImplementedException
    {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new Mage("Alice"));
        heroes.add(new Warrior("Bob"));
        heroes.add(new Hunter("Charlie"));
        heroes.add(new Healer("David"));

        String expectedOutput = String.format("Alice (%d/%d HP | %d/%d Mana) [Mage] | Bob (%d/%d HP) [Warrior] | Charlie (%d/%d HP) [Hunter] | David (%d/%d HP | %d/%d Mana) [Healer]",
                Mage.BASE_HP, Mage.BASE_HP, Mage.BASE_MANA, Mage.BASE_MANA, Warrior.BASE_HP, Warrior.BASE_HP,
                Hunter.BASE_HP, Hunter.BASE_HP, Healer.BASE_HP, Healer.BASE_HP, Healer.BASE_MANA, Healer.BASE_MANA);

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayHeroes(heroes);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayHeroesSomeDead() throws ExecutionControl.NotImplementedException
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

        String expectedOutput = String.format("Alice (%d/%d HP | %d/%d Mana) [Mage] | Bob (*DEAD*) [Warrior] | Charlie (%d/%d HP) [Hunter] | David (*DEAD*) [Healer]",
                Mage.BASE_HP, Mage.BASE_HP, Mage.BASE_MANA, Mage.BASE_MANA, Hunter.BASE_HP, Hunter.BASE_HP);

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayHeroes(heroes);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayEnemiesAllAlive() throws ExecutionControl.NotImplementedException
    {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Boar("borr"));
        enemies.add(new Snake("snek"));
        enemies.add(new Snake("snek"));

        String expectedOutput = String.format("Enemies: borr (%d/%d HP) | snek (%d/%d HP) | snek (%d/%d HP)",
                Boar.BASE_HP, Boar.BASE_HP, Snake.BASE_HP, Snake.BASE_HP, Snake.BASE_HP, Snake.BASE_HP);

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayEnemies(enemies);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayEnemiesSomeDead() throws ExecutionControl.NotImplementedException
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

        String expectedOutput = String.format("Enemies: borr (%d/%d HP) | snek (*DEAD*) | snek (*DEAD*)", Boar.BASE_HP, Boar.BASE_HP);

        OutputManager consoleOutput = new ConsoleOutput();
        consoleOutput.displayEnemies(enemies);

        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayHero() throws ExecutionControl.NotImplementedException
    {
        Hero hero = new Hunter("Alice");
        OutputManager consoleOutput = new ConsoleOutput();

        String expectedOutput = String.format(
                "************************************************\n" +
                "*                  NOW PLAYING                 *\n" +
                "*                                              *\n" +
                "*         Alice (%d/%d HP) [Hunter]          *\n" +
                "************************************************"
                        ,Hunter.BASE_HP, Hunter.BASE_HP);

        consoleOutput.displayHero(hero);
        assertEquals(expectedOutput, this.outContent.toString().trim());
    }

    @Test
    public void testDisplayEnemy() throws ExecutionControl.NotImplementedException
    {
        Enemy enemy = new Boar();
        OutputManager consoleOutput = new ConsoleOutput();


        String expectedOutput = String.format(
                "************************************************\n" +
                "*                  NOW PLAYING                 *\n" +
                "*                                              *\n" +
                "*               Boar (%d/%d HP)                *\n" +
                "************************************************"
                        ,Boar.BASE_HP, Boar.BASE_HP);

        consoleOutput.displayEnemy(enemy);
        assertEquals(expectedOutput, this.outContent.toString().trim());
    }
}