package main.Y2023;

import main.IDay;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 implements IDay {

    final static int MAX_VALUE_RED = 12;
    final static int MAX_VALUE_GREEN = 13;
    final static int MAX_VALUE_BLUE = 14;

    @Override
    public String solvePart1(String input) {
        var result = 0;
        var gameId = 0;
        var map = new HashMap<String, Integer>();
        Pattern pattern = Pattern.compile("\\d+");

        for (String line : input.lines().toList()) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                gameId = Integer.parseInt(matcher.group());
            }
            var game = line.replaceFirst("Game \\d+: ", "");
            var sets = game.split(";");

            for (String set : sets) {
                String[] cubes = set.split(",");
                for (String cube : cubes) {
                    String[] str = cube.trim().split("\\s+");

                    if (str[1].contains("red")) {
                        var highestRed = map.getOrDefault("red", 0);
                        var redValue = Integer.parseInt(str[0]);
                        if (redValue > highestRed) {
                            map.put("red", redValue);
                        }
                    }

                    if (str[1].contains("green")) {
                        var highestGreen = map.getOrDefault("green", 0);
                        var greenValue = Integer.parseInt(str[0]);
                        if (greenValue > highestGreen) {
                            map.put("green", greenValue);
                        }
                    }

                    if (str[1].contains("blue")) {
                        var highestBlue = map.getOrDefault("blue", 0);
                        var blueValue = Integer.parseInt(str[0]);
                        if (blueValue > highestBlue) {
                            map.put("blue", blueValue);
                        }
                    }
                }
            }

            if (MAX_VALUE_RED >= map.getOrDefault("red", 0) && MAX_VALUE_GREEN >= map.getOrDefault("green", 0) && MAX_VALUE_BLUE >= map.getOrDefault("blue", 0)) {
                result += gameId;
            }
            map.clear();
        }
        return String.valueOf(result);
    }


    @Override
    public String solvePart2(String input) {
        var result = 0;
        var map = new HashMap<String, Integer>();

        for (String line : input.lines().toList()) {
            var game = line.replaceFirst("Game \\d+: ", "");
            var sets = game.split(";");

            for (String set : sets) {
                String[] cubes = set.split(",");
                for (String cube : cubes) {
                    String[] str = cube.trim().split("\\s+");

                    if (str[1].contains("red")) {
                        var highestRed = map.getOrDefault("red", 0);
                        var redValue = Integer.parseInt(str[0]);
                        if (redValue > highestRed) {
                            map.put("red", redValue);
                        }
                    }

                    if (str[1].contains("green")) {
                        var highestGreen = map.getOrDefault("green", 0);
                        var greenValue = Integer.parseInt(str[0]);
                        if (greenValue > highestGreen) {
                            map.put("green", greenValue);
                        }
                    }

                    if (str[1].contains("blue")) {
                        var highestBlue = map.getOrDefault("blue", 0);
                        var blueValue = Integer.parseInt(str[0]);
                        if (blueValue > highestBlue) {
                            map.put("blue", blueValue);
                        }
                    }
                }
            }
            var power = map.getOrDefault("red", 0) * map.getOrDefault("green", 0) * map.getOrDefault("blue", 0);
            result += power;
            map.clear();
        }
        return String.valueOf(result);
    }
}
