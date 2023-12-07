package Y2023;

import main.Y2023.Day01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day01Test {
    private static final Day01 DAY = new Day01();
    private static final String PART_1_INPUT = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
            """;

    private static final String PART_2_INPUT = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
            """;


    @Test
    public void part1() {
        assertEquals("142", DAY.solvePart1(PART_1_INPUT.lines().toList()));
    }

    @Test
    public void part2() {
        assertEquals("281", DAY.solvePart2(PART_2_INPUT.lines().toList()));
    }
}
