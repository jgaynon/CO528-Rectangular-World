package managers;
import tools.*;

//Initialises the playfield grid.
public class PlayfieldManager {
	
	private static PlayfieldManager instance = null;
	
	public static PlayfieldManager getInstance() {
	    if (instance == null)
	      instance = new PlayfieldManager(
	    		  );
	    return instance;
	  }
	
	Playfield play = new Playfield();
	public Playfield getPlayfield() {
		return play;
	}
}
