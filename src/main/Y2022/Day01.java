package main.Y2022;


import main.IDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day01 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        int[] result = new int[input.size()];
        int index = 0;
        for (String line : input) {
            if (line.isEmpty()) {
                index++;
                continue;
            }
            result[index] += Integer.parseInt(line);
        }

        if (Arrays.stream(result).max().isPresent()) {
            return String.valueOf(Arrays.stream(result).max().getAsInt());
        }
        return "Fail";
    }

    @Override
    public String solvePart2(List<String> input) {
        List<Integer> caloriesOfElfs = new ArrayList<>();
        int sum = 0;
        for (String line : input) {
            if (line.isEmpty()) {
                caloriesOfElfs.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }
        caloriesOfElfs.add(sum);
        Collections.sort(caloriesOfElfs);
        return String.valueOf(caloriesOfElfs.getLast() + caloriesOfElfs.get(caloriesOfElfs.size() - 2) + caloriesOfElfs.get(caloriesOfElfs.size() - 3));
    }
}
