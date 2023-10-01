package Artist.Services;

import Models.Song;
import Util.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class SongServicesImpl implements ISongServices{
	
	
	
	/**  Initialize logger */
	public static final Logger log = Logger.getLogger(SongServicesImpl.class.getName());
	
	private static Connection connection;
	
	private static Statement statement;
	
	
	static {
		//create table 
		createSongTable();
	}
	
	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Songs table in the database and
	 * recreate table structure to insert song entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createSongTable() {

		try {
			connection = DBConnection.getDBConnection();
			statement = connection.createStatement();
			
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			//statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
			
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_SONGS));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, "Error with creating songs table" + e.getMessage());
			//System.out.println("Table not created");
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	/**
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 */
	
	
	
	//================================== CRUD OPERATIONS =======================================
	
	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		String songId = CommonUtil.generateSongIDs(getSongIds());
		
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in SongQuery.xml file and use
			 * insert_song key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SONGS));
			connection.setAutoCommit(false);
			
			//Generate Song IDs
			song.setId(songId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, song.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, song.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, song.getArtistName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, song.getGenre());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, song.getReleasedDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, song.getLyricist());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, song.getProducer());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, song.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, song.getCoverart());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, song.getSongtrack());
			
			
			// Add song
			preparedStatement.execute();
			connection.commit();
			
			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		
	}
	
	//================================================================================

	/**
	 * getSongByID
	 */
	@Override
	public Song getSongByID(String songId) {
		// TODO Auto-generated method stub
		return actionOnSong(songId).get(0);
	}
	
	//================================================================================

	/**
	 * Get the song list
	 */	
	@Override
	public ArrayList<Song> getSongs() {
		// TODO Auto-generated method stub
		return actionOnSong(null);
	}
	
	//================================================================================
	
	private ArrayList<Song> actionOnSong(String songId){
		ArrayList<Song> songList = new ArrayList<Song>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			//Check whether the song Id is available
			
			if(songId != null && !songId.isEmpty()) {
				/*
				 * Get song by ID query will be retrieved from
				 * SongQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SONG));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, songId);
			
			}
			//If an id is not provided, display all the songs
			
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SONGS));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Song s = new Song();
				
				s.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				s.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				s.setArtistName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				s.setGenre(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				s.setReleasedDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				s.setLyricist(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				s.setProducer(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				s.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				s.setCoverart(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				s.setSongtrack(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				
				
				
				songList.add(s);
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return songList;
	}

	
	//================================================================================
	
	
	@Override
	public Song updateSong(String songId, Song song) {
		// TODO Auto-generated method stub
		
		//Check whether the song is available
		if(songId != null && !songId.isEmpty()) {
			//Update song query will be retrieved from SongQuery.xml
			
			try {
				connection = DBConnection.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SONG));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,song.getId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,song.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,song.getArtistName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,song.getGenre());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE,song.getReleasedDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX,song.getLyricist());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, song.getProducer());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT,song.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,song.getCoverart());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN,song.getSongtrack());
				
				
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				//Close the prepared statement and database connectivity at the end of the transaction
				
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}if(connection != null) {
						connection.close();
					}
				}catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		//Get the updated song
		return getSongByID(songId);
	}

	//================================================================================
	
	
	@Override
	public void deleteSong(String songId) {
		if(songId != null && !songId.isEmpty()) {
			try {
				connection = DBConnection.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_SONG));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,songId);
				preparedStatement.execute();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				//Close the prepared statement and database connectivity at the end of the transaction
				
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}if(connection != null) {
						connection.close();
					}
				}catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of song id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	
	//================================================================================
	
	//create an array list to store song ids
	private ArrayList<String> getSongIds(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of song IDs will be retrieved from SongQuery.xml
		 */
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SONG_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}

}

