package Y2023;

import main.Y2023.Day08;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day08Test {
    private static final Day08 DAY = new Day08();
    private static final List<String> PART_1_INPUT = """
            RL
                        
            AAA = (BBB, CCC)
            BBB = (DDD, EEE)
            CCC = (ZZZ, GGG)
            DDD = (DDD, DDD)
            EEE = (EEE, EEE)
            GGG = (GGG, GGG)
            ZZZ = (ZZZ, ZZZ)
            """.lines().toList();

    private static final List<String> PART_1_INPUT_2 = """
            LLR
                        
            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)
            """.lines().toList();

    private static final List<String> PART_2_INPUT = """
            LR
                        
            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX)
            """.lines().toList();


    @Test
    public void part1() {
        assertEquals("2", DAY.solvePart1(PART_1_INPUT));
        assertEquals("6", DAY.solvePart1(PART_1_INPUT_2));
    }

    @Test
    public void part2() {
        assertEquals("6", DAY.solvePart2(PART_2_INPUT));
    }
}
