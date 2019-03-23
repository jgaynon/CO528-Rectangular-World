package tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rectangle implements Iterable<Vertex> {
	List<Vertex> rectVertexList = new ArrayList<>();

	public Rectangle(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {

		rectVertexList.add(v1);
		rectVertexList.add(v2);
		rectVertexList.add(v3);
		rectVertexList.add(v4);

	}

	public Iterator<Vertex> iterator() {
		return this.rectVertexList.iterator();
	}

	public List<Vertex> getAllVertices() {
		return rectVertexList;
	}

}
