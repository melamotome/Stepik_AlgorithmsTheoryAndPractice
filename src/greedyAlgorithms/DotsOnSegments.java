package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DotsOnSegments {

    private static class Segment {
        private final int lDot;
        private final int rDot;

        private Segment(int lIn, int rIn) {
            lDot = lIn;
            rDot = rIn;
        }

        private int getRDot() {
            return rDot;
        }

        private boolean isDotInside(int dot) {
            return dot >= lDot && dot <= rDot;
        }
    }

    private void findDotsOnSegments(List<Segment> segments) {
        //Values the program needs to output
        int nOfDots = 0;
        List<Integer> dots = new ArrayList<>();

        //Sort segments in ascending order by their right ends
        segments.sort(Comparator.comparing(Segment::getRDot));

        //First step. There's at least one segment. Add the right end of the first segment to the solution
        nOfDots++;
        dots.add(segments.get(0).getRDot());

        //We iterate through the segments from the second one
        if (segments.size() > 1) {
            int currentDot = dots.get(0); //Save this dot for reference

            for (int i = 1; i < segments.size(); i++) {
                //If a previous dot is on the current segment, we don't have to do anything
                //If a dot is not, we add the right corner to the solution and make it a new reference dot
                if (!segments.get(i).isDotInside(currentDot)) {
                    nOfDots++;
                    currentDot = segments.get(i).getRDot();
                    dots.add(currentDot);
                }
            }
        }

        System.out.println(nOfDots);
        for (int dot : dots) {
            System.out.print(dot + " ");
        }
    }

    private void run() {
        //Input the segments into classes of their own
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Segment> inputSegments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputSegments.add(new Segment(s.nextInt(), s.nextInt()));
        }

        findDotsOnSegments(inputSegments);
    }

    public static void main(String[] args) {
        new DotsOnSegments().run();
    }
}
