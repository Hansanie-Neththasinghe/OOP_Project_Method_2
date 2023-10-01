package Artist.Services;

import Models.Song;
import java.util.ArrayList;
import java.util.logging.Logger;


public interface ISongServices {

	//Initialize logger
	public static final Logger log = Logger.getLogger(ISongServices.class.getName());

	/**
	 * Add songs to songs table
	 * @param song
	 */
	public void addSong(Song song);
	
	/**
	 * Get a particular song
	 * @param songId
	 * @return
	 */
	public Song getSongByID(String songId);
	
	/**
	 * Get list of all the songs
	 * @return
	 */
	public ArrayList<Song> getSongs();
	
	/**
	 * Update existing song
	 * @param songId
	 * @param song
	 * @return
	 */
	public Song updateSong(String songId, Song song);
	
	/**
	 * Remove an existing song
	 * @param songId
	 */
	public void deleteSong(String songId);



}
