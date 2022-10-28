package com.isep.utils;

public interface InputParser
{
    /**
     * Asks the user to provide the hero count though the standard input.
     * @return A non-zero positive integer representing the hero count.
     */
    public int getHeroCount();

    /**
     * Asks the user to provide the hero name though the standard input.
     * @return A non-blank string representing the hero name.
     */
    public String getCombatantName();

    /**
     * Asks the user to provide the hero class though the standard input.
     * @return A string representing the hero class.
     */
    public String getHeroClass();
}
