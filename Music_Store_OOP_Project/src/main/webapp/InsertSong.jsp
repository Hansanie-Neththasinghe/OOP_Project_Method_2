<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Song</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

	<form action="InsertSongServlet" method="post" enctype="multipart/form-data">
	
	<h2 >Insert Your New Song Details</h2>
	<div class="container">
	
		<div class="form-group">
    		<label for="name">Enter Song Name</label>
    		<input type="text" class="form-control" id="name" name="name" placeholder="Enter song name" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="artistName">Enter Artist Name</label>
    		<input type="text" class="form-control" id="artistName" name="artistName" placeholder="Enter artist name" required>
    	</div>
    	
    	<div class="form-group">
    	<label for="genre">Enter Genre</label>
		<select name="genre" id="genre" class="form-control" name="genre" required>
			<option value=" ">Select</option>
    		<option value="pop">Pop</option>
    		<option value="jazz">Jazz</option>
    		<option value="love">Love</option>
    		<option value="acoustic">Acoustic</option>
  		</select>
    	</div>
    	
    	<div class="form-group">
    		<label for="releasedDate">Enter Releasing Date</label>
    		<input type="date" class="form-control" id="releasedDate" name="releasedDate" placeholder="Enter releasing date" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="lyricist">Enter Lyricist</label>
    		<input type="text" class="form-control" id="lyricist" name="lyricist" placeholder="Enter lyricist name" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="producer">Enter Producer</label>
    		<input type="text" class="form-control" id="producer" name="producer" placeholder="Enter producer name" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="lyrics">Enter Description</label>
    		<input type="text" class="form-control" id="lyrics" name="lyrics" placeholder="Enter description" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="file1">Enter Coverart</label>
    		<input type="file" class="form-control" id="file1" name="file1" placeholder="Enter coverart" required>
    	</div>
    	
    	<div class="form-group">
    		<label for="file2">Enter Songtrack</label>
    		<input type="file" class="form-control" id="file2" name="file2" placeholder="Enter songtrack" required>
    	</div>
	
		<div class="form-group">
    		<input type="submit" class="form-control" id="submit" name="submit" value="Upload Song">
    	</div>
	
	</div>
	
	</form>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>