package Y2023;

import main.Y2023.Day06;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day06Test {
    private static final Day06 DAY = new Day06();
    private static final String PART_1_AND_2_INPUT = """
            Time:      7  15   30
            Distance:  9  40  200
            """;


    @Test
    public void part1() {
        assertEquals("288", DAY.solvePart1(PART_1_AND_2_INPUT.lines().toList()));
    }

    @Test
    public void part2() {
        assertEquals("71503", DAY.solvePart2(PART_1_AND_2_INPUT.lines().toList()));
    }
}
