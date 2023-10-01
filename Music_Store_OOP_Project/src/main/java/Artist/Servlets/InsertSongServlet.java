package Artist.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import Artist.Services.*;
import Models.Song;

@WebServlet("/InsertSongServlet")
@MultipartConfig(
		location = "C:\\Projects\\Music_Store_OOP_Project\\src\\main\\assets",
		fileSizeThreshold = 1024 * 1024, //1MB
		maxFileSize = 1024 * 1024 * 10,  //10MB
		maxRequestSize = 1024 * 1024 * 31 //31MB
	) 
public class InsertSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InsertSongServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String artistName = request.getParameter("artistName");
		String genre = request.getParameter("genre");
		String releasedDate = request.getParameter("releasedDate");
		String lyricist = request.getParameter("lyricist");
		String producer = request.getParameter("producer");
		String lyrics = request.getParameter("lyrics");
		
		String uploadPath = "";
		String uploadPath2 = "";
		
		try {
			Part part1 = request.getPart("file1");
			uploadPath = getFileName(part1);
			part1.write(getFileName(part1));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Part part2 = request.getPart("file2");
			uploadPath2 = getFileName(part2);
			part2.write(getFileName(part2));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//int id = 001;
		Song s= new Song(name, artistName, genre, releasedDate, lyricist , producer, lyrics , uploadPath , uploadPath2);
		//ISongServices obj = new SongServicesImpl();
		//boolean isTrue;//creating a boolean variable to catch the value which is returning from songinsert method. It is returning an boolean value
		
		//isTrue = obj.insertsong(name, artistName, genre, releasedDate, lyricist , producer, lyrics , uploadPath , uploadPath2);
		//obj.addSong(s);
		
		ISongServices iSongServices = new SongServicesImpl();
		//Add the new song object
		iSongServices.addSong(s);
		
		request.setAttribute("getSongObject", s);
//		if(isTrue == true) {
//			//redirecting to a jsp page
//			RequestDispatcher dis = request.getRequestDispatcher("insertsuccess.jsp");
//			dis.forward(request, response);
//		}else {
//			RequestDispatcher dis2 = request.getRequestDispatcher("insertunsuccess.jsp");
//			dis2.forward(request, response);
//		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/success.jsp");
		dispatcher.forward(request, response);
	}

	
	
	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		
		if(!contentDisposition.contains("filename=")) {
			return null;
		}
		int beginIndex = contentDisposition.indexOf("filename=") + 10;
		int endIndex = contentDisposition.length() -1;
		
		return contentDisposition.substring(beginIndex,endIndex);
	}
}
