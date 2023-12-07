package main.Y2020;


import main.IDay;

import java.util.List;

public class Day01 implements IDay {

    public static final int NUM_TO_FIND = 2020;

    @Override
    public String solvePart1(List<String> input) {
        var lines = input.stream().map(Integer::parseInt).toList();


        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (lines.get(i) + lines.get(j) == NUM_TO_FIND) {
                    return String.valueOf(lines.get(i) * lines.get(j));
                }
            }
        }
        return null;
    }

    @Override
    public String solvePart2(List<String> input) {
        var lines =input.stream().map(Integer::parseInt).toList();

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                for (int k = 0; k < lines.size(); k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    if (lines.get(i) + lines.get(j) + lines.get(k) == NUM_TO_FIND) {
                        return String.valueOf(lines.get(i) * lines.get(j) * lines.get(k));
                    }
                }
            }
        }
        return null;
    }
}
