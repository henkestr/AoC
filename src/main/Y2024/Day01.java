package main.Y2024;

import main.IDay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day01 implements IDay {
    @Override
    public String solvePart1(List<String> input) {
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();

        input.forEach(line -> {
            var numb = line.split("\\s+");
            left.add(Integer.parseInt(numb[0]));
            right.add(Integer.parseInt(numb[1]));
        });

        left.sort(Integer::compare);
        right.sort(Integer::compare);

        return String.valueOf(IntStream.range(0, left.size())
                .map(i -> Math.abs(left.get(i) - right.get(i)))
                .sum());
    }

    @Override
    public String solvePart2(List<String> input) {
        var left = new ArrayList<Long>();
        var right = new ArrayList<Long>();

        input.stream()
                .map(line -> line.split("\\s+"))
                .forEach(numb -> {
                    left.add(Long.parseLong(numb[0]));
                    right.add(Long.parseLong(numb[1]));
                });

        var counts = right.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return left.stream()
                .filter(number -> counts.get(number) != null)
                .map(number -> number * counts.get(number))
                .reduce(Long::sum)
                .orElse(0L)
                .toString();
    }
}
