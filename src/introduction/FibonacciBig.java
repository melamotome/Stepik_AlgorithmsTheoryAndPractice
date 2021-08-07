package introduction;

import java.util.Scanner;

//Дано число 1≤n≤10^7, необходимо найти последнюю цифру n n n-го числа Фибоначчи.
//(a+b)mod 10 — последняя цифра числа Fi+2.
public class FibonacciBig {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int a = 0; //f0
        int b = 1; //f1
        int c = 1; //f2

        if (n == 0) return a;
            else if (n == 1) return b;
                else if (n == 2) return c;
                    else {
                        for (int i = 3; i <= n; i++) {
                            a = b;
                            b = c;
                            c = ((a % 10) + (b % 10)) % 10;
                        }
                        return c;
                    }
    }
}