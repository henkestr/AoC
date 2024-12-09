package main.Y2023;

import main.IDay;

import java.util.*;
import java.util.stream.IntStream;

public class Day15 implements IDay {

    public static final int NUM_OF_BOXES = 256;

    public static class Box {

        int boxIndex;
        public Map<String, Integer> lenses = new LinkedHashMap<>();

        public Box(int boxIndex) {
            this.boxIndex = boxIndex;
        }

        public int getFocusingPower() {
            List<Integer> lensesList = new ArrayList<>(lenses.values());
            return IntStream.range(0, lensesList.size()).map(i -> lensesList.get(i) * (i + 1)).sum() * (boxIndex + 1);
        }

        public void putLens(String label, int focalLength) {
            lenses.put(label, focalLength);
        }

        public void removeLens(String label) {
            lenses.remove(label);
        }
    }

    @Override
    public String solvePart1(List<String> input) {
        return String.valueOf(getHashValue(input.getFirst()));
    }

    @Override
    public String solvePart2(List<String> input) {
        var inputList = input.getFirst().split(",");
        Box[] boxes = new Box[NUM_OF_BOXES];

        for (int i = 0; i < NUM_OF_BOXES; i++) {
            boxes[i] = new Box(i);
        }

        for (String step : inputList) {
            if (step.contains("=")) {
                var s = step.split("=");
                Box box = boxes[getHashValue(s[0])];
                box.putLens(s[0], Integer.parseInt(s[1]));
            } else {
                var s = step.split("-");
                Box box = boxes[getHashValue(s[0])];
                box.removeLens(s[0]);
            }
        }
        return String.valueOf(Arrays.stream(boxes).mapToInt(Box::getFocusingPower).sum());
    }

    private int getHashValue(String value) {
        return Arrays.stream(value.split(","))
                .mapToInt(o -> o.chars()
                        .reduce(0, (a, b) -> ((a + b) * 17) % 256)).sum();
    }
}

