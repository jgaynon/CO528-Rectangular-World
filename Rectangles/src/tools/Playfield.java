package tools;
//Jake Gaynon-jmg56
import java.util.ArrayList;
//The playfield object holds all the Rectangle and Vertex objects and provides accessor methods to full lists of them both. 
public class Playfield {

	ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();

	protected void playField() {
		//prevents instantiation

	}
	//add a Rectangle object to the playfield
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
