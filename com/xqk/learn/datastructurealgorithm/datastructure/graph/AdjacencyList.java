package xqk.learn.datastructurealgorithm.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * AdjacencyList-邻接表
 *
 * @author xiongqiankun
 * @since 2022/5/7 9:37
 */
public class AdjacencyList<E> implements UndirectedGraph<E> {
    private final HashMap<E, LinkedList<E>> adj;

    public AdjacencyList() {
        this.adj = new HashMap<>();
    }

    public HashMap<E, LinkedList<E>> getAdj() {
        return adj;
    }

    @Override
    public void addEdge(E e1, E e2) {
        if (e1.equals(e2)) return;
        var vertex1 = adj.getOrDefault(e1, new LinkedList<>());
        if (!vertex1.contains(e2)) {
            vertex1.add(e2);
        }
        adj.put(e1, vertex1);
        var vertex2 = adj.getOrDefault(e2, new LinkedList<>());
        if (!vertex2.contains(e1)) {
            vertex2.add(e1);
        }
        adj.put(e2, vertex2);
    }

    @Override
    public void removeEdge(E e1, E e2) {
        if (e1.equals(e2)) return;
        var vertex1 = adj.get(e1);
        if (vertex1 != null) {
            vertex1.remove(e2);
            if (vertex1.isEmpty()) {
                adj.remove(e1);
            }
        }
        var vertex2 = adj.get(e2);
        if (vertex2 != null) {
            vertex2.remove(e1);
            if (vertex2.isEmpty()) {
                adj.remove(e2);
            }
        }
    }

    @Override
    public void print() {
        System.out.println(adj);
    }

    @Override
    public int size() {
        return adj.size();
    }

    public static void main(String[] args) {
        AdjacencyList<Integer> adj = new AdjacencyList<>();
        adj.addEdge(1, 2);
        adj.addEdge(2, 3);
        adj.print();
        adj.removeEdge(2, 3);
        adj.print();
    }
}
