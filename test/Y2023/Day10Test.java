package Y2023;

import main.Y2023.Day10;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day10Test {
    private static final Day10 DAY = new Day10();
    private static final List<String> PART_1_1_INPUT = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....
            """.lines().toList();

    private static final List<String> PART_1_2_INPUT = """
            ..F7.
            .FJ|.
            SJ.L7
            |F--J
            LJ...
            """.lines().toList();

    private static final List<String> PART_2_1_INPUT = """
            ...........
            .S-------7.
            .|F-----7|.
            .||.....||.
            .||.....||.
            .|L-7.F-J|.
            .|..|.|..|.
            .L--J.L--J.
            ...........
            """.lines().toList();

    private static final List<String> PART_2_2_INPUT = """
            .F----7F7F7F7F-7....
            .|F--7||||||||FJ....
            .||.FJ||||||||L7....
            FJL7L7LJLJ||LJ.L-7..
            L--J.L7...LJS7F-7L7.
            ....F-J..F7FJ|L7L7L7
            ....L7.F7||L7|.L7L7|
            .....|FJLJ|FJ|F7|.LJ
            ....FJL-7.||.||||...
            ....L---J.LJ.LJLJ...
            """.lines().toList();

    private static final List<String> PART_2_3_INPUT = """
            FF7FSF7F7F7F7F7F---7
            L|LJ||||||||||||F--J
            FL-7LJLJ||||||LJL-77
            F--JF--7||LJLJ7F7FJ-
            L---JF-JLJ.||-FJLJJ7
            |F|F-JF---7F7-L7L|7|
            |FFJF7L7F-JF7|JL---7
            7-L-JL7||F7|L7F-7F7|
            L.L7LFJ|||||FJL7||LJ
            L7JLJL-JLJLJL--JLJ.L
            """.lines().toList();

    @Test
    public void part1() {
        assertEquals("4", DAY.solvePart1(PART_1_1_INPUT));
        assertEquals("8", DAY.solvePart1(PART_1_2_INPUT));

    }

    @Test
    public void part2() {
        assertEquals("4", DAY.solvePart2(PART_2_1_INPUT));
        assertEquals("8", DAY.solvePart2(PART_2_2_INPUT));
        assertEquals("10", DAY.solvePart2(PART_2_3_INPUT));
    }
}
