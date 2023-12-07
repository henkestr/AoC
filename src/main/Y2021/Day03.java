package main.Y2021;

import main.IDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day03 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        var list = input.toArray(String[]::new);
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (int i = 0; i < list[0].length(); i++) {
            var zeros = 0;
            var ones = 0;

            for (String s : list) {
                if (s.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (zeros > ones) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
        }

        var result = Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);

        return String.valueOf(result);
    }

    @Override
    public String solvePart2(List<String> input) {
        var list = input.toArray(String[]::new);
        List<String> nextList = Arrays.stream(list).toList();

        var index = 0;

        while (!nextList.isEmpty()) {
            List<String> zeroList = new ArrayList<>();
            List<String> oneList = new ArrayList<>();

            for (String row : nextList) {
                String[] lineArr = row.split("");
                String s = lineArr[index];
                if (s.equals("0")) {
                    zeroList.add(s);
                } else {
                    oneList.add(s);
                }
            }

            List<String> keepList = new ArrayList<>();

            if (zeroList.size() > oneList.size()) {
                keepList.addAll(zeroList.stream().toList());
            } else {
                keepList.addAll(oneList.stream().toList());
            }
            nextList = keepList;
            index++;
        }

        return null;
    }
}
