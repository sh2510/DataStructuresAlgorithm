package com.ds.p06_graphs.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomGraph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph(){
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex){
        if(null == adjList.get(vertex)) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2){
        if(null != adjList.get(vertex1) && null != adjList.get(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2){
        if(null != adjList.get(vertex1) && null != adjList.get(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if(null == adjList.get(vertex)){
            return false;
        }
        // assuming all edges are bidirectional
        for(String otherVertex: adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
}
