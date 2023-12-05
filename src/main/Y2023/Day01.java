package main.Y2023;

import main.IDay;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 implements IDay {

    @Override
    public String solvePart1(String input) {

        var score = input.lines().mapToInt(line -> {
            String first = "0";
            String last = "0";

            Matcher firstNumber = Pattern.compile("(\\d)").matcher(line);
            Matcher lastNumber = Pattern.compile("(\\d)(?!.*\\d)").matcher(line);

            if (firstNumber.find()) {
                first = firstNumber.group(1);
            }

            if (lastNumber.find()) {
                last = lastNumber.group(1);
            }

            return Integer.parseInt(first + last);
        }).sum();

        return String.valueOf(score);
    }

    @Override
    public String solvePart2(String input) {
        List<String> numbers = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        var score = input.lines().mapToInt(line -> {
            String first = null;
            String last = null;

            Matcher firstNumber = Pattern.compile("(zero|one|two|three|four|five|six|seven|eight|nine|\\d)").matcher(line);
            Matcher lastNumber = Pattern.compile(".*(one|two|three|four|five|six|seven|eight|nine|\\d)").matcher(line);

            if (firstNumber.find()) {
                first = firstNumber.group(1);

                var firstIndex = numbers.indexOf(first);
                if (firstIndex != -1) {
                    first = String.valueOf(firstIndex);
                }
            }

            if (lastNumber.find()) {
                last = lastNumber.group(1);
                var lastIndex = numbers.indexOf(last);

                if (lastIndex != -1) {
                    last = String.valueOf(lastIndex);
                }
            }
            return Integer.parseInt(first + last);
        }).sum();

        return String.valueOf(score);
    }
}
