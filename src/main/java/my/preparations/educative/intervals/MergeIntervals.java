package my.preparations.educative.intervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};


public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> mergedIntervals = new LinkedList<>();
        if (intervals == null || intervals.size() == 1) return mergedIntervals;

        intervals.sort(Comparator.comparingInt(e -> e.start));
        Interval prev = intervals.get(0);
        int start = prev.start, end = prev.end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (end >= curr.start) {
                end = Math.max(end, curr.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = curr.start;
                end = curr.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
