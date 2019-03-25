package tools;
//Jake Gaynon-jmg56
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Rectangle provides an iterable object allowing access to the coordinates of the shape's vertices*/

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
	//Returns all vertices as a List.
	public List<Vertex> getAllVertices() {
		return rectVertexList;
	}

}
