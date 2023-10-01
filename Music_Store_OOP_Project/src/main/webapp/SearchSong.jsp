<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<form action="GetSongServlet" method="post">
  					<div class="form-group">
    					<label for="songId">Song Id</label>
    					<input type="text" class="form-control" name="songId" >
  					
 					 <br>
  
  					<button type="submit" class="btn btn-primary">Show Song Details</button>
				</form>

</body>
</html>