package my.preparations.educative.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            Interval in1 = arr1[i];
            Interval in2 = arr2[j];

            if (isOverlapping(in1, in2)) {
                int start = Math.max(in1.start, in2.start);
                int end = Math.min(in1.end, in2.end);
                intervalsIntersection.add(new Interval(start, end));
            }
            if (in1.end < in2.end)
                i++;
            else
                j++;
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    private static boolean isOverlapping(Interval i, Interval j) {
        return (i.start >= j.start && i.start <= j.end) || (i.end >= j.start && i.end <= j.end);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
