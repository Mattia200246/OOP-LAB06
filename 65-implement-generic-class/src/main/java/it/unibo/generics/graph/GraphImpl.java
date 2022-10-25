package it.unibo.generics.graph;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> edges = new LinkedHashMap<>();


    @Override
    public void addNode(final N node) {
        edges.putIfAbsent(node, new HashSet<>());
    
    }

    @Override
    public void addEdge(Object source, Object target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(edges.keySet());
    }

    @Override
    public Set<N> linkedNodes(Object node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getPath(Object source, Object target) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
