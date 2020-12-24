package com.epam.university.java.core.task009;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        validate(sourceFile);
        try {
            return Files.lines(sourceFile.toPath())
                    .map(line -> line.replaceAll("[.,\\?]", " "))
                    .flatMap(line -> Arrays.stream(line.split(" ").clone()))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isBlank())
                    .distinct().sorted().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validate(File sourceFile) {
        if (sourceFile == null)
            throw new IllegalArgumentException();
    }
}
