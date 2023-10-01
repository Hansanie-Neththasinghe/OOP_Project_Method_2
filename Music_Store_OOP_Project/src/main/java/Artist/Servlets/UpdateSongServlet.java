package Artist.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.Song;
import Artist.Services.*;

/**
 * Servlet implementation class UpdateSongServlet
 */
@WebServlet("/UpdateSongServlet")
public class UpdateSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Song song = new Song();
		
		String songId = request.getParameter("songId");
		
		song.setId(songId);
		
		song.setName(request.getParameter("name"));
		song.setArtistName(request.getParameter("artist"));
		song.setGenre(request.getParameter("genre"));
		song.setReleasedDate(request.getParameter("date"));
		song.setLyricist(request.getParameter("lyricist"));
		song.setDescription(request.getParameter("lyrics"));
		song.setCoverart(request.getParameter("file1"));
		song.setSongtrack(request.getParameter("file2"));
		
		ISongServices iSongServices = new SongServicesImpl();
		iSongServices.updateSong(songId,song);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateSong.jsp");
		dispatcher.forward(request, response);
	}

}
