package introduction;

//This is the implementation of the code from practice section
//Can compute big numbers like 100000 bc computes values smallest to biggest
//Doesn't use cash, only stores last two useful Fs
//Also doesn't store the whole number but its mod. Whole number can be stored using BigInteger type
public class Fibonacci {

    private static final int MOD = (int) (1e9+7);

    private int fibonacci(int n) {
        int a = 0; //F0
        int b = 1; //F1
        for (int i = 0; i < n; i++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return a;
    }

    private void run(int n) {
        System.out.println(n + ": " + fibonacci(n));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Fibonacci().run(8);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
