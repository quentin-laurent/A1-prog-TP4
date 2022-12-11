package com.isep.rpg;

public abstract class SpellCaster extends Hero
{
    // Attributes
    protected int maxMana;
    protected int mana;
    protected int spellManaCost;

    // Constructor

    /**
     * Creates a new {@link SpellCaster}
     * @param name The name of the SpellCaster
     * @param baseDamage The base damage value
     * @param maxHP The maximum hp value
     * @param hp The hp value
     * @param maxMana The maximum mana value
     * @param mana The mana value
     * @param spellManaCost The mana cost of the {@link SpellCaster}'s spell
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

    // Methods

    /**
     * Restores the mana of the SpellCaster
     * @param mana The mana amount to restore
     */
    public void restoreMana(int mana)
    {
        if((this.mana + mana > this.maxMana))
            this.mana = this.maxMana;
        else
            this.mana += mana;
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

    abstract int[] castSpell(Combatant combatant);
}
