package main.Y2022;

import main.IDay;

import java.util.List;
import java.util.stream.IntStream;

public class Day03 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        var result = input.stream().mapToInt(compartment -> {
            var chars = compartment.toCharArray();

            for (int i = 0; i < compartment.length() / 2; i++) {
                for (int j = compartment.length() / 2; j < compartment.length(); j++) {
                    if (chars[i] == chars[j]) {
                        return getPriorityValue(chars[j]);
                    }
                }
            }
            return 0;
        }).sum();
        return String.valueOf(result);
    }

    @Override
    public String solvePart2(List<String> input) {
        var list = input.stream().toList();
        var partitionSize = 3;

        var partitionGroup = IntStream.range(0, (list.size() + partitionSize - 1) / partitionSize)
                .mapToObj(i -> list.subList(i * partitionSize, Math.min(partitionSize * (i + 1), list.size()))).toList();

        var result = 0;
        for (var group : partitionGroup) {
            for (char c : group.getFirst().toCharArray()) {
                // var chars = item.toCharArray();
                if (group.get(1).indexOf(c) > -1 && group.get(2).indexOf(c) > -1) {
                    result += getPriorityValue(c);
                    break;
                }
            }
        }
        return String.valueOf(result);
    }


    private int getPriorityValue(char c) {
        if (c > 'a') {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;

        }
    }

}
