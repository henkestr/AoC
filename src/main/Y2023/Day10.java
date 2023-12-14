package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10 implements IDay {

    public static class Node {
        public Map<Node, Integer> touchingNodes = new HashMap<>();
        public char c;
        int x;
        int y;

        public Node(char c, int x, int y) {
            this.c = c;
            this.x = x;
            this.y = y;
        }

        public void process(Node[][] matrix) {
            switch (c) {
                case '|':
                    putIfExist(getUp(matrix));
                    putIfExist(getDown(matrix));
                    break;
                case '-':
                    putIfExist(getLeft(matrix));
                    putIfExist(getRight(matrix));
                    break;
                case 'L':
                    putIfExist(getRight(matrix));
                    putIfExist(getUp(matrix));
                    break;
                case 'J':
                    putIfExist(getLeft(matrix));
                    putIfExist(getUp(matrix));
                    break;
                case '7':
                    putIfExist(getLeft(matrix));
                    putIfExist(getDown(matrix));
                    break;
                case 'F':
                    putIfExist(getDown(matrix));
                    putIfExist(getRight(matrix));
                    break;
                case 'S', '.':
                    break;
            }
        }

        private void putIfExist(Node node) {
            if (node != null) {
                touchingNodes.put(node, 1);
            }
        }

        public Node getUp(Node[][] matrix) {
            return y > 0 ? matrix[x][y - 1] : null;
        }

        public Node getDown(Node[][] matrix) {
            return y < matrix[0].length - 1 ? matrix[x][y + 1] : null;
        }

        public Node getLeft(Node[][] matrix) {
            return x > 0 ? matrix[x - 1][y] : null;
        }

        public Node getRight(Node[][] matrix) {
            return x < matrix.length - 1 ? matrix[x + 1][y] : null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "c=" + c +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Override
    public String solvePart1(List<String> input) {
        Node[][] matrix = new Node[input.getFirst().length()][input.size()];
        List<Node> allNodes = new ArrayList<>();
        Node startNode = null;

        for (int y = 0; y < input.size(); y++) {
            var chars = input.get(y).toCharArray();
            for (int x = 0; x < chars.length; x++) {
                char currChar = chars[x];

                var newNode = new Node(currChar, x, y);
                matrix[x][y] = newNode;
                allNodes.add(newNode);

                if (currChar == 'S') {
                    startNode = newNode;
                }
            }
        }

        allNodes.forEach(node -> node.process(matrix));
        allNodes.forEach(node -> {
            for (Node other : node.touchingNodes.keySet()) {
                if (other.c == 'S') {
                    other.touchingNodes.put(node, 1);
                }
            }
        });

        var distance = sortBoundaryList(startNode).size() / 2;

        return String.valueOf(distance);
    }

    @Override
    public String solvePart2(List<String> input) {
        Node[][] matrix = new Node[input.getFirst().length()][input.size()];
        List<Node> allNodes = new ArrayList<>();
        Node startNode = null;

        for (int y = 0; y < input.size(); y++) {
            var chars = input.get(y).toCharArray();
            for (int x = 0; x < chars.length; x++) {
                char currChar = chars[x];

                var newNode = new Node(currChar, x, y);
                matrix[x][y] = newNode;
                allNodes.add(newNode);

                if (currChar == 'S') {
                    startNode = newNode;
                }
            }
        }
        allNodes.forEach(node -> node.process(matrix));
        allNodes.forEach(node -> {
            for (Node other : node.touchingNodes.keySet()) {
                if (other.c == 'S') {
                    other.touchingNodes.put(node, 1);
                }
            }
        });

        var boundaries = sortBoundaryList(startNode);

        var area = CalcArea(boundaries);

        //Picks theorem tells us that A = i + (b/2) - 1
        //where A = area, i = number of internal points, b = number of boundary points

        // A - (b/2) + 1  = i
        var internalPoints = area - boundaries.size() / 2 + 1;

        // Picks theorem & Shoelace
        return String.valueOf(internalPoints);
    }

    private List<Node> sortBoundaryList(Node start) {
        var res = new ArrayList<Node>();
        res.add(start);
        var next = start.touchingNodes
                .keySet()
                .stream()
                .findFirst()
                .orElse(null);

        while (next != null) {
            res.add(next);
            next = next.touchingNodes
                    .keySet()
                    .stream()
                    .filter(n -> !res.contains(n))
                    .findFirst()
                    .orElse(null);
        }
        return res;
    }

    // Get area using shoelace formula
    private long CalcArea(List<Node> border) {
        var area = 0L;

        // Calculate value of Shoelace formula
        int j = border.size() - 1;
        for (int i = 0; i < border.size(); i++) {
            area += (long) (border.get(j).x + border.get(i).x) * (border.get(j).y - border.get(i).y);

            // j is previous vertex to i
            j = i;
        }

        // Return absolute value
        return Math.abs(area / 2);
    }
}
