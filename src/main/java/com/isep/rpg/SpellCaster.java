package com.isep.rpg;

public abstract class SpellCaster extends Hero
{
    // Attributes
    protected int maxMana;
    protected int mana;

    // Constructor
    public SpellCaster(String name, int maxHP, int hp, int maxMana, int mana)
    {
        super(name, maxHP, hp);
        this.maxMana = maxMana;
        this.mana = mana;
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

    abstract void castSpell(Combatant combatant);
}
