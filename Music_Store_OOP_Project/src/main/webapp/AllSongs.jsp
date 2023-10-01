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
	<table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Artist</th>
            <th>Genre</th>
            <th>Released Date</th>
            <th>Lyricist</th>
            <th>Producer</th>
            <th>Description</th>
            <th>Cover Art</th>
            <th>Song Track</th>
        </tr>
        
        <c:forEach items="${songList}" var="song">
            <tr>
            <% ISongServices s = new SongServicesImpl();
				ArrayList<Song> arrayList = s.getSongs(); %>
						
				<%	for(Song song: arrayList){ %>
                <td><%= song.getId() %></td>
                <td><%= song.getName() %></td>
                <td><%= song.getArtistName() %></td>
                <td><%= song.getGenre() %></td>
                <td><%= song.getReleasedDate() %></td>
                <td><%= song.getLyricist() %></td>
                <td><%= song.getProducer() %></td>
                <td><%= song.getDescription() %></td>
                <td><%= song.getCoverart() %></td>
                <td><%= song.getSongtrack() %></td>
                <td>
				<form action="UpdateSongServlet" method="post">
					<div class="form-group">
						<input type="hidden" value="<%= song.getId() %>" name="songId">
						<input type="submit" value="Edit" class="btn btn-outline-light btn-sm">
					</div>
				</form>
				</td>
				<td>
				<form action="<%= request.getContextPath()%>/DeleteSongServlet" onsubmit="return confirmDelete(this)" method="post">
					<div class="form-group">
						<input type="hidden" value="<%= song.getId() %>" name="songId">
						<input type="submit" value="Delete" class="btn btn-outline-light btn-sm">
					</div>
				</form>
				</td>
            </tr>
            	<%	} %>
        </c:forEach>
        </table>
</body>
</html>