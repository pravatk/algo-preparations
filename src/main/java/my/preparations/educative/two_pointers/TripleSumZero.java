package my.preparations.educative.two_pointers;

import java.util.*;
import java.util.stream.Collectors;

public class TripleSumZero {
    public static List<List<Integer>> searchTripletsWithoutDuplicates(int[] arr) {
        Map<Integer, Pair> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                map.put(arr[i] + arr[j], new Pair(i, j));
            }
        }
        List<Triplet> unique = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = 0 - arr[i];
            if (map.containsKey(diff)) {
                Triplet t = new Triplet(arr[i], arr[map.get(diff).i], arr[map.get(diff).j]);
                if (!unique.contains(t)) unique.add(t);
            }
        }
        return unique
            .stream()
            .map(t -> {
                List<Integer> l = new ArrayList<>();
                l.add(t.i);
                l.add(t.j);
                l.add(t.k);
                return l;
            }).collect(Collectors.toList());

    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class Triplet {
        int i, j, k;

        Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public boolean equals(Object o) {
            if (o instanceof Triplet) {
                Triplet ob = (Triplet) o;
                return (this.i == ob.i || this.i == ob.j || this.i == ob.k)
                    && (this.j == ob.i || this.j == ob.j || this.j == ob.k)
                    && (this.k == ob.i || this.k == ob.j || this.k == ob.k);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
