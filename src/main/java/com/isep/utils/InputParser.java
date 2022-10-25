package com.isep.utils;

import jdk.jshell.spi.ExecutionControl;

public interface InputParser
{
    public int getHeroCount() throws ExecutionControl.NotImplementedException;
}
