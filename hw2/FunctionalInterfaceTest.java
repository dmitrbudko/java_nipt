package edu.phystech.hw2;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class ToUpperCaseOperator implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}

class AbsMaxOperator implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer a, Integer b) {
        return Math.max(Math.abs(a), Math.abs(b));
    }
}

class StringLengthMoreThan5 implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.length() > 5;
    }
}

class IsNumberASquareOfAnotherNumber implements Predicate<Integer> {
    @Override
    public boolean test(Integer num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}

class EvenNumberSupplier implements Supplier<Integer> {
    private int current;

    public EvenNumberSupplier(int from) {
        this.current = from % 2 == 0 ? from : from + 1;
    }

    @Override
    public Integer get() {
        int value = current;
        current += 2;
        return value;
    }
}

