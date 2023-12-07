package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Day06 implements IDay {

    @Override
    public String solvePart1(List<String> input) {


        List<Integer> timeValues = Arrays.stream(input.get(0).split("\\s+"))
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt).toList();

        List<Integer> distanceValues = Arrays.stream(input.get(1).split("\\s+"))
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt).toList();

        var wins = new ArrayList<Integer>();
        for (int raceId = 0; raceId < timeValues.size(); raceId++) {
            var raceWins = 0;
            for (int i = 0; i < timeValues.get(raceId); i++) {
                var timeRemaining = timeValues.get(raceId) - i;
                var distance = i * timeRemaining;

                if (distance > distanceValues.get(raceId)) {
                    raceWins++;
                }
            }
            wins.add(raceWins);
        }

        return String.valueOf(wins.stream().reduce(1, (a, b) -> a * b));
    }

    @Override
    public String solvePart2(List<String> input) {

        String timeValues = Arrays.stream(input.get(0).split("\\s+"))
                .filter(s -> s.matches("\\d+")).collect(Collectors.joining());

        String distanceValues = Arrays.stream(input.get(1).split("\\s+"))
                .filter(s -> s.matches("\\d+")).collect(Collectors.joining());

        var timeVal = Long.parseLong(timeValues);
        var distanceVal = Long.parseLong(distanceValues);

        long raceWins = LongStream.range(0, timeVal)
                .filter(speed -> {
                    long timeRemaining = timeVal - speed;
                    long distance = speed * timeRemaining;
                    return distance > distanceVal;
                })
                .count();

        return String.valueOf(raceWins);
    }
}
