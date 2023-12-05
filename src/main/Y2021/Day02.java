package main.Y2021;

import main.IDay;

public class Day02 implements IDay {

    @Override
    public String solvePart1(String input) {
        var posList = input.lines().toList();

        int xPos = 0;
        int yPos = 0;

        for (String posString: posList) {
            String[] pos = posString.split(" ");
            String command = pos[0];
            int value = Integer.parseInt(pos[1]);

            switch (command){
                case "forward":
                    xPos += value;
                    break;
                case "up":
                    yPos -= value;
                    break;
                case "down":
                    yPos += value;
                    break;
            }
        }
        return String.valueOf(xPos * yPos);
    }

    @Override
    public String solvePart2(String input) {
        var posList = input.lines().toList();

        int aim = 0;
        int horPos = 0;
        int depth = 0;

        for (String posString: posList) {
            String[] pos = posString.split(" ");
            String command = pos[0];
            int value = Integer.parseInt(pos[1]);

            switch (command){
                case "forward":
                    horPos += value;
                    depth += (aim * value);
                    break;
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
            }
        }
        return String.valueOf(horPos * depth);
    }
}
