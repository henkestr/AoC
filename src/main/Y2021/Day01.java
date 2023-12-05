package main.Y2021;

import main.IDay;

import java.util.stream.IntStream;

public class Day01 implements IDay {

    @Override
    public String solvePart1(String input) {
        var values = input.lines().map(Integer::parseInt).toList();

        int result = 0;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > values.get(i - 1)) {
                result++;
            }
        }

        return String.valueOf(result);
    }

    @Override
    public String solvePart2(String input) {
        var values = input.lines().map(Integer::parseInt).toList();
        int result = (int) IntStream.range(3, values.size())
                .filter(i -> values.get(i) > values.get(i - 3))
                .count();

        return String.valueOf(result);
    }
}
