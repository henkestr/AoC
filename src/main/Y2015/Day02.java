package main.Y2015;

import main.IDay;

import java.util.Arrays;
import java.util.List;

public class Day02 implements IDay {

    @Override
    public String solvePart1(List<String> input) {

        var sum = 0;
        for (String present : input) {
            var values = Arrays.stream(present.split("x")).mapToInt(Integer::parseInt).toArray();

            var length = values[0];
            var width = values[1];
            var height = values[2];

            var x = 2 * length * width;
            var y = 2 * width * height;
            var z = 2 * height * length;

            var smallestSide = Math.min(Math.min(x, y), z);

            sum += x + y + z + (smallestSide / 2);
        }

        return String.valueOf(sum);
    }

    @Override
    public String solvePart2(List<String> input) {
        var sum = 0;
        for (String present : input) {
            var values = Arrays.stream(present.split("x")).mapToInt(Integer::parseInt).toArray();

            var length = values[0];
            var width = values[1];
            var height = values[2];

            var volume = length * height * width;

            var x = 2 * length + 2 * width;
            var y = 2 * width + 2 * height;
            var z = 2 * height + 2 * length;

            var smallestSide = Math.min(Math.min(x, y), z);

            sum += volume + smallestSide;
        }

        return String.valueOf(sum);
    }
}
