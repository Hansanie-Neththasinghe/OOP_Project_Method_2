package Models;


/**
 * @author Hansanie Neththasinghe
 *
 */
public class Song {
	private String songId;
	private String name;
	private String artistName;
	private String genre;
	private String releasedDate;
	private String lyricist;
	private String producer;
	private String description;
	private String coverart;
	private String songtrack;
	
	public Song() {
		
	}
	// Constructor creation
	public Song( String name, String artistName, String genre, String releasedDate, String lyricist,
			String producer, String description, String coverart, String songtrack) {
		super();
		this.name = name;
		this.artistName = artistName;
		this.genre = genre;
		this.releasedDate = releasedDate;
		this.lyricist = lyricist;
		this.producer = producer;
		this.description = description;
		this.coverart = coverart;
		this.songtrack = songtrack;
	}
	
	
	//Implementing getters and setters
	
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return songId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.songId = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the artistName
	 */
	public String getArtistName() {
		return artistName;
	}
	/**
	 * @param artistName the artistName to set
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the releasedDate
	 */
	public String getReleasedDate() {
		return releasedDate;
	}
	/**
	 * @param releasedDate the releasedDate to set
	 */
	public void setReleasedDate(String releasedDate) {
		this.releasedDate = releasedDate;
	}
	/**
	 * @return the lyricist
	 */
	public String getLyricist() {
		return lyricist;
	}
	/**
	 * @param lyricist the lyricist to set
	 */
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
	/**
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}
	/**
	 * @param producer the producer to set
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}
	/**
	 * @return the lyrics
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param lyrics the lyrics to set
	 */
	public void setDescription(String lyrics) {
		this.description = lyrics;
	}
	/**
	 * @return the coverart
	 */
	public String getCoverart() {
		return coverart;
	}
	/**
	 * @param coverart the coverart to set
	 */
	public void setCoverart(String coverart) {
		this.coverart = coverart;
	}
	/**
	 * @return the songtrack
	 */
	public String getSongtrack() {
		return songtrack;
	}
	/**
	 * @param songtrack the songtrack to set
	 */
	public void setSongtrack(String songtrack) {
		this.songtrack = songtrack;
	}
	
}
