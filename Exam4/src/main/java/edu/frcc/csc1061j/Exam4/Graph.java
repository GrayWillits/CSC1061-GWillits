package edu.frcc.csc1061j.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	
	public class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex (E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;
			
			if (elem.equals(((Vertex)other).elem)) {
				return true;
			}
			return false;		
		}
		
		@Override 
		public String toString() {
			return elem.toString();
		}
	}

	
	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}
	
	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {
		
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int)edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}
	
	/* TODO: Implement the DFS algorithm for a graph either recursively
	** or iteratively using a stack. It should return a list of all the 
	** vertices in the pre-order depth-first traversal.
	*/
	public List<Vertex> dfs(Vertex root) {
		List<Vertex> visited = new ArrayList<Vertex>();
		Deque<Vertex> stack = new ArrayDeque<Vertex>();
		Vertex vertex;
		stack.push(root);
		
		while (!stack.isEmpty()) {
			vertex = stack.pop();
			if (visited.contains(vertex)) {
				continue;
			}
			visited.add(vertex);
			for (Edge neighbor: vertex.neighbors) {
				stack.push(neighbor.d);
			}
		}
		
		return visited;
	}

	/* TODO: Implement the BFS algorithm for a graph. It should return a list 
	** of all the vertices in the breadth-first traversal.
	*/
	public List<E> bfs() {
		List<Vertex> visited = new ArrayList<Vertex>();
		Deque<Vertex> stack = new ArrayDeque<Vertex>();
		Vertex vertex;
		stack.push(vertices.get(0));
		
		while (!stack.isEmpty()) {
			vertex = stack.pop();
			if (visited.contains(vertex)) {
				continue;
			}
			visited.add(vertex);
			for (Edge neighbor: vertex.neighbors) {
				stack.add(neighbor.d);
			}
		}
		
		List<E> list = new ArrayList<E>();
		for (Vertex vert: visited) {
			list.add(vert.elem);
		}
		return list;
	}
	

	/* TODO: Create a spanning tree using Kruskal's Algorithm and return it. 
	** The spanning tree will be a new graph
	*/
	public Graph<E> findMinimumSpanningTree() {
		List<Edge> edges = new ArrayList<Edge>();
		List<Vertex> connected = new ArrayList<Vertex>();
		for (Vertex vertex: vertices) {
			for (Edge neighbor: vertex.neighbors) {
				edges.add(neighbor);
			}
		}
		edges.sort(null);
		for (int i = 0; i < edges.size(); i++) { // removes all parallel edges and loops
			if (edges.get(i).d.equals(edges.get(i).s)) {
				edges.remove(i);
				i--;
				continue;
			}
			for (int j = i + 1; j < edges.size(); j++) {
				if (edges.get(i).s.equals(edges.get(j).s)) {
					if (edges.get(i).d.equals(edges.get(j).d)) {
						edges.remove(j);
						j--;
						continue;
					}
				}
				else if (edges.get(i).s.equals(edges.get(j).d)) {
					if (edges.get(i).d.equals(edges.get(j).s)) {
						edges.remove(j);
						j--;
						continue;
					}
				}
			}
			
		}
		
		List<Vertex> emptyVertices = new ArrayList<Vertex>();
		for (Vertex vertex: vertices) {
			emptyVertices.add(new Vertex(vertex.getKey()));
		}
		Graph<E> graph = new Graph<E>(emptyVertices);
		
		for (Edge edge: edges) { // ASSUME THAT THE WEIGHT IS THE SAME BOTH WAYS
			if (dfs(graph.findVertex(edge.s.elem)).contains(graph.findVertex(edge.d.elem))) {
				continue;
			}
			else {
				graph.addEdge(new Edge(graph.findVertex(edge.s.elem), graph.findVertex(edge.d.elem), edge.weight));
				graph.addEdge(new Edge(graph.findVertex(edge.d.elem), graph.findVertex(edge.s.elem), edge.weight));
				continue;
			}
		}
		return graph;
	}
}








