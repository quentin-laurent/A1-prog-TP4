package com.isep.rpg.heroes;

import com.isep.rpg.Combatant;
import com.isep.rpg.enemies.Enemy;
import com.isep.rpg.items.Armor;
import com.isep.rpg.items.consumables.Consumable;
import com.isep.rpg.items.Item;
import com.isep.rpg.items.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract class representing a hero: a specific type of {@link Combatant} that is controlled by the player.
 * It has the ability to attack, defend itself, use spells (if available) or use {@link Item}s or
 * {@link Consumable}s.
 */
public abstract class Hero extends Combatant
{
    // Attributes
    protected Weapon weapon;
    protected Armor armor;
    protected Map<Item, Integer> items;

    // Constructor
    /**
     * Creates a new {@link Hero}.
     * @param name The name of the hero.
     * @param baseDamage The base damage inflicted by the hero on each attack.
     * @param maxHP The maximum hp of the hero.
     * @param hp The current hp of the hero.
     */
    public Hero(String name, int baseDamage, int maxHP, int hp)
    {
        super(name, baseDamage, maxHP, hp);
        this.items = new HashMap<Item, Integer>();
    }

    // Getters & Setters
    public Map<Item, Integer> getItems()
    {
        return this.items;
    }

    public Weapon getWeapon()
    {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor)
    {
        this.armor = armor;
    }

    // Methods
    /**
     * Adds an {@link Item} to this {@link Hero}'s inventory.
     * @param item The {@link Item} to add.
     * @param quantity The quantity of the {@link Item} to add.
     */
    public void addItem(Item item, int quantity)
    {
        this.items.put(item, quantity);
    }

    /**
     * Consumes a {@link Consumable} of this {@link Hero}'s inventory.
     * This amount of the consumed {@link Consumable} is updated in the inventory.
     * @param consumable The {@link Consumable} to consume.
     * @return The value of the applied effect (e.g. the amount of hp/mana restored).
     * @throws RuntimeException if the {@link Consumable} cannot be consumed.
     */
    public int consumeItem(Consumable consumable) throws RuntimeException
    {
        if(this.items.entrySet().contains(consumable))
            throw new RuntimeException("Consumable not in inventory !");

        int appliedEffectValue = consumable.applyEffect(this);

        // Updating the inventory
        int quantity = this.items.get(consumable);
        if(quantity > 1)
            this.items.put(consumable, quantity - 1);
        else
            this.items.remove(consumable);

        return appliedEffectValue;
    }

    /**
     * Indicates if this {@link Hero} has any consumable item in its inventory.
     * @return true if this {@link Hero} has at least one {@link Consumable} in its inventory, false otherwise.
     */
    public boolean hasAnyConsumableItem()
    {
        for(var entry: this.items.entrySet())
        {
            if(entry.getKey() instanceof Consumable)
                return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("");
        if(this.isAlive())
            s.append(String.format("%s (%d/%d HP) [%s]", this.name, this.hp, this.maxHP, this.getClass().getSimpleName()));
        else
            s.append(String.format("%s (*DEAD*) [%s]", this.name, this.getClass().getSimpleName()));

        return s.toString();
    }

    /**
     * Attacks an {@link Enemy};
     * @param enemy The targeted {@link Enemy};
     * @return A 2-value array containing the damage inflicted and the damage reduction percentage applied.
     */
    public int[] attack(Enemy enemy)
    {
        if(!enemy.isAlive())
            throw new RuntimeException("You can't attack a dead enemy !");

        // Calculating damage output
        int damage;
        if(this.weapon != null)
            damage = Math.round((this.baseDamage + this.weapon.getBaseDamage())*this.weapon.getDamageMultiplier());
        else
            damage = this.baseDamage;

        return enemy.applyDamage(damage);
    }

    @Override
    public int[] applyDamage(int damage)
    {
        // Applying the armor's damage reduction before applying the damage
        if(this.armor != null)
            return super.applyDamage((int) (damage*this.armor.getDamageMultiplier()));
        return super.applyDamage(damage);
    }
}
