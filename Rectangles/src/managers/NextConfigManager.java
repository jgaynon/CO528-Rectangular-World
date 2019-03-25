package managers;
//Jake Gaynon-jmg56
import java.util.ArrayList;
import java.util.List;

import tools.Playfield;
import tools.Rectangle;
import tools.Vertex;

//NextConfigManager provides the adjacency data to the depth first search function.

//To determine the set of legal next moves from a vertex, it checks for intersections with rectangle sides on a line from the starting position to another vertex. 
//It then repeats this with every other vertex on the grid.
public class NextConfigManager {

	private static NextConfigManager instance = null;

	public static NextConfigManager getInstance() {
		if (instance == null)
			instance = new NextConfigManager();
		return instance;
	}

	PlayfieldManager pm = PlayfieldManager.getInstance();
	Playfield play = pm.getPlayfield();

	//checks for intersections with any rectangle sides on a line from one vertex to another.
	public boolean isSingleValidMove(Vertex start, Vertex finish) {
		ArrayList<Rectangle> fullRectList = play.getAllRectangles();

		for (Rectangle rect : fullRectList) { //iterate through every rectangle on the board
			List<Vertex> rectVertexList = rect.getAllVertices();
			Vertex v1 = rectVertexList.get(0);
			Vertex v2 = rectVertexList.get(1);
			Vertex v3 = rectVertexList.get(2);
			Vertex v4 = rectVertexList.get(3);
			if (Vertex.linesIntersect(start, finish, v1, v2) || Vertex.linesIntersect(start, finish, v2, v3) 
					|| Vertex.linesIntersect(start, finish, v3, v4) || Vertex.linesIntersect(start, finish, v4, v1)) {  // this statement performs the intersection checking with the sides of the rectangle.
				return false;
			} else if (Vertex.linesIntersect(start, finish, v1, v3) || Vertex.linesIntersect(start, finish, v2, v4)) {  /* this statement checks for intersection with two lines crossing the inside of the rectangle
			 																											this is necessary because otherwise there's nothing to stop the solution from crossing the
			 																											inside of a rectangle to reach the opposite corner - as no sides have been intersected with, 
			 																											just vertices*/
				
				return false;
			}

		}

		return true;
	}
	//the nextConfigs method itself iterates through every vertex to build a complete adjacency list for the Vertex it is passed.
	public List<Vertex> nextConfigs(Vertex start) {
		ArrayList<Vertex> fullVertexList = play.getAllVertices();
		ArrayList<Vertex> adjacentVertexList = new ArrayList<Vertex>();
		for (Vertex vert : fullVertexList) {
			if (isSingleValidMove(start, vert)) {
				adjacentVertexList.add(vert);
			}
		}
		// System.out.println(adjacentVertexList);
		return adjacentVertexList;
	}
}
