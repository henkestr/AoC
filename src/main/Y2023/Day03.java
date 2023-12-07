package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.List;

public class Day03 implements IDay {


    private record Coordinates(int x, int y) {
    }

    private record PartNumber(int number, Coordinates topLeft, Coordinates bottomRight) {

        boolean touches(Coordinates coordinates) {
            return topLeft.x() <= coordinates.x()
                    && coordinates.x() <= bottomRight.x()
                    && topLeft.y() <= coordinates.y()
                    && coordinates.y() <= bottomRight.y();
        }
    }

    @Override
    public String solvePart1(List<String> input) {
        List<PartNumber> numbers = new ArrayList<>();
        List<Coordinates> symbols = new ArrayList<>();

        for (int y = 0; y < input.size(); y++) {
            var line = input.get(y);
            var numberBuilder = new StringBuilder();

            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);

                // If it is a number
                if (Character.isDigit(c)) {
                    numberBuilder.append(c);
                } else {
                    if (!numberBuilder.isEmpty()) {
                        numbers.add(createNumber(numberBuilder.toString(), x, y));
                        numberBuilder = new StringBuilder();
                    }
                    if (c != '.') {
                        symbols.add(new Coordinates(x, y));
                    }
                }
            }
            // Check for remaining partNumbers
            if (!numberBuilder.isEmpty()) {
                numbers.add(createNumber(numberBuilder.toString(), line.length(), y));
            }
        }

        return String.valueOf(numbers.stream()
                .filter(partNumber -> symbols.stream()
                        .anyMatch(partNumber::touches))
                .mapToInt(PartNumber::number)
                .sum());
    }

    @Override
    public String solvePart2(List<String> input) {
        List<PartNumber> numbers = new ArrayList<>();
        List<Coordinates> gearSymbols = new ArrayList<>();

        for (int y = 0; y < input.size(); y++) {
            var line = input.get(y);
            var numberBuilder = new StringBuilder();

            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);

                // If it is a number
                if (Character.isDigit(c)) {
                    numberBuilder.append(c);
                } else {
                    if (!numberBuilder.isEmpty()) {
                        numbers.add(createNumber(numberBuilder.toString(), x, y));
                        numberBuilder = new StringBuilder();
                    }
                    if (c == '*') {
                        gearSymbols.add(new Coordinates(x, y));
                    }
                }
            }
            // Check for remaining partNumbers
            if (!numberBuilder.isEmpty()) {
                numbers.add(createNumber(numberBuilder.toString(), line.length(), y));
            }
        }
        return null;
    }

    private PartNumber createNumber(String number, int xAfter, int y) {
        var xBefore = xAfter - number.length() - 1;
        return new PartNumber(
                Integer.parseInt(number),
                new Coordinates(xBefore, y - 1),
                new Coordinates(xAfter, y + 1));
    }
}
