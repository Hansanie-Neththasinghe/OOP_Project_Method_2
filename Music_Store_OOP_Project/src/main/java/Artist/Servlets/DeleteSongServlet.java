package Artist.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Artist.Services.*;
/**
 * Servlet implementation class DeleteSongServlet
 */
@WebServlet("/DeleteSongServlet")
public class DeleteSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSongServlet() {
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
		
		String songId =request.getParameter("songId");
		
		ISongServices iSongService = new SongServicesImpl();
		//Song song = iSongService.deleteSong(songId);
		iSongService.deleteSong(songId);
		
		//request.setAttribute("Song", song);
		request.setAttribute("SongId", songId);
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/AllSongs.jsp");
		dis.forward(request, response);
	}

}
