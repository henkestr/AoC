package main.Y2021;

import main.IDay;

import java.util.List;

public class Day02 implements IDay {

    @Override
    public String solvePart1(List<String> input) {
        int xPos = 0;
        int yPos = 0;

        for (String posString: input) {
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
    public String solvePart2(List<String> input) {
        int aim = 0;
        int horPos = 0;
        int depth = 0;

        for (String posString: input) {
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
