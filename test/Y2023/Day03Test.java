package Y2023;

import main.Y2023.Day03;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day03Test {
    private static final Day03 DAY = new Day03();
    private static final String PART_1_AND_2_INPUT = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
            """;


    @Test
    public void part1() {
        assertEquals("4361", DAY.solvePart1(PART_1_AND_2_INPUT.lines().toList()));
    }

    @Test
    public void part2() {
        assertEquals("467835", DAY.solvePart2(PART_1_AND_2_INPUT.lines().toList()));
    }
}
