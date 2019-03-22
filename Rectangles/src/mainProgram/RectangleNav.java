package mainProgram;

import java.util.ArrayList;
import java.util.List;

import tools.*;
import java.io.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class RectangleNav {

	public static String gridFile = "src/resources/grid.csv";

	public static void main(String[] args) {
		setup();

	}

	public static void setup() {
		newPlayfield(gridFile);

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

			// create a new rectangle object
			ArrayList<Vertex> vertList = new ArrayList<Vertex>();
			// read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {

					if (cell.contains(",")) {
						String[] xy = cell.split(",");
						xy[0] = xy[0].replaceAll(" ", "");
						xy[1] = xy[1].replaceAll(" ", "");
						Integer x = Integer.parseInt(xy[0]);
						Integer y = Integer.parseInt(xy[1]);
						Vertex v = new Vertex(x, y);
						
						if (vertList.size() < 4) {
							vertList.add(v);
							System.out.print(xy[0] + "," + xy[1] + "\t");
						} else {
							
							Rectangle r = new Rectangle(vertList.get(0), vertList.get(1), vertList.get(2),
									vertList.get(3));
							
							play.addRectangle(r);
							play.printNoOfRectangles();
							vertList.clear();

						}
					}
					System.out.println();

				}
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
