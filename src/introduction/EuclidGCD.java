package introduction;

import java.util.Scanner;

public class EuclidGCD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
            else if (b == 0) return a;
                else if (a >= b) return gcd(a % b, b);
                    else return gcd(a, b % a);
    }
}
