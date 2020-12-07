package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        char[] target = new char[source.length()];
        for (int i = 0; i < source.length(); i++)
            target[i] = source.charAt(source.length() - i - 1);
        return new String(target);
    }
}
