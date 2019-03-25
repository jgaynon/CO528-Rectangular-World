package managers;
//Jake Gaynon-jmg56
import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import tools.IDDFS;
import tools.Playfield;
import tools.Puzzle;
import tools.Rectangle;
import tools.Vertex;

//SetupManager initialises all the other object managers, adds rectangles to the playfield from a list of coordinates in csv format
public class SetupManager {
	// paths to the csv files holding the coordinate data and puzzle start and end
	// points
	public static String gridFile = "src/resources/grid.csv";
	public static String puzzleFile = "src/resources/puzzles.csv";

	PuzzleManager pm = PuzzleManager.getInstance();
	NextConfigManager ncm = NextConfigManager.getInstance();
	PlayfieldManager plfm = PlayfieldManager.getInstance();
	IDDFS iddfs = IDDFS.getInstance();
	private static SetupManager instance = null;

	public static SetupManager getInstance() {
		if (instance == null)
			instance = new SetupManager();
		return instance;
	}

	public void setup() {

		Playfield play = plfm.getPlayfield();
		setupPlayfield(gridFile, play);
		pm.loadPuzzles(puzzleFile);
		// Vertex v = play.getAllVertices().get(0);
		// System.out.println(v);
		// System.out.println(NextConfigManager.getInstance().nextConfigs(v));
		// System.out.println(NextConfigManager.getInstance().nextConfigs(v).size());

		ArrayList<Puzzle> puzzleList = pm.getPuzzleList();
		int i = 0;
		for (Puzzle p : puzzleList) {

			System.out.print("[" + i + "]");
			System.out.println(iddfs.iterativeDeepening(p));
			i = i + 1;
		}

	}

	// adds rectangles to a passed playfield from a csv file.
	// this uses opencsv, an open source csv parser library.
	// http://opencsv.sourceforge.net/
	private void setupPlayfield(String file, Playfield play) {

		try {

			// Create a filereader
			// object with CSV filepath as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// a working list of the current rectangles vertices
			ArrayList<Vertex> vertList = new ArrayList<Vertex>();
			// read data line by line
			boolean done = false;
			while ((nextRecord = csvReader.readNext()) != null) { //while there are still cells in the file to read...
				while (vertList.size() < 4 & done != true) { 
					for (String cell : nextRecord) { // add 4 Vertices to a list then create a Rectangle from it.

						String[] xy = cell.split(","); //split the cell on the comma to separate the xy values
						xy[0] = xy[0].replaceAll(" ", ""); //remove any spaces
						xy[1] = xy[1].replaceAll(" ", "");
						Integer x = Integer.parseInt(xy[0]); //parse the resulting number string to int
						Integer y = Integer.parseInt(xy[1]);
						Vertex v = new Vertex(x, y); //create a new Vertex with the xy values...

						vertList.add(v); //and add it to the list
						// System.out.println(xy[0] + "," + xy[1] + "\t");

					}

					Rectangle r = new Rectangle(vertList.get(0), vertList.get(1), vertList.get(2), vertList.get(3)); // initialise a new rectangle with values from the Vertex list
					play.addRectangle(r); //add it to the playfield
					// play.printNoOfRectangles();
					vertList.clear(); //clear the list ready for the next rectangle
					if ((nextRecord = csvReader.readNext()) == null) //if there's no cells left to read, stop
						done = true;
				}

				// System.out.println();

			}

			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
