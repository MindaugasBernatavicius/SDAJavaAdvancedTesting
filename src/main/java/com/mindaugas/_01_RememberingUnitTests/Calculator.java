package com.mindaugas._01_RememberingUnitTests;

public class Calculator {
    public int add(int i, int j){
        if(i == Integer.MAX_VALUE || j == Integer.MAX_VALUE)
            throw new IllegalArgumentException("One or both value too big!");
        return i + j;
    }
}
