package main.Y2022;


import main.IDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day01 implements IDay {

    @Override
    public String solvePart1(String input) {
        List<String> lines = input.lines().toList();
        int[] result = new int[lines.size()];
        int index = 0;
        for (String line : lines) {
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
    public String solvePart2(String input) {
        List<Integer> caloriesOfElfs = new ArrayList<>();
        List<String> lines = input.lines().toList();
        int sum = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                caloriesOfElfs.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }
        caloriesOfElfs.add(sum);
        Collections.sort(caloriesOfElfs);
        return String.valueOf(caloriesOfElfs.get(caloriesOfElfs.size() - 1) + caloriesOfElfs.get(caloriesOfElfs.size() - 2) + caloriesOfElfs.get(caloriesOfElfs.size() - 3));
    }
}
