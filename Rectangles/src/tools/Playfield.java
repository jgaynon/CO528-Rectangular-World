package tools;

import java.util.ArrayList;
import java.util.List;

public class Playfield {

	ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();

	public List<Rectangle> playField() {

		return rectList;

	}

	public void addRectangle(Rectangle r) {
		rectList.add(r);
	}

	public void printNoOfRectangles() {
		System.out.println("There are " + rectList.size() + " rectangles.");
	}

	public ArrayList<Vertex>  getAllVertices() {
		ArrayList<Vertex> fullVertexList = new ArrayList<Vertex>();
		for (Rectangle rect : rectList) {
			for (Vertex vert : rect) {
				fullVertexList.add(vert);
			}

		}
		return fullVertexList;
	}
	
	public ArrayList<Rectangle>  getAllRectangles() {
		ArrayList<Rectangle> fullRectList = new ArrayList<Rectangle>();
		for (Rectangle rect : rectList) {
			fullRectList.add(rect);

		}
		return fullRectList;
	}
}
