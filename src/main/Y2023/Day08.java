package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
        
        var nodes = nodeMap.keySet().stream().filter(key -> key.endsWith("A")).toList();
        long jumps = 0;

        while (true) {
            for (char instruction : instructions.toCharArray()) {
                List<String> nextNodes = new ArrayList<>();
                for (var node : nodes) {
                    if (instruction == 'L') {
                        nextNodes.add(nodeMap.get(node).left);
                    } else {
                        nextNodes.add(nodeMap.get(node).right);
                    }
                }
                jumps++;
                if (nextNodes.stream().allMatch(o -> o.endsWith("Z"))) {
                    return String.valueOf(jumps);
                }
                nodes = new ArrayList<>(nextNodes);
            }
        }
    }
}
