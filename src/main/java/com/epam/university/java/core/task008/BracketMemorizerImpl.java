package com.epam.university.java.core.task008;

import java.util.ArrayList;
import java.util.List;

public class BracketMemorizerImpl implements BracketMemorizer {

    List<Bracket> stack = new ArrayList<>();
    private boolean valid = true;

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public void process(char ch) {
        Bracket bracket = Bracket.Of(ch);
        if (bracket != Bracket.UNDEFINED) {
            stack.add(bracket);
            if (bracket.isClosing()) validateTail();
        }
    }

    @Override
    public void validateTail() {
        if (stack.size() < 1) return;
        Bracket last = stack.get(stack.size() - 1);
        if (stack.size() == 1) {
            valid = last.isOpening();
        } else {
            validateTwoLastBrackets();
        }
    }

    @Override
    public void validateTwoLastBrackets() {
        Bracket last = stack.get(stack.size() - 1);
        Bracket previous = stack.get(stack.size() - 2);
        if (previous.isOpeningComplementaryBracketFor(last)) {
            removeTwoBracketsFromTail();
        } else {
            valid = false;
        }
    }

    @Override
    public void removeTwoBracketsFromTail() {
        stack.remove(stack.size() - 1);
        stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

