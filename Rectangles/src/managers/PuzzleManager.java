package managers;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import tools.Puzzle;

public class PuzzleManager {
	public static void loadPuzzles(String file) {
		
		ArrayList<Puzzle> puzzleList = new ArrayList<Puzzle>();
		
		try {
			// Create a filereader
			// object with CSV filepath as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				Puzzle p = new Puzzle(nextRecord);
				puzzleList.add(p);
			}
			System.out.println("PuzzleList:" + puzzleList.size()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
