package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        validate(first);
        validate(second);
        List<String> result = new ArrayList<>();
        for (String element : first) {
            if (contains(element, second))
                result.add(element);
        }
        return result.toArray(new String[0]);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        validate(first);
        validate(second);
        List<String> result = new ArrayList<String>(Arrays.asList(first));
        for (String element : second) {
            if (!contains(element, first))
                result.add(element);
        }
        return result.toArray(new String[0]);
    }

    private static void validate(String[] array) {
        if (array == null)
            throw new IllegalArgumentException();
    }

    private static boolean contains(String element, String[] array) {
        for (String s : array) {
            if (element.equals(s))
                return true;
        }
        return false;
    }

}
