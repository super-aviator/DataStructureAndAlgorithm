package xqk.learn.datastructurealgorithm.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BreadthFirstSearch-广度、深度遍历
 *
 * @author xiongqiankun
 * @since 2022/5/7 10:14
 */
public class BreadthDepthFirstSearch {
    private final AdjacencyList<Integer> graph;

    private void buildGraph() {
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 3);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
    }

    public BreadthDepthFirstSearch() {
        graph = new AdjacencyList<>();
        buildGraph();
    }

    /**
     * 广度优先搜索-breadth-first-search
     *
     * @param start 起始点
     * @param des   中止点
     */
    public void bfs(Integer start, Integer des) {
        boolean[] visit = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        Integer[] prev = new Integer[graph.size()];
        Arrays.fill(prev, -1);
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            visit[i] = true;
            for (Integer vertex : graph.getAdj().get(i)) {
                if (!visit[vertex]) {
                    prev[vertex] = i;
                    if (vertex.equals(des)) {
                        // System.out.println(Arrays.toString(prev));
                        print(prev, start, des);
                        System.out.println();
                        return;
                    }
                    queue.offer(vertex);
                }
            }
        }

    }

    private boolean found = false;

    public void dfs(Integer start, Integer des) {
        found = false;
        boolean[] visit = new boolean[graph.size()];
        Integer[] prev = new Integer[graph.size()];
        Arrays.fill(prev, -1);
        dfs(prev, visit, start, des);
        // System.out.println(Arrays.toString(prev));
        print(prev, start, des);
        System.out.println();
    }

    public void dfs(Integer[] prev, boolean[] visit, Integer start, Integer des) {
        if (found || start.equals(des)) {
            found = true;
            return;
        }
        for (Integer vertex : graph.getAdj().get(start)) {
            if (!visit[vertex]) {
                visit[vertex] = true;
                prev[vertex] = start;
                dfs(prev, visit, vertex, des);
            }
        }
    }

    public void print(Integer[] prev, Integer start, Integer curr) {
        if (!curr.equals(start)) {
            print(prev, start, prev[curr]);
        }
        System.out.print(curr + " ");
    }

    public static void main(String[] args) {
        BreadthDepthFirstSearch bdfs = new BreadthDepthFirstSearch();
        bdfs.graph.print();
        bdfs.bfs(0, 7);
        bdfs.dfs(0, 7);
    }
}
