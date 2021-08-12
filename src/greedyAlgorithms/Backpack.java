package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Backpack {

    private static class Item {
        private final double weight;
        private final double cost;

        private Item(int c, int w) {
            weight = w;
            cost = c;
        }

        private double getWeight() {
            return weight;
        }

        private double getCost() {
            return cost;
        }

        private double getWorth() {
            return cost / weight;
        }
    }

    private double findMaxCost(List<Item> items, double capacity) {
        double maxCost = 0;
        double capacityLeft = capacity;

        //Sort items in descending order by their worth (cost/weight coefficient)
        items.sort(Comparator.comparing(Item::getWorth).reversed());

        for (Item item : items) {
            if (item.getWeight() <= capacityLeft) {
                //if an item fits we take it whole
                capacityLeft -= item.getWeight();
                maxCost += item.getCost();
            } else {
                //if an item doesn't fit we take a part of it and get away from the store
                maxCost += (capacityLeft / item.getWeight()) * item.getCost();
                break;
            }
        }
        return maxCost;
    }

    private void run() {
        //Input items into classes of their own
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double capacity = s.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(s.nextInt(), s.nextInt()));
        }

        System.out.printf("%.3f", findMaxCost(items, capacity));
    }

    public static void main(String[] args) {
        new Backpack().run();
    }
}
