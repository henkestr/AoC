package Y2023;

import main.Y2023.Day15;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day15Test {
    private static final Day15 DAY = new Day15();
    private static final List<String> PART_1_AND_2_INPUT = """
            rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
            """.lines().toList();

    @Test
    public void part1() {
        assertEquals("1320", DAY.solvePart1(PART_1_AND_2_INPUT));
    }

    @Test
    public void part2() {
        assertEquals("145", DAY.solvePart2(PART_1_AND_2_INPUT));
    }
}
