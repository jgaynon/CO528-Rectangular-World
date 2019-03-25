//Jake Gaynon-jmg56
package managers;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import tools.Puzzle;

//PuzzleManager loads the puzzles from the csv file and translates them into Puzzle objects.
public class PuzzleManager {

	ArrayList<Puzzle> puzzleList = new ArrayList<Puzzle>();
	private static PuzzleManager instance = null;

	public static PuzzleManager getInstance() {
		if (instance == null)
			instance = new PuzzleManager();
		return instance;
	}
	
	// this uses opencsv, an open source csv parser library.
	// http://opencsv.sourceforge.net/
	public void loadPuzzles(String file) {

		try {
			// Create a filereader
			// object with CSV file path as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				Puzzle p = new Puzzle(nextRecord);
				puzzleList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Returns a list of all loaded puzzles.
	public ArrayList<Puzzle> getPuzzleList() {

		return puzzleList;
	}
}
