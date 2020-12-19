package com.epam.university.java.core.task008;

import java.util.Map;
import java.util.Set;

public enum Bracket {
    OPENING_ROUND('('),
    OPENING_SQUARE('['),
    OPENING_BRACE('{'),
    CLOSING_ROUND(')'),
    CLOSING_SQUARE(']'),
    CLOSING_BRACE('}'),
    UNDEFINED(' ');

    private static final Set<Bracket> OPENING_BRACKETS =
            Set.of(OPENING_BRACE, OPENING_SQUARE, OPENING_ROUND);

    private static final Map<Bracket, Bracket> COMPLEMENTARY_PAIRS = Map.of(
            OPENING_BRACE, CLOSING_BRACE,
            OPENING_SQUARE, CLOSING_SQUARE,
            OPENING_ROUND, CLOSING_ROUND);

    private char character;

    Bracket(char character) {
        this.character = character;
    }

    public static Bracket Of(char ch) {
        for (Bracket value : Bracket.values()) {
            if (value.character == ch)
                return value;
        }
        return Bracket.UNDEFINED;
    }

    public boolean isOpening() {
        return OPENING_BRACKETS.contains(this);
    }

    public boolean isOpeningComplementaryBracketFor(Bracket other) {
        return COMPLEMENTARY_PAIRS.get(this) == other;
    }

    public boolean isClosing() {
        return !isOpening();
    }
}

