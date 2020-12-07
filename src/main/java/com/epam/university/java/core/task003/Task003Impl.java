package com.epam.university.java.core.task003;

import java.util.*;

import static java.util.Arrays.asList;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        validateNotNull(source);
        String[] result = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = source[source.length - i - 1];
        }
        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        validateNotNull(first);
        validateNotNull(second);
        String[] result = new String[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    @Override
    public int findMax(int[] source) {
        validateNotNullAndNotEmpty(source);
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
            if (source[i] > max)
                max = source[i];
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        validateNotNull(source);
        validateNotNull(condition);
        ArrayList<String> result = new ArrayList<>();
        for (String s : source) {
            if (condition.isValid(s)) result.add(s);
        }
        return result.toArray(new String[0]);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemove) {
        validateNotNull(source);
        validateNotNull(toRemove);
        Set<String> toRemoveSet = Set.of(toRemove);
        ArrayList<String> target = new ArrayList<>();
        for (String s : source) {
            if (!toRemoveSet.contains(s))
                target.add(s);
        }
        return target.toArray(String[]::new);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        validateNotNull(source);
        validateNotNull(operation);
        String[] target = new String[source.length];
        for (int i = 0; i < source.length; i++)
            target[i] = operation.map(source[i]);
        return target;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        validateNotNull(source);
        validateNotNull(operation);
        Set<String> allTokens = new HashSet<>();
        for (String s : source) {
            allTokens.addAll(asList(operation.flatMap(s)));
        }
        allTokens.remove("");
        List<Object> list = asList(allTokens.toArray());
        Collections.sort(list, (o1, o2) -> {
            String s1 = (String) o1;
            String s2 = (String) o2;
            int lengthDiff = s2.length() - s1.length();
            if (lengthDiff == 0)
                return s2.compareTo(s1);
            else
                return lengthDiff;
        });
        return list.toArray(String[]::new);
    }

    private void validateNotNullAndNotEmpty(int[] ints) {
        if (ints == null || ints.length == 0)
            throw new IllegalArgumentException();
    }

    private void validateNotNull(Object[] arrray) {
        if (arrray == null)
            throw new IllegalArgumentException();
    }

    private void validateNotNull(Object condition) {
        if (condition == null)
            throw new IllegalArgumentException();
    }
}
