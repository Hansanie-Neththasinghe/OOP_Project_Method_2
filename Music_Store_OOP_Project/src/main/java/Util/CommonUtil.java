package Util;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;

import Artist.Services.*;
/**
* This is the common utility class to load all property details at once when it
* is initializing .
* 
*/

public class CommonUtil {
	/** Initialize logger */
	
	public static final Logger log = Logger.getLogger(ISongServices.class.getName());
	
	//Load property file
	public static final Properties properties = new Properties();
	
	static {
		try {
			//Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
		}catch(IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Add new Song Id
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateSongIDs(ArrayList<String> arrayList) {
		String songId;
		int next = arrayList.size();
		//next++;
		songId = CommonConstants.SONG_ID_PREFIX + next;
		if(arrayList.contains(songId)) {
			next++;
			songId = CommonConstants.SONG_ID_PREFIX + next;
		}
		return songId;
	}
}

