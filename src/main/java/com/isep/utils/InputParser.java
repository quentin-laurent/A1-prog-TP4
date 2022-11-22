package com.isep.utils;

import jdk.jshell.spi.ExecutionControl;

public interface InputParser
{
    /**
     * Asks the user to provide the hero count though the standard input.
     * @return A non-zero positive integer representing the hero count.
     */
    public int chooseHeroCount() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the user to provide the hero name though the standard input.
     * @return A non-blank string representing the hero name.
     */
    public String chooseCombatantName() throws ExecutionControl.NotImplementedException;

    /**
     * Asks the user to provide the hero class though the standard input.
     * @return A string representing the hero class.
     */
    public String chooseHeroClass() throws ExecutionControl.NotImplementedException;
}
