package main.Util;

import java.util.List;

public class MathUtil {
    public static long lcm(List<Long> numbers) {
        var res = 1L;
        for (Long number : numbers) {
            res = lcm(number, res);
        }
        return res;
    }

    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}