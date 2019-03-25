package tools;
//Jake Gaynon-jmg56
public class Puzzle {
private Vertex vStart;
private Vertex vFinish;

	//the puzzle object takes a String array of length 3.
	//index 0 is the puzzle number - ended up being unused but didn't have to to refactor it out
	//indexes 1 and 2 are the start and end coordinates of the puzzle.
	public Puzzle(String[] input) {
		
		vStart = Vertex.coordStringToVertex(input[1]);
		
		vFinish = Vertex.coordStringToVertex(input[2]);
	}
	

	
	public Vertex getStart() {
		return vStart;
	}
	public Vertex getFinish() {
		return vFinish;
	}

}
