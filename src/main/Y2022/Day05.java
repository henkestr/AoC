package main.Y2022;

import main.IDay;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 implements IDay {

    private static final int NUMBER_OF_STACKS = 9;

    @Override
    public String solvePart1(List<String> input) {
        Map<Integer, Stack<String>> stacks = new HashMap<>();
        boolean first = true;
        // Stacks
        for (String line : input) {
            if ((line.matches(".*\\d.*"))) {
                break;
            }

            for (int i = 0; i < NUMBER_OF_STACKS; i++) {
                var c = line.charAt((i * 4) + 1);

                if (first) {
                    Stack<String> stack = new Stack<>();
                    stacks.put(i, stack);
                }
                if (!Character.isWhitespace(c)) {
                    stacks.get(i).push(String.valueOf(c));
                }
            }
            first = false;
        }

        // Initial gets wrong when the stack is built, reverse it.
        stacks.forEach((key, value) -> Collections.reverse(value));

        // Move instructions
        Pattern pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
        Matcher matcher = pattern.matcher(String.join("", input));

        while (matcher.find()) {
            int amountValue = Integer.parseInt(matcher.group(1));
            int fromValue = Integer.parseInt(matcher.group(2));
            int toValue = Integer.parseInt(matcher.group(3));

            // Make moves
            for (int i = 0; i < amountValue; i++) {
                stacks.get(toValue - 1).push(stacks.get(fromValue - 1).pop());
            }
        }
        StringBuilder sb = new StringBuilder();

        stacks.forEach((key, value) -> sb.append(value.pop()));

        return sb.toString();
    }

    @Override
    public String solvePart2(List<String> input) {
        Map<Integer, Stack<String>> stacks = new HashMap<>();

        // Stacks
        for (String line : input) {
            if ((line.matches(".*\\d.*"))) {
                break;
            }

            for (int i = 0; i < NUMBER_OF_STACKS; i++) {
                var c = line.charAt((i * 4) + 1);

                if (!Character.isWhitespace(c)) {
                    Stack<String> stack = stacks.getOrDefault(i, new Stack<>());
                    stack.push(String.valueOf(c));
                    stacks.put(i, stack);
                }
            }
        }

        // Initial gets wrong when the stack is built, reverse it.
        stacks.forEach((key, value) -> Collections.reverse(value));

        // Move instructions
        Pattern pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
        Matcher matcher = pattern.matcher(String.join("", input));

        while (matcher.find()) {
            int amountValue = Integer.parseInt(matcher.group(1));
            int fromValue = Integer.parseInt(matcher.group(2));
            int toValue = Integer.parseInt(matcher.group(3));

            List<String> moveList = new ArrayList<>();
            // Make moves
            for (int i = 0; i < amountValue; i++) {
                moveList.add(stacks.get(fromValue - 1).pop());
            }

            Collections.reverse(moveList);

            for (String item : moveList) {
                stacks.get(toValue - 1).push(item);
            }
        }

        StringBuilder sb = new StringBuilder();

        stacks.forEach((key, value) -> sb.append(value.pop()));

        return sb.toString();
    }
}
