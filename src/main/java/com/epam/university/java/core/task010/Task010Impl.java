package com.epam.university.java.core.task010;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        validate(source);
        try {
            return Files.lines(source.toPath())
                    .map(line -> line.replaceAll("[.,\\?]", " "))
                    .flatMap(line -> Arrays.stream(line.split(" ").clone()))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isBlank())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, element -> 1, Integer::sum)));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

    }

    private static void validate(File sourceFile) {
        if (sourceFile == null)
            throw new IllegalArgumentException();
    }
}
