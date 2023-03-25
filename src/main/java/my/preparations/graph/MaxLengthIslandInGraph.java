package my.preparations.graph;

import java.util.*;

public class MaxLengthIslandInGraph {
    private static int findMaxLengthInGraph(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int maxLength = 0;
        for (int node : graph.keySet()) {
            int size = exploreGraph(graph, node, visited);
            if (maxLength < size) maxLength = size;
        }

        return maxLength;
    }

    private static int exploreGraph(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {
        if (visited.contains(node)) return 0;
        visited.add(node);
        int size = 1;

        for (Integer neighbour : graph.getOrDefault(node, Collections.emptyList())) {
            size += exploreGraph(graph, neighbour, visited);
        }
        return size;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        g.put(0, Arrays.asList(1));
        g.put(1, Arrays.asList(2));
        g.put(2, Arrays.asList(3));
        g.put(3, Arrays.asList(0));
        g.put(5, Arrays.asList(6));
        g.put(7, Collections.emptyList());

        System.out.println(findMaxLengthInGraph(g));
    }

}
