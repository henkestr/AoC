package Y2023;

import main.Y2023.Day07;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day07Test {
    private static final Day07 DAY = new Day07();
    private static final String PART_1_AND_2_INPUT = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
            """;


    @Test
    public void part1() {
        assertEquals("6440", DAY.solvePart1(PART_1_AND_2_INPUT));
    }

    @Test
    public void part2() {
        assertEquals("5905", DAY.solvePart2(PART_1_AND_2_INPUT));
    }
}
