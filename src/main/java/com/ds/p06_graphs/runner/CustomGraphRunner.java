package com.ds.p06_graphs.runner;

import com.ds.p06_graphs.model.CustomGraph;

public class CustomGraphRunner {
    public static void main(String[] args) {
        CustomGraph graph1 = new CustomGraph();
        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("C");
        graph1.addEdge("A", "B");
        graph1.addEdge("A", "C");
        graph1.addEdge("B", "C");
        graph1.printGraph();
        graph1.removeEdge("A", "B");
        graph1.printGraph();

        System.out.println("----------------");

        CustomGraph graph2 = new CustomGraph();
        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "C");
        graph2.addEdge("A", "D");
        graph2.addEdge("B", "D");
        graph2.addEdge("C", "D");
        graph2.printGraph();

        graph2.removeVertex("D");
        graph2.printGraph();
    }
}
