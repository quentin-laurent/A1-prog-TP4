package com.isep.rpg;

import jdk.jshell.spi.ExecutionControl;

public class Hunter extends Hero
{
    // Attributes
    public static final int BASE_HP = 125;
    public static final int BASE_DAMAGE = 15;

    // Constructor

    /**
     * Creates a Hunter with the default values for hp
     * @param name The name of the Hunter
     */
    public Hunter(String name)
    {
        super(name, Hunter.BASE_HP, Hunter.BASE_HP);
    }

    /**
     * Creates a Hunter by specifying all its attributes
     * @param name The name of the Hunter
     * @param maxHP The maximum hp value
     * @param hp The current hp value
     */
    public Hunter(String name, int maxHP, int hp)
    {
        super(name, maxHP, hp);
    }

    // Metmods

    @Override
    public void attack(Enemy enemy)
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");
        if(!this.hasArrow())
            throw new RuntimeException("You don't have any arrow !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((BASE_DAMAGE + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = BASE_DAMAGE;

        this.useArrow();

        enemy.setHp(enemy.getHp() - damage);
    }

    @Override
    public void defend() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    @Override
    public void useFood(Consumable consumable) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TODO");
    }

    /**
     * Indicates if the Hero's items map contains at least one arrow
     * @return True if at least one arrow in contained in the Hero's items map, false otherwise
     */
    private boolean hasArrow()
    {
        for(var entry: this.items.entrySet())
        {
            if(entry.getKey() instanceof  Arrow && entry.getValue() > 0)
                return true;
        }
        return false;
    }

    /**
     * Finds the first available arrow in the Hero's items map and decreases its quantity by 1.
     * If the quantity reaches 0, the arrow entry is removed from the map.
     */
    private void useArrow()
    {
        for(var entry: this.items.entrySet())
        {
            if(entry.getKey() instanceof Arrow)
            {
                int quantity = entry.getValue() - 1;
                if(quantity <= 0)
                    this.items.remove(entry.getKey());
                else
                    entry.setValue(quantity);
            }
        }
    }
}
