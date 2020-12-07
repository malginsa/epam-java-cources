package com.epam.university.java.core.task002;

import java.util.Arrays;
import java.util.Iterator;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        validate(firstString);
        validate(secondString);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        validate(sourceString);
        if (number < 0)
            throw new IllegalArgumentException();
        String result = "";
        try {
            result = sourceString.substring(0, number);
        } catch (StringIndexOutOfBoundsException e) {
            result = sourceString;
        }
        return result;
    }

    @Override
    public String left(String sourceString, String separator) {
        validate(sourceString);
        validate(separator);
        return sourceString.split(separator)[0];
    }

    @Override
    public String right(String sourceString, int number) {
        validate(sourceString);
        validatePositive(number);
        String result = "";
        try {
            result = sourceString.substring(sourceString.length() - number);
        } catch (StringIndexOutOfBoundsException e) {
            result = sourceString;
        }
        return result;
    }

    @Override
    public String right(String sourceString, String separator) {
        validate(sourceString);
        validate(separator);
        return sourceString.substring(sourceString.indexOf(separator) + separator.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        validate(sourceString);
        validate(split);
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        validate(sourceCollection);
        validate(glue);
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = Arrays.asList(sourceCollection).iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext())
                sb.append(glue);
        }
        return sb.toString();
    }

    private void validate(String firstString) {
        if (firstString == null)
            throw new IllegalArgumentException();
    }

    // TODO: replace with assert
    private void validatePositive(int number) {
        if (number < 0)
            throw new IllegalArgumentException();
    }

    private void validate(Object[] objects) {
        if(objects == null || objects.length == 0)
            throw new IllegalArgumentException();
        for (Object object : objects) {
            if(object == null)
                throw new IllegalArgumentException();
        }
    }
}
