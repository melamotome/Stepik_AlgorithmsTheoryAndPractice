package introduction;

import java.util.Scanner;

//Дано целое число 1≤n≤40, необходимо вычислить n-е число Фибоначчи
// (напомним, что F0=0, F1=1, Fn=Fn−1+Fn−2 при n≥2)
public class FibonacciSmall {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int[] array = new int[41];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) array[i] = array[i - 1] + array[i - 2];
        return array[n];
    }
}