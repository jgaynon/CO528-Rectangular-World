package managers;

import java.util.ArrayList;
import java.util.List;

import mainProgram.RectangleNav;
import tools.Playfield;
import tools.Rectangle;
import tools.Vertex;

public class NextConfigManager {
	Playfield play = PlayfieldManager.getPlayfield();
	public boolean isValidMove(Vertex state, Vertex v1, Vertex v2) {
		ArrayList<Vertex> fullVertexList = new ArrayList<Vertex>();
		fullVertexList = play.getAllVertices();
		for (Vertex dest : fullVertexList) {
			if (Vertex.linesIntersect(state, dest, v1, v2)) {
				return false;
			}
		}
		return true;
	}

	public List<Vertex> nextConfigs(Vertex state) {

		ArrayList<Rectangle> fullRectList = new ArrayList<Rectangle>();
		ArrayList<Vertex> adjacentVertexList = new ArrayList<Vertex>();
		fullRectList = play.getAllRectangles();

		for (Rectangle rect : fullRectList) {

			List<Vertex> rectVertexList = rect.getAllVertices();
			for (int i = 1; i < 4; i++) {
				Vertex v1 = rectVertexList.get(i);
				Vertex v2 = rectVertexList.get(i - 1);

				boolean validMove = isValidMove(state, v1, v2);
				if (validMove == true) {
					adjacentVertexList.add(v1);
					adjacentVertexList.add(v2);
				}
			}

		}

		return adjacentVertexList;

	}
}
