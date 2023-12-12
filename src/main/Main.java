package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int YEAR = 2023;
    private static final int DAY = 9;
    private static final Map<Integer, IDay> DAYS2015;
    private static final Map<Integer, IDay> DAYS2016;
    private static final Map<Integer, IDay> DAYS2017;
    private static final Map<Integer, IDay> DAYS2018;
    private static final Map<Integer, IDay> DAYS2019;
    private static final Map<Integer, IDay> DAYS2020;
    private static final Map<Integer, IDay> DAYS2021;

    private static final Map<Integer, IDay> DAYS2022;
    private static final Map<Integer, IDay> DAYS2023;


    public static void main(String[] args) {
        IDay day;
        if (YEAR == 2015) {
            day = DAYS2015.get(DAY);
        } else if (YEAR == 2016) {
            day = DAYS2016.get(DAY);
        } else if (YEAR == 2017) {
            day = DAYS2017.get(DAY);
        } else if (YEAR == 2018) {
            day = DAYS2018.get(DAY);
        } else if (YEAR == 2019) {
            day = DAYS2019.get(DAY);
        } else if (YEAR == 2020) {
            day = DAYS2020.get(DAY);
        } else if (YEAR == 2021) {
            day = DAYS2021.get(DAY);
        } else if (YEAR == 2022) {
            day = DAYS2022.get(DAY);
        } else if (YEAR == 2023) {
            day = DAYS2023.get(DAY);
        } else {
            throw new IllegalArgumentException("Year does not exist");
        }

        if (day != null) {
            System.out.println("*** Year: " + YEAR + " Day: " + DAY + " ***");
            System.out.println("Part 1: " + day.solvePart1(getInput()));
            System.out.println("Part 2: " + day.solvePart2(getInput()));
        } else {
            throw new IllegalArgumentException("Day for current year is not created");
        }
    }

    private static List<String> getInput() {
        var dayString = String.valueOf(DAY);
        if (DAY < 10) {
            dayString = "0" + dayString;
        }
        // Specify the path to your file
        String filePath = "resources/" + YEAR + "/D" + dayString + ".txt";

        // Create a Path object
        Path path = Paths.get(filePath);
        String lines;
        try {
            lines = String.join("\n", Files.readAllLines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines.lines().toList();
    }

    static {
        DAYS2015 = new HashMap<>();
        DAYS2015.put(1, new main.Y2015.Day01());
        DAYS2015.put(2, new main.Y2015.Day02());

        DAYS2016 = new HashMap<>();

        DAYS2017 = new HashMap<>();

        DAYS2018 = new HashMap<>();

        DAYS2019 = new HashMap<>();

        DAYS2020 = new HashMap<>();
        DAYS2020.put(1, new main.Y2020.Day01());

        DAYS2021 = new HashMap<>();
        DAYS2021.put(1, new main.Y2021.Day01());
        DAYS2021.put(2, new main.Y2021.Day02());
        DAYS2021.put(3, new main.Y2021.Day03());

        DAYS2022 = new HashMap<>();
        DAYS2022.put(1, new main.Y2022.Day01());
        DAYS2022.put(2, new main.Y2022.Day02());
        DAYS2022.put(3, new main.Y2022.Day03());
        DAYS2022.put(4, new main.Y2022.Day04());
        DAYS2022.put(5, new main.Y2022.Day05());

        DAYS2023 = new HashMap<>();
        DAYS2023.put(1, new main.Y2023.Day01());
        DAYS2023.put(2, new main.Y2023.Day02());
        DAYS2023.put(3, new main.Y2023.Day03());
        DAYS2023.put(4, new main.Y2023.Day04());
        DAYS2023.put(5, new main.Y2023.Day05());
        DAYS2023.put(6, new main.Y2023.Day06());
        DAYS2023.put(7, new main.Y2023.Day07());
        DAYS2023.put(8, new main.Y2023.Day08());
        DAYS2023.put(9, new main.Y2023.Day09());
        DAYS2023.put(10, new main.Y2023.Day10());
        DAYS2023.put(11, new main.Y2023.Day11());
        DAYS2023.put(12, new main.Y2023.Day12());
        DAYS2023.put(13, new main.Y2023.Day13());
        DAYS2023.put(14, new main.Y2023.Day14());
        DAYS2023.put(15, new main.Y2023.Day15());
        DAYS2023.put(16, new main.Y2023.Day16());
        DAYS2023.put(17, new main.Y2023.Day17());
        DAYS2023.put(18, new main.Y2023.Day18());
        DAYS2023.put(19, new main.Y2023.Day19());
        DAYS2023.put(20, new main.Y2023.Day20());
        DAYS2023.put(21, new main.Y2023.Day21());
        DAYS2023.put(22, new main.Y2023.Day22());
        DAYS2023.put(23, new main.Y2023.Day23());
        DAYS2023.put(24, new main.Y2023.Day24());
        DAYS2023.put(25, new main.Y2023.Day25());
    }
}