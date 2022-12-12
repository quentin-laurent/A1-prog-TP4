package com.isep.rpg;

/**
 * A class representing a hunter: a specific type of {@link Hero} that has the ability to attack using {@link Arrow}s.
 */
public class Hunter extends Hero
{
    // Attributes
    public static final int BASE_HP = 125;
    public static final int BASE_DAMAGE = 15;

    // Constructors
    /**
     * Creates a new {@link Hunter} with the specified name and all values set to default.
     * @param name The name of the hunter.
     */
    public Hunter(String name)
    {
        super(name, Hunter.BASE_DAMAGE, Hunter.BASE_HP, Hunter.BASE_HP);
    }

    /**
     * Creates a new {@link Hunter}.
     * @param name The name of the hunter.
     * @param baseDamage The base damage inflicted by the hunter on each attack.
     * @param maxHP The maximum hp of the hunter.
     * @param hp The current hp of the hunter.
     */
    public Hunter(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
    }

    // Methods
    @Override
    public int[] attack(Enemy enemy)
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");
        if(!this.hasArrow())
            throw new RuntimeException("You don't have any arrow !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((this.baseDamage + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = this.baseDamage;

        this.useArrow();

        return enemy.applyDamage(damage);
    }

    /**
     * Indicates if the Hero's items map contains at least one arrow
     * @return True if at least one arrow in contained in the Hero's items map, false otherwise
     */
    /**
     * Indicates if this {@link Hunter} has at least one {@link Arrow} in its inventory.
     * @return true, if this {@link Hunter} has at least one {@link Arrow} in its inventory, false otherwise.
     */
    //TODO: rename method to hasAnyArrow
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
     * Finds the first available {@link Arrow} in this {@link Hunter}'s inventory and uses it.
     * The quantity of the {@link Arrow} is updated consequently.
     * If the quantity reaches 0, the {@link Arrow} is removed from the {@link Hunter}'s inventory.
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
