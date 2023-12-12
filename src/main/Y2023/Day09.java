package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day09 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        var fibList = (Long) input.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .map(Long::parseLong)
                        .toList())
                .map(o -> fib(o, true)).mapToLong(Long::longValue).sum();

        return String.valueOf(fibList);
    }

    @Override
    public String solvePart2(List<String> input) {
        var fibList = (Long) input.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .map(Long::parseLong)
                        .toList())
                .map(o -> fib(o, false)).mapToLong(Long::longValue).sum();

        return String.valueOf(fibList);
    }

    private long fib(List<Long> fibList, boolean isPart1) {
        var nextList = new ArrayList<Long>();
        for (int i = 1; i < fibList.size(); i++) {
            nextList.add(fibList.get(i) - fibList.get(i - 1));
        }

        if (!nextList.stream().allMatch(s -> s == 0)) {
            var next = fib(nextList, isPart1);
            return isPart1 ? fibList.getLast() + next : fibList.getFirst() - next;
        }
        return fibList.getLast();
    }
}
