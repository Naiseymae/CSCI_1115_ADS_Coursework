
/* ADS Exercise 28-3: Implement DFS using a stack */

public class Edge {
	int u;
	int v;
	
	public Edge(int u, int v) {
		this.u = u;
		this.v = v;
	}
	
	public boolean equals(Object o) {
		return (u == ((Edge)o).u && v == ((Edge)o).v);
	}
}