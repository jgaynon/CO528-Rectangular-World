package mainProgram;

import java.util.ArrayList;

import tools.*;
import java.io.*;

import com.opencsv.CSVReader;


import Managers.*;

public class RectangleNav {

	public static String gridFile = "src/resources/grid.csv";
	public static String puzzleFile = "src/resources/puzzles.csv";

	public static void main(String[] args) {
		setup();

	}

	public static void setup() {
		newPlayfield(gridFile);
		PuzzleManager.loadPuzzles(puzzleFile);

	}

	public static void newPlayfield(String file) {

		try {
			Playfield play = new Playfield();
			// Create a filereader
			// object with CSV filepath as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			//a working list of the current rectangles vertices
			ArrayList<Vertex> vertList = new ArrayList<Vertex>();
			// read data line by line
			boolean done = false;
			while ((nextRecord = csvReader.readNext()) != null) {
				while (vertList.size() < 4 & done != true) {
					for (String cell : nextRecord) {

						String[] xy = cell.split(",");
						xy[0] = xy[0].replaceAll(" ", "");
						xy[1] = xy[1].replaceAll(" ", "");
						Integer x = Integer.parseInt(xy[0]);
						Integer y = Integer.parseInt(xy[1]);
						Vertex v = new Vertex(x, y);

						vertList.add(v);
						System.out.println(xy[0] + "," + xy[1] + "\t");

					}

					Rectangle r = new Rectangle(vertList.get(0), vertList.get(1), vertList.get(2), vertList.get(3));
					play.addRectangle(r);
					play.printNoOfRectangles();
					vertList.clear();
					if ((nextRecord = csvReader.readNext()) == null)
						done = true;
				}

				System.out.println();

			}

			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

/*
 * public List<Vertex> nextConfigs(Vertex state) {
 * 
 * } }
 */
