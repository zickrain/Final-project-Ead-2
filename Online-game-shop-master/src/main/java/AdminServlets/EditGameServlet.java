package AdminServlets;


import DAO.MyDao;
import Model.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gameId = request.getParameter("gameId");
		Game game = new Game();

		if(gameId != null && !(gameId.equals(""))){
			try {
				game = new MyDao().selectOne(Integer.parseInt(gameId));
			} catch (Exception e) {
				request.getSession().setAttribute("exception",e.getMessage());
			}
			request.getSession().setAttribute("game", game);
			response.sendRedirect("admin/EditGame.jsp");
		}else{
			request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
			response.sendRedirect("admin/AdminHome.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int gameId = Integer.parseInt(request.getParameter("game_id"));
		String gameName= request.getParameter("game_name");
		String gameAuthor= request.getParameter("game_author");
		String gameImg= request.getParameter("game_img");
		String gameDescription= request.getParameter("game_description");
		String gamePrice = request.getParameter("game_price");
		String gameYear = request.getParameter("game_year");
		Game game = new Game();
		HttpSession adminSession = request.getSession(false);

		boolean status = false;
		PrintWriter out = response.getWriter();
		if(gameName != null && gamePrice != null && gameYear != null && gameId != 0){
			game.setGameId(gameId);
			game.setGameName(gameName);
			game.setGameAuthor(gameAuthor);
			game.setGameImg(gameImg);
			game.setGameDescription(gameDescription);
			game.setGamePrice(Double.parseDouble(gamePrice));
			game.setGameYear(Integer.parseInt(gameYear));
			try {
				status = new MyDao().update(game);
				game.toString();
			} catch (Exception e) {
				adminSession.setAttribute("exception",e);
				e.printStackTrace();
			}
			if(status){
				out.println("<script>alert('You Have Succesfully Edited new Game !!!')</script>");
				adminSession.setAttribute("message","You Have Succesfully Edited new Game !!!" );
				response.sendRedirect("admin/AdminHome.jsp");
			}else{
				out.println("<script>alert('Error !!! You Have Edited duplicate Game  !!!')</script>");
				adminSession.setAttribute("message","Error !!! You Have Edited duplicate Game !!!" );
				response.sendRedirect("admin/AdminHome.jsp");
			}
		}else{
			out.println("<script>alert('Write Game Details Again !!!')</script>");
			response.sendRedirect("AdminLogin.jsp");
		}
	}

}
