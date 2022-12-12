package com.isep.rpg;

/**
 * An abstract class representing a spell caster: a specific type of {@link Healer} that has the ability to use spells.
 */
public abstract class SpellCaster extends Hero
{
    // Attributes
    protected int maxMana;
    protected int mana;
    protected int spellManaCost;

    // Constructor
    /**
     * Creates a new {@link SpellCaster}.
     * @param name The name of the spell caster.
     * @param baseDamage The base damage inflicted by the spell caster on each attack.
     * @param maxHP The maximum hp of the spell caster.
     * @param hp The current hp of the spell caster.
     * @param maxMana The maximum mana of the spell caster.
     * @param mana The current mana of the spell caster.
     * @param spellManaCost The mana cost of the spell caster's spell.
     */
    public SpellCaster(String name, int baseDamage, int maxHP, int hp, int maxMana, int mana, int spellManaCost)
    {
        super(name, baseDamage, maxHP, hp);
        this.maxMana = maxMana;
        this.mana = mana;
        this.spellManaCost = spellManaCost;
    }

    // Getters & Setters
    public int getMaxMana()
    {
        return this.maxMana;
    }

    public int getMana()
    {
        return this.mana;
    }

    public int getSpellManaCost()
    {
        return this.spellManaCost;
    }

    public void setSpellManaCost(int spellManaCost)
    {
        this.spellManaCost = spellManaCost;
    }

    // Methods
    /**
     * Restores the mana of this {@link SpellCaster}.
     * @param mana The amount of mana to restore.
     * @return The actual amount of mana restored.
     */
    public int restoreMana(int mana)
    {
        int restoredMana = mana;

        if((this.mana + mana > this.maxMana))
        {
            restoredMana = this.maxMana - this.mana;
            this.mana = this.maxMana;
        }
        else
            this.mana += mana;

        return restoredMana;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("");
        if(this.isAlive())
            s.append(String.format("%s (%d/%d HP | %d/%d Mana) [%s]", this.name, this.hp, this.maxHP, this.getMana(), this.getMaxMana(), this.getClass().getSimpleName()));
        else
            s.append(String.format("%s (*DEAD*) [%s]", this.name, this.getClass().getSimpleName()));

        return s.toString();
    }

    abstract int[] castSpell(Combatant combatant) throws RuntimeException;
}
