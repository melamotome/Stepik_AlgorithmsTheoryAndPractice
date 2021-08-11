package introduction;

//This is the implementation of the code from practice section
public class GCD {

    private long gcd(long a, long b) {
        System.out.println(a + " " + b); //Check the process
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private void run() {
        System.out.println(gcd(64564564646466L, 1352452345232L));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new GCD().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms"); //Check the time
    }
}
