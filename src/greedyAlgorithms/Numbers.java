package greedyAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Numbers {

    private List<Integer> findComponents(int n) {
        List<Integer> numbers = new ArrayList<>();

        int leftPart = n;
        for (int i = 1; i <= n; i++) {
            leftPart -= i;
            if (leftPart >= i + 1) {
                numbers.add(i);
            } else {
                numbers.add(leftPart + i);
                break;
            }
        }

        return numbers;
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        List<Integer> resultedComponents = findComponents(n);
        System.out.println(resultedComponents.size());
        for (Integer component : resultedComponents) {
            System.out.print(component + " ");
        }
    }

    public static void main(String[] args) {
        new Numbers().run();
    }
}
