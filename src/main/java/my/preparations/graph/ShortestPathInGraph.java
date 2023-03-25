package my.preparations.graph;

import java.util.*;

public class ShortestPathInGraph {
    private static int lengthOfShortestPath(Map<String, List<String>> graph, String start, String end) {
        Queue<NodeDistance> queue = new LinkedList<>();
        queue.add(new NodeDistance(start, 0));
        while (!queue.isEmpty()) {
            NodeDistance curr = queue.poll();
            if (curr.value.equals(end)) {
                return curr.hops;
            }
            for (String neighbour : graph.getOrDefault(curr.value, Collections.emptyList())) {
                queue.add(new NodeDistance(neighbour, curr.hops + 1));
            }
        }
        return -1;
    }

    static class NodeDistance {
        String value;
        Integer hops;

        NodeDistance(String value, int hops) {
            this.hops = hops;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("w", Arrays.asList("x", "v"));
        graph.put("x", Arrays.asList("y"));
        graph.put("z", Arrays.asList("y", "v"));

        System.out.println(lengthOfShortestPath(graph, "w", "z"));

        graph.put("y", Arrays.asList("z"));
        System.out.println(lengthOfShortestPath(graph, "w", "z"));

        graph.put("v", Arrays.asList("w", "z"));
        System.out.println(lengthOfShortestPath(graph, "w", "z"));

    }
}
