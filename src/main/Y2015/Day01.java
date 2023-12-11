package main.Y2015;

import main.IDay;

import java.util.List;

public class Day01 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        var count = 0;
        for (char c : input.getFirst().toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
        }
        return String.valueOf(count);
    }

    @Override
    public String solvePart2(List<String> input) {
        var count = 0;
        var index = 0;
        for (char c : input.getFirst().toCharArray()) {
            index++;
            if (c == '(') {
                count++;
            }

            if (c == ')') {
                count--;
            }

            if (count < 0) {
                break;
            }
        }
        return String.valueOf(index);
    }
}
