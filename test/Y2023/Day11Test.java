package Y2023;

import main.Y2023.Day11;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day11Test {
    private static final Day11 DAY = new Day11();
    private static final List<String> PART_1_AND_2_INPUT = """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
            """.lines().toList();

    @Test
    public void part1() {
        assertEquals("374", DAY.solvePart1(PART_1_AND_2_INPUT));
    }

    @Test
    public void part2() {
        assertEquals("82000210", DAY.solvePart2(PART_1_AND_2_INPUT));
    }
}
