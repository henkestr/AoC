package Y2023;

import main.Y2023.Day09;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day09Test {
    private static final Day09 DAY = new Day09();
    private static final List<String> PART_1_AND_2_INPUT = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
            """.lines().toList();


    @Test
    public void part1() {
        assertEquals("114", DAY.solvePart1(PART_1_AND_2_INPUT));
    }

    @Test
    public void part2() {
        assertEquals("2", DAY.solvePart2(PART_1_AND_2_INPUT));
    }
}
