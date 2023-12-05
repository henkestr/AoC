package main.Y2023;

import main.IDay;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day04 implements IDay {

    @Override
    public String solvePart1(String input) {
        var points = 0;
        for (String line : input.lines().toList()) {

            String[] temp = line.split(":\s+")[1].split("\s+\\|\s+");
            List<Integer> winningNumbers = Arrays.stream(temp[0].split("\s+")).map(Integer::parseInt).toList();
            List<Integer> myNumbers = Arrays.stream(temp[1].split("\s+")).map(Integer::parseInt).toList();

            int wins = (int) myNumbers.stream().filter(myNumber -> winningNumbers.stream().anyMatch(winningNumber -> Objects.equals(myNumber, winningNumber))).count();

            if (wins != 0) {
                points += (int) Math.pow(2, wins - 1);
            }
        }
        return String.valueOf(points);
    }

    @Override
    public String solvePart2(String input) {
        var lines = input.lines().toList();
        var size = lines.size();

        final int[] instances = new int[size];
        Arrays.fill(instances, 1);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] temp = line.split(":[\s]+")[1].split("[\s]+\\|[\s]+");
            List<Integer> winningNumbers = Arrays.stream(temp[0].split("\s+")).map(Integer::parseInt).toList();
            List<Integer> myNumbers = Arrays.stream(temp[1].split("\s+")).map(Integer::parseInt).toList();

            int wins = (int) myNumbers.stream().filter(myNumber -> winningNumbers.stream().anyMatch(winningNumber -> Objects.equals(myNumber, winningNumber))).count();

            for (int j = 0; j < wins; j++) {
                int cardToCopy = i + j + 1;
                if (cardToCopy < instances.length) {
                    instances[cardToCopy] += instances[i];
                }
            }
        }

        int result = 0;
        for (var instance : instances) {
            result += instance;
        }

        return String.valueOf(result);
    }
}
