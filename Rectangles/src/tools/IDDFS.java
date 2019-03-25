package tools;
//Jake Gaynon-jmg56
import java.util.LinkedList;
import java.util.List;

import managers.*;

//implements the Iterative Deepening Depth First Search algorithm
//this algorithm is suitable because it prioritises finding the shortest route over making sure the search completes
//we want the shortest route
public class IDDFS {

	NextConfigManager ncm = NextConfigManager.getInstance();

	private static IDDFS instance = null;

	public static IDDFS getInstance() {
		if (instance == null)
			instance = new IDDFS();
		return instance;
	}
//standard iterative deepening algorithm
	public LinkedList<Vertex> iterativeDeepening(Puzzle puzzle) {
		Vertex first = puzzle.getStart();
		Vertex last = puzzle.getFinish();
		for (int depth = 1; true; depth++) {
			LinkedList<Vertex> route = depthFirst(first, last, depth);
			if (route != null)
				return route;
		}
	}

	private LinkedList<Vertex> depthFirst(Vertex first, Vertex last, int depth) {

		if (depth == 0) {
			return null;
		} else if (first.equals(last)) {
			LinkedList<Vertex> route = new LinkedList<Vertex>();
			route.add(first);
			return route;
		} else {
			List<Vertex> nexts = ncm.nextConfigs(first);
			for (Vertex next : nexts) {
				LinkedList<Vertex> route = depthFirst(next, last, depth - 1);
				if (route != null) {
					route.addFirst(first);
					return route;
				}
			}
			return null;
		}
	}
}
