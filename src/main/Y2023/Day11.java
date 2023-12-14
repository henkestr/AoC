package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.List;

public class Day11 implements IDay {

    public record Galaxy(long xPos, long yPos) {
    }

    @Override
    public String solvePart1(List<String> input) {
        var galaxies = new ArrayList<Galaxy>();
        long y = 0;
        for (String row : input) {
            long x = 0;

            if (!row.contains("#")) {
                y += 2;
                continue;
            } else {
                y++;
            }

            for (int columnIndex = 0; columnIndex < row.length(); columnIndex++) {
                int finalColumnIndex = columnIndex;

                if (input.stream().map(s -> s.charAt(finalColumnIndex)).allMatch(c -> c == '.')) {
                    x += 2;
                } else {
                    x++;
                }

                if (row.charAt(columnIndex) == '#') {
                    galaxies.add(new Galaxy(x, y));
                }
            }
        }

        var res = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                res += (int) (Math.abs(galaxies.get(i).xPos() - galaxies.get(j).xPos()) + Math.abs(galaxies.get(i).yPos() - galaxies.get(j).yPos()));
            }
        }
        return String.valueOf(res);
    }

    @Override
    public String solvePart2(List<String> input) {
        var galaxies = new ArrayList<Galaxy>();
        long expansion = 1000000;
        long y = 0;
        for (String row : input) {
            long x = 0;
            if (!row.contains("#")) {
                y += expansion;
            } else {
                y += 1;
            }
            for (int columnIndex = 0; columnIndex < row.length(); columnIndex++) {
                int lastColumnIndex = columnIndex;
                if (input.stream().map(s -> s.charAt(lastColumnIndex)).allMatch(c -> c == '.')) {
                    x += expansion;
                } else {
                    x += 1;
                }
                if (row.charAt(columnIndex) == '#') {
                    galaxies.add(new Galaxy(x, y));
                }
            }
        }

        long res = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                res += (Math.abs(galaxies.get(i).xPos() - galaxies.get(j).xPos) + Math.abs(galaxies.get(i).yPos() - galaxies.get(j).yPos()));
            }
        }
        return String.valueOf(res);
    }
}
