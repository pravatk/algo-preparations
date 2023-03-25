package my.preparations.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KClosestOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> p = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                Point point = new Point(i, j);
                p.offer(point);
                if (p.size() > k)
                    p.poll();
            }
        }
        int[][] res = new int[k][2];
        Iterator<Point> iterator = p.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point a = iterator.next();
            int[] c = new int[]{a.i, a.j};
            res[i++] = c;
        }
        return res;
    }

    class Point implements Comparable<Point> {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public double distanceFromOrigin() {
            return Math.sqrt((j * j) - (i * i));
        }

        @Override
        public int compareTo(@NotNull KClosestOrigin.Point o) {
            return this.distanceFromOrigin() >= o.distanceFromOrigin() ? 1 : -1;
        }
    }
}
