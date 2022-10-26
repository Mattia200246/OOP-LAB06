package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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
    public void addEdge(N source, N target) {
        if(source != null && target != null) {
            edges.get(target).add(source);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(edges.keySet());
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return new HashSet<>(edges.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        //se il nodo esiste
        if(edges.containsKey(source) && edges.containsKey(target)) {
            return graphSearch(source, target);
        }else{
            return Collections.emptyList();
        }
    }

    private List<N> graphSearch(final N source, final N target){
        final Set<N> visited = new HashSet<>();
        final List<N> path = new ArrayList<>();
        final Iterator<N> it = edges.get(source).iterator();
        while(it.hasNext()) {
            final N next = it.next();
            if(!visited.contains(next)) {
                visited.add(next);
                path.add(next);
                if(next.equals(target)) {
                    return path;
                }
                graphSearch(next, target);
            }
        }
        return path;
    }

    
}
