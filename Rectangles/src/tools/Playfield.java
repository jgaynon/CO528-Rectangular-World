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
}
