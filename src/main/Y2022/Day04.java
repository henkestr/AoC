package main.Y2022;

import main.IDay;

import java.util.List;

public class Day04 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        int result = 0;

        for (String line : input) {
            String[] parts = line.split(",");

            String[] group1 = parts[0].split("-");
            String[] group2 = parts[1].split("-");

            int group1FirstNumber = Integer.parseInt(group1[0]);
            int group1LastNumber = Integer.parseInt(group1[1]);

            int group2FirstNumber = Integer.parseInt(group2[0]);
            int group2LastNumber = Integer.parseInt(group2[1]);

            if (group1FirstNumber <= group2FirstNumber && group1LastNumber >= group2LastNumber) {
                result += 1;
            } else if (group1FirstNumber >= group2FirstNumber && group1LastNumber <= group2LastNumber) {
                result += 1;
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String solvePart2(List<String> input) {
        int result = 0;

        for (String line : input) {
            String[] parts = line.split(",");

            String[] group1 = parts[0].split("-");
            String[] group2 = parts[1].split("-");

            int group1FirstNumber = Integer.parseInt(group1[0]);
            int group1LastNumber = Integer.parseInt(group1[1]);

            int group2FirstNumber = Integer.parseInt(group2[0]);
            int group2LastNumber = Integer.parseInt(group2[1]);

            if (Math.max(group1FirstNumber, group2FirstNumber) <= Math.min(group1LastNumber, group2LastNumber)) {
                result += 1;
            }
        }
        return String.valueOf(result);
    }
}
