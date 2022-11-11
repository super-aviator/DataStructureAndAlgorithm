package xqk.learn.datastructurealgorithm.datastructure.graph;

public interface UndirectedGraph<E> {
    void addEdge(E e1, E e2);

    void removeEdge(E e1, E e2);

    void print();

    int size();
}
