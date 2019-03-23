package tools;

public class Puzzle {
private int number;
private Vertex vStart;
private Vertex vFinish;

	//the puzzle object takes a String array of length 3.
	//index 0 is the puzzle number
	//indexes 1 and 2 are the start and end coordinates.
	public Puzzle(String[] input) {
		number = Integer.parseInt(input[0]);
		
		vStart = Vertex.coordStringToVert(input[1]);
		
		vFinish = Vertex.coordStringToVert(input[2]);
	}
	

	
	public Vertex getStart() {
		return vStart;
	}
	public Vertex getFinish() {
		return vFinish;
	}

}
