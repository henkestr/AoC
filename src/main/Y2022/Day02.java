package main.Y2022;

import main.IDay;

import java.util.List;

public class Day02 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        var score = input.stream().mapToInt(line -> {
            var opponent = line.charAt(0) - 'A';
            var me = line.charAt(2) - 'X';
            if (me == opponent) {
                return me + 4; // Draw
            } else if ((me + 1) % 3 == opponent) {
                return me + 1; // Loss
            } else {
                return me + 7; // Win
            }
        }).sum();
        return String.valueOf(score);
    }

    @Override
    public String solvePart2(List<String> input) {
        var score = input.stream().mapToInt(line -> {
            var opponent = line.charAt(0) - 'A';
            var outcome = line.charAt(2) - 'X';
            return switch (outcome) {
                case 0 -> ((opponent + 2) % 3) + 1; // Loss
                case 1 -> opponent + 4; // Draw
                case 2 -> ((opponent + 1) % 3) + 7; // Win
                default -> 0;
            };
        }).sum();
        return String.valueOf(score);
    }
}
