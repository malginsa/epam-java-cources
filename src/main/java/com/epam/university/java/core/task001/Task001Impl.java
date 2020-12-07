package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        validate(firstNumber, secondNumber);
        Double first = Double.valueOf(firstNumber);
        Double second = Double.valueOf(secondNumber);
        return first + second;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        validate(firstNumber, secondNumber);
        Double first = Double.valueOf(firstNumber);
        Double second = Double.valueOf(secondNumber);
        return first - second;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        validate(firstNumber, secondNumber);
        Double first = Double.valueOf(firstNumber);
        Double second = Double.valueOf(secondNumber);
        return first * second;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        validate(firstNumber, secondNumber);
        Double first = Double.valueOf(firstNumber);
        Double second = Double.valueOf(secondNumber);
        return first / second;
    }

    private static void validate(String first, String second) {
        if (first == null || second == null)
            throw new IllegalArgumentException();
    }
}
