package main.Y2023;

import main.IDay;
import main.Util.MathUtil;

import java.util.*;

public class Day08 implements IDay {

    private static final String STOP_NODE = "ZZZ";

    record Node(String name, String left, String right) {
    }

    @Override
    public String solvePart1(List<String> input) {
        var instructions = input.getFirst();

        var nodeMap = new HashMap<String, Node>();

        for (int i = 2; i < input.size(); i++) {
            var currentLine = input.get(i);
            var s = currentLine.split("=");
            var nodeName = (s[0].trim());
            Node n = new Node(nodeName, s[1].trim().substring(1, 4), s[1].trim().substring(6, 9));
            nodeMap.put(nodeName, n);
        }

        var currentNode = nodeMap.get("AAA");
        var jumps = 0;
        while (!Objects.equals(STOP_NODE, currentNode.name)) {

            for (char instruction : instructions.toCharArray()) {
                if (instruction == 'L') {
                    currentNode = nodeMap.get(currentNode.left);
                } else {
                    currentNode = nodeMap.get(currentNode.right);
                }
                jumps++;
            }

        }
        return String.valueOf(jumps);
    }

    @Override
    public String solvePart2(List<String> input) {
        var instructions = input.getFirst();

        var nodeMap = new HashMap<String, Node>();

        for (int i = 2; i < input.size(); i++) {
            var currentLine = input.get(i);
            var s = currentLine.split("=");
            var nodeName = (s[0].trim());
            Node n = new Node(nodeName, s[1].trim().substring(1, 4), s[1].trim().substring(6, 9));
            nodeMap.put(nodeName, n);
        }

        var nodes = nodeMap.entrySet().stream().filter(entry -> entry.getKey().endsWith("A")).map(Map.Entry::getValue).toList();
        var loopSizes = new ArrayList<Long>();

        for (Node current : nodes) {
            var steps = 0L;
            var found = false;
            while (!found) {
                for (char instruction : instructions.toCharArray()) {
                    steps++;
                    if (instruction == 'L') {
                        current = nodeMap.get(current.left);
                    }
                    if (instruction == 'R') {
                        current = nodeMap.get(current.right);
                    }
                    if (current.name.endsWith("Z")) {
                        found = true;
                        break;
                    }
                }
            }
            loopSizes.add(steps);
        }

        return String.valueOf(MathUtil.lcm(loopSizes));
    }
}
