package com.epam.university.java.core.task008;

public interface BracketMemorizer {
    boolean isValid();

    void process(char ch);

    void validateTail();

    void validateTwoLastBrackets();

    void removeTwoBracketsFromTail();

    public boolean isEmpty();
}
