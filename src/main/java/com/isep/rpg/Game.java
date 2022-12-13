package com.isep.rpg;

import com.isep.rpg.enemies.Boar;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.enemies.KingCobra;
import com.isep.rpg.enemies.Snake;
import com.isep.rpg.heroes.*;
import com.isep.rpg.items.*;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;
import com.isep.utils.InputParser;
import com.isep.utils.OutputManager;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A class representing a game. A game consists of a chosen amount of stages, in which a team of {@link Hero}es
 * (controlled by the player) are facing a team of {@link Enemy} (controlled automatically).
 */
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
     * Creates a new {@link Game} with the provided {@link InputParser}.
     * @param inputParser The {@link InputParser} to be used to parse the actions of the player during the game.
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
     * Starts the {@link Game}: each stage is played successively.
     * @throws ExecutionControl.NotImplementedException
     */
    public void play() throws ExecutionControl.NotImplementedException
    {
        this.initializeHeroes();
        for(int i = 1; i <= Game.NUMBER_OF_STAGES; i++)
            this.playStage(i);
        this.outputManager.displayEndScreen((this.oneHeroIsAlive() && !(this.oneEnemyIsAlive())));
    }

    /**
     * Plays an entire stage of the game, which is itself made of multiple rounds.
     * @param stageNumber The stage number.
     */
    private void playStage(int stageNumber) throws ExecutionControl.NotImplementedException
    {
        // Last stage (boss stage)
        if(stageNumber == NUMBER_OF_STAGES)
        {
            this.generateBoss();
            int roundNumber = 1;
            while(this.oneHeroIsAlive() && this.oneEnemyIsAlive())
            {
                this.playRound(roundNumber);
                roundNumber++;
            }
        }
        else
        {
            this.outputManager.displayStageTitle(stageNumber);
            this.generateEnemies();
            int roundNumber = 1;
            while(this.oneHeroIsAlive() && this.oneEnemyIsAlive())
            {
                this.playRound(roundNumber);
                roundNumber++;
            }
            this.outputManager.displayLootTitle();
            this.distributeLoot();
            this.outputManager.displayUpgradesTitle();
            this.upgradeHeroes();
        }
    }

    /**
     * Plays an entire round of a stage. This represents the smallest iteration happening in the game.
     * During a round, each {@link Combatant} will play in a randomly determined order.
     * @param roundNumber The round number.
     * @throws ExecutionControl.NotImplementedException
     */
    private void playRound(int roundNumber) throws ExecutionControl.NotImplementedException
    {
        this.outputManager.displayRoundTitle(roundNumber);
        this.outputManager.displayEnemies(this.enemies);

        combatants.clear();
        combatants.addAll(this.heroes);
        combatants.addAll(this.enemies);

        // Shuffling the list of combattants to randomize the play order
        Collections.shuffle(combatants);

        String action;
        Combatant combatantTarget;
        Enemy enemyTarget;
        Hero heroTarget;
        Hero hero;
        Enemy enemy;
        Consumable consumable;
        int[] damageAndReductionPercentage;
        int damage;
        int reductionPercentage;
        int[] damageOrHealAndManaCost;
        int damageOrHeal;
        int manaCost;
        int appliedEffectValue;
        Random random = new Random();

        for(Combatant combatant: this.combatants)
        {
            // Checking if the round can continue
            if(!(this.oneHeroIsAlive() && this.oneEnemyIsAlive()))
                return;

            if(combatant instanceof Hero)
            {
                hero = (Hero) combatant;

                // Preventing the Hero from playing if he died during this stage
                // This check is necessary as it is not possible to remove the dead Hero from the combatants list
                // while iterating on it
                if(!(hero.isAlive()))
                    continue;

                this.outputManager.displayHero(hero);

                // Boolean used to re-parse the user action in case the chosen action can't be executed
                // (e.g. if the hero's inventory is empty)
                boolean repeat = true;
                while(repeat)
                {
                    repeat = false;
                    action = this.inputParser.chooseAction();

                    switch (action)
                    {
                        case "attack":
                            enemyTarget = this.inputParser.chooseEnemyTarget(this.enemies);
                            damageAndReductionPercentage = hero.attack(enemyTarget);
                            damage = damageAndReductionPercentage[0];
                            reductionPercentage = damageAndReductionPercentage[1];
                            this.outputManager.displayAttackMessage(hero, enemyTarget, damage);
                            this.outputManager.displayDefendMessage(enemyTarget, reductionPercentage);
                            // If the Enemy dies from the attack, it is removed from the enemies list
                            if(!(enemyTarget.isAlive()))
                                this.enemies.remove(enemyTarget);
                            break;
                        case "spell":
                            if(!(hero instanceof SpellCaster))
                            {
                                this.outputManager.displayErrorMessage("You don't know any spell ! (not a SpellCaster)");
                                repeat = true;
                                continue;
                            }

                            try {
                                combatantTarget = this.inputParser.chooseCombatantTarget(this.combatants);
                                damageOrHealAndManaCost = ((SpellCaster) hero).castSpell(combatantTarget);
                                damageOrHeal = damageOrHealAndManaCost[0];
                                manaCost = damageOrHealAndManaCost[1];
                                this.outputManager.displayCastSpellMessage((SpellCaster) hero, combatantTarget, damageOrHeal, manaCost);
                            }
                            catch(RuntimeException e) {
                                this.outputManager.displayErrorMessage(e.getMessage());
                                repeat = true;
                                continue;
                            }

                            // If the Combatant dies from the attack, it is removed from the heroes or combatants list
                            if(!(combatantTarget.isAlive()))
                            {
                                if(combatantTarget instanceof Hero)
                                    this.heroes.remove(combatantTarget);
                                else if(combatantTarget instanceof Enemy)
                                    this.enemies.remove(combatantTarget);
                            }
                            break;
                        case "defend":
                            hero.defend();
                            break;
                        case "consume":
                            if(!(hero.hasAnyConsumableItem()))
                            {
                                this.outputManager.displayErrorMessage("You don't have any consumable item !");
                                repeat = true;
                            }
                            else
                            {
                                try {
                                    consumable = this.inputParser.chooseConsumable(hero.getItems());
                                    appliedEffectValue = hero.consumeItem(consumable);
                                    this.outputManager.displayConsumableUsed(hero, consumable, appliedEffectValue);
                                }
                                catch (RuntimeException e) {
                                    this.outputManager.displayErrorMessage(e.getMessage());
                                    repeat = true;
                                }
                            }
                            break;
                        default:
                            throw new RuntimeException("Got an invalid action when parsing hero's actions");
                    }
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
                // Choses a random Hero in the heroes list
                heroTarget = this.heroes.get(random.nextInt(this.heroes.size()));
                damageAndReductionPercentage = enemy.attack(heroTarget);
                damage = damageAndReductionPercentage[0];
                reductionPercentage =  damageAndReductionPercentage[1];
                this.outputManager.displayAttackMessage(enemy, heroTarget, damage);
                this.outputManager.displayDefendMessage(heroTarget, reductionPercentage);
                // If the Hero dies from the attack, it is removed the heroes list
                if(!(heroTarget.isAlive()))
                    this.heroes.remove(heroTarget);
            }
        }
    }

    /**
     * Indicates if at least one {@link Hero} is alive.
     * @return true if at least one {@link Hero} is alive, false otherwise.
     */
    private boolean oneHeroIsAlive()
    {
        return (this.heroes.size() > 0);
    }

    /**
     * Indicates if at least one {@link Enemy} is alive.
     * @return True if at least one {@link Enemy} is alive, false otherwise.
     */
    private boolean oneEnemyIsAlive()
    {
        return (this.enemies.size() > 0);
    }

    /**
     * Plays the "upgrade" part of the stage, in which each {@link Hero} is given a possibility to choose
     * an upgrade from a list.
     * @throws ExecutionControl.NotImplementedException
     */
    private void upgradeHeroes() throws ExecutionControl.NotImplementedException
    {
        for(Hero hero: this.heroes)
        {
            this.outputManager.displayUpgradeMessage(hero);
            boolean repeat = true;
            while(repeat)
            {
                repeat = false;
                String upgrade = this.inputParser.chooseUpgrade();

                switch (upgrade)
                {
                    case "increaseBaseDamage":
                        hero.setBaseDamage((int) (hero.getBaseDamage()*1.10f));
                        break;
                    case "increaseMaxHp":
                        hero.setMaxHp((int) (hero.getMaxHP()*1.15f));
                        break;
                    case "increaseSpellDamage":
                        if(!(hero instanceof Mage))
                        {
                            this.outputManager.displayErrorMessage("You don't have any attack spell !");
                            repeat = true;
                            continue;
                        }
                        Mage mage = (Mage) hero;
                        mage.setBaseSpellDamage((int) (mage.getBaseSpellDamage()*1.10f));
                        break;
                    case "increaseSpellHeal":
                        if(!(hero instanceof Healer))
                        {
                            this.outputManager.displayErrorMessage("You don't have any heal spell !");
                            repeat = true;
                            continue;
                        }
                        Healer healer = (Healer) hero;
                        healer.setBaseSpellHeal((int) (healer.getBaseSpellHeal()*1.15f));
                        break;
                    case "decreaseManaCost":
                        if(!(hero instanceof SpellCaster))
                        {
                            this.outputManager.displayErrorMessage("You don't have any spell !");
                            repeat = true;
                            continue;
                        }
                        SpellCaster spellCaster = (SpellCaster) hero;
                        spellCaster.setSpellManaCost((int) (spellCaster.getSpellManaCost()*0.90f));
                        break;
                    default:
                        throw new RuntimeException("Got an invalid upgrade when parsing hero's upgrade choice !");
                }
            }
        }
    }

    /**
     * Generates and distributes the loot earned at the end of a stage to each {@link Hero}.
     */
    private void distributeLoot() throws ExecutionControl.NotImplementedException
    {
        for(Hero hero: heroes)
        {
            Item item = this.generateItem();
            hero.addItem(item, 1);
            this.outputManager.displayRewardMessage(hero, item, 1);
        }
    }

    /**
     * Generates a random {@link Item}.
     * This is used to generate the loot given to each {@link Hero} at the end of a stage.
     * @return The generated item.
     * @see #distributeLoot()
     */
    private Item generateItem()
    {
        Random random = new Random();
        int randInt = random.nextInt(7);

        // Each Item has the same probability to be generated
        // (the game is not supposed to be balanced)
        switch (randInt)
        {
            case 0:
                return new Food("Potato", 10);
            case 1:
                return new Food("Apple", 20);
            case 2:
                return new Food("Steak", 30);
            case 3:
                return new Potion("Small mana potion", 30);
            case 4:
                return new Potion("Medium mana potion", 60);
            case 5:
                return new Potion("Large mana potion", 90);
            case 6:
                return new Arrow("Wooden arrow", 5);
            default:
                throw new RuntimeException("Got invalid random value when generating Item (value not in random range)");
        }
    }

    /**
     * Creates a list of random {@link Enemy} that are going to face the player's {@link Hero}es in a stage.
     * For each {@link Hero} in the game, one {@link Enemy} is generated.
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
     * Creates a single {@link Enemy} which is the final boss of this {@link Game}.
     */
    private void generateBoss()
    {
        this.enemies.clear();
        this.enemies.add(new KingCobra());
    }

    /**
     * Creates a list of random {@link Hero}es that are going to face the {@link Enemy}s in a stage.
     * Each {@link Hero} is created by the player.
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
                // TODO: give heroes items at the start of the game to adjust balance
                case "hunter":
                    hero = new Hunter(heroName);
                    hero.getItems().put(new Arrow("Wooden Arrow", 5), 4);
                    hero.getItems().put(new Food("Apple", 10), 2);
                    this.heroes.add(hero);
                    break;
                case "warrior":
                    hero = new Warrior(heroName);
                    hero.addItem(new Potion("Small mana potion", 30), 1);
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
