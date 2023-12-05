package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int YEAR = 2023;

    private static final int DAY = 3;
    private static final Map<Integer, IDay> DAYS2020;
    private static final Map<Integer, IDay> DAYS2021;

    private static final Map<Integer, IDay> DAYS2022;
    private static final Map<Integer, IDay> DAYS2023;

    static {
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
    }


    public static void main(String[] args) {
        IDay day;
        if (YEAR == 2020) {
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

    private static String getInput() {
        var dayString = String.valueOf(DAY);
        if (DAY < 10) {
            dayString = "0" + dayString;
        }
        // Specify the path to your file
        String filePath = "src/resources/" + YEAR + "/D" + dayString + ".txt";

        // Create a Path object
        Path path = Paths.get(filePath);
        String lines;
        try {
            lines = String.join("\n", Files.readAllLines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}