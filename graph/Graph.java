package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    // HashMap to represent the adjacency list of the graph.
    // Each key is a vertex, and its value is a list of vertices it's connected to.
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex The name of the vertex to add.
     * @return true if the vertex was successfully added, false if it already exists.
     */
    public boolean addVertex(String vertex) {
        // Check if the vertex is not already in the adjacency list.
        if (adjList.get(vertex) == null) {
            // Add the vertex to the adjacency list with an empty list of neighbors.
            adjList.put(vertex, new ArrayList<String>());
            /*
             Example:
             If vertex = "A", the adjacency list will now include:
             { "A": [] }
             */
            return true; // Vertex was added successfully.
        }
        return false; // Vertex already exists, so it was not added.
    }

    /**
     * Prints the entire adjacency list of the graph.
     * Useful for visualizing the graph's structure.
     */
    public void printGraph() {
        System.out.println(adjList);
    }

    /**
     * Adds an undirected edge between two vertices in the graph.
     *
     * @param vertex1 The first vertex of the edge.
     * @param vertex2 The second vertex of the edge.
     * @return true if the edge was successfully added, false if either vertex doesn't exist.
     */
    public boolean addEdge(String vertex1, String vertex2) {
        // Check if both vertices exist in the adjacency list.
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            // Add vertex2 to the adjacency list of vertex1 (undirected edge).
            adjList.get(vertex1).add(vertex2);
            // Add vertex1 to the adjacency list of vertex2 (undirected edge).
            adjList.get(vertex2).add(vertex1);
            /*
             Example:
             If vertex1 = "A" and vertex2 = "B", the adjacency list will be updated to:
             { "A": ["B"], "B": ["A"] }
             */
            return true; // Edge was added successfully.
        }
        return false; // One or both vertices don't exist, so the edge wasn't added.
    }

    /**
     * Removes an undirected edge between two vertices in the graph.
     *
     * @param vertex1 The first vertex of the edge.
     * @param vertex2 The second vertex of the edge.
     * @return true if the edge was successfully removed, false if either vertex doesn't exist.
     */
    public boolean removeEdge(String vertex1, String vertex2) {
        // Check if both vertices exist in the adjacency list.
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            // Remove vertex2 from the adjacency list of vertex1.
            adjList.get(vertex1).remove(vertex2);
            // Remove vertex1 from the adjacency list of vertex2.
            adjList.get(vertex2).remove(vertex1);
            /*
             Example:
             If vertex1 = "A" and vertex2 = "B", and they were connected, the adjacency list will now be:
             { "A": [], "B": [] }
             */
            return true; // Edge was removed successfully.
        }
        return false; // One or both vertices don't exist, so the edge wasn't removed.
    }

    /**
     * Removes a vertex and all its associated edges from the graph.
     *
     * @param vertex The vertex to remove.
     * @return true if the vertex was successfully removed, false if it doesn't exist.
     */
    public boolean removeVertex(String vertex) {
        // Check if the vertex exists in the adjacency list.
        if (adjList.get(vertex) != null) {
            // Remove the vertex from the adjacency list of its neighbors.
            for (String neighbor : adjList.get(vertex)) {
                adjList.get(neighbor).remove(vertex);
            }
            // Remove the vertex itself from the adjacency list.
            adjList.remove(vertex);
            /*
             Example:
             If vertex = "A" and its neighbors were ["B", "C"], the adjacency list will now exclude "A".
             */
            return true; // Vertex was removed successfully.
        }
        return false; // Vertex doesn't exist, so it wasn't removed.
    }

    /**
     * Retrieves a list of all vertices in the graph.
     *
     * @return A list of all vertices currently in the graph.
     */
    public List<String> getAllVertices() {
        // Return the keys of the adjacency list as a list of vertices.
        return new ArrayList<>(adjList.keySet());
    }

    /**
     * Retrieves the neighbors of a specific vertex.
     *
     * @param vertex The vertex whose neighbors are to be retrieved.
     * @return A list of neighboring vertices, or null if the vertex doesn't exist.
     */
    public List<String> getNeighbors(String vertex) {
        // Return the list of neighbors for the specified vertex.
        return adjList.get(vertex);
    }

    /**
     * Checks if an edge exists between two vertices.
     *
     * @param vertex1 The first vertex of the edge.
     * @param vertex2 The second vertex of the edge.
     * @return true if an edge exists between the vertices, false otherwise.
     */
    public boolean containsEdge(String vertex1, String vertex2) {
        // Check if both vertices exist and if one contains the other in its list of neighbors.
        return adjList.get(vertex1) != null && adjList.get(vertex1).contains(vertex2);
    }

    /**
     * Checks if a vertex exists in the graph.
     *
     * @param vertex The vertex to check.
     * @return true if the vertex exists, false otherwise.
     */
    public boolean containsVertex(String vertex) {
        // Check if the adjacency list contains the specified vertex as a key.
        return adjList.containsKey(vertex);
    }
}