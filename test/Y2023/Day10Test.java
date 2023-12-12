package Y2023;

import main.Y2023.Day10;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day10Test {
    private static final Day10 DAY = new Day10();
    private static final List<String> PART_1_AND_2_INPUT = """
            """.lines().toList();


    @Test
    public void part1() {
        assertEquals("0", DAY.solvePart1(PART_1_AND_2_INPUT));
    }

    @Test
    public void part2() {
        assertEquals("0", DAY.solvePart2(PART_1_AND_2_INPUT));
    }
}
