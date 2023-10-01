<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Models.Song" %>
<%@ page import = "Artist.Services.*" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <title>Update Song Details</title>
</head>
<body>
    <h1>Update Song Details</h1>
    <%
					String songId = (String) request.getAttribute("songId");
					
					ISongServices so = new SongServicesImpl();
					Song song = so.getSongByID(songId);
					
				%>
				
				
  
    <form action="UpdateSongServlet" method="post" enctype="multipart/form-data">
	
	<h2 >Insert Your New Song Details</h2>
	<div class="container">
	
		<div class="form-group">
    		<label for="name">Enter Song Name</label>
    		<input type="text" value="<%= song.getName() %>" class="form-control" id="name" name="name" placeholder="Enter song name" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="artistName">Enter Artist Name</label>
    		<input type="text" value="<%= song.getArtistName() %>"  class="form-control" id="artistName" name="artistName" placeholder="Enter artist name" required>
    	</div>
    	
    	<div class="form-group">
    	<label for="genre">Enter Genre</label>
		<select name="genre" id="genre" value="<%= song.getGenre() %>" class="form-control" name="genre" required>
			<option value=" ">Select</option>
    		<option value="pop">Pop</option>
    		<option value="jazz">Jazz</option>
    		<option value="love">Love</option>
    		<option value="acoustic">Acoustic</option>
  		</select>
    	</div>
    	
    	<div class="form-group">
    		<label for="releasedDate">Enter Releasing Date</label>
    		<input type="date" value="<%= song.getReleasedDate() %>" class="form-control" id="releasedDate" name="releasedDate" placeholder="Enter releasing date" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="lyricist">Enter Lyricist</label>
    		<input type="text" value="<%= song.getLyricist() %>" class="form-control" id="lyricist" name="lyricist" placeholder="Enter lyricist name" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="producer">Enter Producer</label>
    		<input type="text" value="<%= song.getProducer() %>" class="form-control" id="producer" name="producer" placeholder="Enter producer name" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="lyrics">Enter Description</label>
    		<input type="text" value="<%= song.getDescription() %>" class="form-control" id="lyrics" name="lyrics" placeholder="Enter description" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="file1">Enter Coverart</label>
    		<input type="file" value="<%= song.getCoverart() %>" class="form-control" id="file1" name="file1" placeholder="Enter coverart" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="file2">Enter Songtrack</label>
    		<input type="file" value="<%= song.getSongtrack() %>" class="form-control" id="file2" name="file2" placeholder="Enter songtrack" required>
    	</div>
	
		<div class="form-group">
    		<input type="submit" class="form-control" id="update" name="update" value="Update Song">
    	</div>
	
	</div>
	
	</form>
	
</body>
</html>


</body>
</html>