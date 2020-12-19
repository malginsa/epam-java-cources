package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {

    @Override
    public boolean isValid(String sourceString) {
        checkNullability(sourceString);
        BracketMemorizerImpl memorizer = new BracketMemorizerImpl();
        int index = 0;
        while (index < sourceString.length() && memorizer.isValid()) {
            memorizer.process(sourceString.charAt(index));
            index++;
        }
        return memorizer.isValid() && memorizer.isEmpty();
    }

    private static void checkNullability(String sourceString) {
        if (sourceString == null)
            throw new IllegalArgumentException();
    }
}
