package com.isep.rpg;

import com.isep.utils.InputParser;
import com.isep.utils.OutputManager;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game
{
    // Attributes
    private InputParser inputParser;
    private OutputManager outputManager;
    private List<Hero> heroes;
    private List<Enemy> enemies;
    private List<Combatant> combatants;
    private int heroCount;

    private static final int NUMBER_OF_STAGES = 5;

    // Constructor

    /**
     * Creates a new Game with the provided InputParser
     * @param inputParser The {@link  InputParser} to be used in the {@link Game}
     */
    public Game(InputParser inputParser, OutputManager outputManager)
    {
        this.inputParser = inputParser;
        this.outputManager = outputManager;
        this.heroes = new ArrayList<Hero>();
        this.enemies = new ArrayList<Enemy>();
        this.combatants = new ArrayList<Combatant>();
    }

    // Methods

    /**
     * Launches the {@link Game} and
     * @throws ExecutionControl.NotImplementedException
     */
    public void play() throws ExecutionControl.NotImplementedException
    {
        this.initializeHeroes();
        for(int i = 1; i <= Game.NUMBER_OF_STAGES; i++)
            this.playStage(i);
        this.outputManager.displayEndScreen();
    }

    /**
     * Plays an entire stage of of the game, which is made of multiple rounds
     */
    private void playStage(int stageNumber) throws ExecutionControl.NotImplementedException
    {
        this.outputManager.displayStageTitle(stageNumber);
        this.generateEnemies();
        while(this.oneHeroIsAlive() && this.oneEnemyIsAlive())
            this.playRound();
    }

    /**
     * Plays a single iteration of the stage
     * Each combatant will have the opportunity to attack/defend/use a consumable
     */
    private void playRound() throws ExecutionControl.NotImplementedException
    {
        this.outputManager.displayEnemies(this.enemies);

        combatants.clear();
        combatants.addAll(this.heroes);
        combatants.addAll(this.enemies);

        // Shuffling the list of combattants to randomize the play order
        Collections.shuffle(combatants);

        String action;
        Enemy enemyTarget;
        Hero heroTarget;
        Hero hero;
        Enemy enemy;
        Consumable consumable;
        int[] damageAndReductionPercentage;
        int damage;
        int reductionPercentage;
        Random random = new Random();

        for(Combatant combatant: this.combatants)
        {
            if(combatant instanceof Hero)
            {
                hero = (Hero) combatant;

                // Preventing the Hero from playing if he died during this stage
                // This check is necessary as it is not possible to remove the dead Hero from the combatants list
                // while iterating on it
                if(!(hero.isAlive()))
                    continue;

                this.outputManager.displayHero(hero);
                action = this.inputParser.chooseAction();
                switch (action)
                {
                    case "attack":
                        enemyTarget = this.inputParser.chooseEnemyTarget(this.enemies);
                        damageAndReductionPercentage = hero.attack(enemyTarget);
                        damage = damageAndReductionPercentage[0];
                        reductionPercentage = damageAndReductionPercentage[1];
                        // TODO: add check for enemyTarget.isDefending()
                        this.outputManager.displayAttackMessage(hero, enemyTarget, damage);
                        this.outputManager.displayDefendMessage(enemyTarget, reductionPercentage);
                        // If the Enemy dies from the attack, it is removed from the enemies list
                        if(!(enemyTarget.isAlive()))
                            this.enemies.remove(enemyTarget);
                        break;
                    case "defend":
                        hero.defend();
                        break;
                    case "consume":
                        consumable = this.inputParser.chooseConsumable(hero.getItems());
                        hero.consumeItem(consumable);
                        break;
                    default:
                        throw new RuntimeException("Got an invalid action when parsing hero's actions");
                }
            }
            else
            {
                enemy = (Enemy) combatant;

                // Preventing the Enemy from playing if he died during this stage
                // This check is necessary as it is not possible to remove the dead Enemy from the combatants list
                // while iterating on it
                if(!(enemy.isAlive()))
                    continue;

                this.outputManager.displayEnemy(enemy);
                // TODO: add 20% chance for the Enemy to defend itself
                // Choses a random Hero in the heroes list
                heroTarget = this.heroes.get(random.nextInt(this.heroes.size()));
                damageAndReductionPercentage = enemy.attack(heroTarget);
                damage = damageAndReductionPercentage[0];
                reductionPercentage =  damageAndReductionPercentage[1];
                // TODO: add check for heroTarget.isDefending()
                this.outputManager.displayAttackMessage(enemy, heroTarget, damage);
                this.outputManager.displayDefendMessage(heroTarget, reductionPercentage);
                // If the Hero dies from the attack, it is removed the heroes list
                if(!(heroTarget.isAlive()))
                    this.heroes.remove(heroTarget);
            }
        }
    }

    /*
    private void playRound2() throws ExecutionControl.NotImplementedException
    {
        // Shuffling both lists to randomize the play order
        Collections.shuffle(this.heroes);
        Collections.shuffle(this.enemies);

        int heroesIndex = 0;
        int enemiesIndex = 0;
        Random random = new Random();

        // Looping until everyone has played
        while((heroesIndex < this.heroes.size()) && (enemiesIndex < this.enemies.size()))
        {
            Hero hero;
            Enemy enemy;
            // 0 means a Hero gets to play
            // 1 means an Enemy gets to play
            if(random.nextInt(2) == 0)
            {
                hero = this.heroes.get(heroesIndex);
                heroesIndex++;

                // skips the turn if the hero is dead
                if(!hero.isAlive())
                    continue;

                String action = this.inputParser.chooseAction();
                switch (action)
                {
                    case "attack":
                        Enemy target = this.inputParser.chooseEnemyTarget(this.enemies);
                        hero.attack(target);
                        break;
                    case "defend":
                        hero.defend();
                        break;
                    case "consume":
                        Consumable consumable = this.inputParser.chooseConsumable(hero.getItems());
                        hero.consumeItem(consumable);
                        break;
                    default:
                        throw new RuntimeException("Got an invalid action when parsing hero's actions");
                }
            }
            else
            {
                enemy = this.enemies.get(enemiesIndex);
                enemiesIndex++;

                // Skips the turn if the enemy is dead
                if(!enemy.isAlive())
                    continue;

                // Chooses a random ALIVE target from the heroes list
                // This is not optimized as this might select the same invalid index multiple times
                Hero target;
                do {
                    target = this.heroes.get(random.nextInt(this.heroes.size()));
                } while (!target.isAlive());

                // Attacks the randomly selected target
                this.enemies.get(enemiesIndex).attack(target);
            }
        }
    }
    */

    /**
     * Indicates if at least on {@link Hero} is alive
     * @return True if at least one {@link Hero} is alive, false otherwise
     */
    private boolean oneHeroIsAlive()
    {
        return (this.heroes.size() > 0);
    }

    /**
     * Indicates if at least one {@link Enemy} is alive
     * @return True if at least one {@link Enemy} is alive, false otherwise
     */
    private boolean oneEnemyIsAlive()
    {
        return (this.enemies.size() > 0);
    }

    /**
     * Creates the {@link Enemy} instances (randomly) that are going to participate in a stage
     */
    private void generateEnemies()
    {
        this.enemies.clear();

        Random random = new Random();
        for(int i = 0; i < this.heroCount; i++)
        {
            if(random.nextInt(2) == 0)
                this.enemies.add(new Boar());
            else
                this.enemies.add(new Snake());
        }
    }

    /**
     * Creates the instances of the {@link Hero}es that are going to participate in the {@link Game}
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
                    hero.items.put(new Arrow("Wooden Arrow", 5), 4);
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
