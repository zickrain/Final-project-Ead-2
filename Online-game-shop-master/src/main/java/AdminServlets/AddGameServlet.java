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


@WebServlet("/AddGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Game game = new Game();
		boolean status = false;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String gameName= request.getParameter("game_name");
		String gameAuthor= request.getParameter("game_author");
		String gameImg= request.getParameter("game_img");
		String gameDescription= request.getParameter("game_description");
		String gamePrice = request.getParameter("game_price");
		String gameYear = request.getParameter("game_year");
		HttpSession adminSession = request.getSession(false);

		if(gameName != null && gameAuthor != null && gameImg != null && gameDescription != null && gamePrice != null && gameYear != null){
			game.setGameName(gameName);
			game.setGameAuthor(gameAuthor);
			game.setGameImg(gameImg);
			game.setGameDescription(gameDescription);
			game.setGamePrice(Double.parseDouble(gamePrice));
			game.setGameYear(Integer.parseInt(gameYear));
			try {
				status = new MyDao().insert(game);
			} catch (Exception e) {
				adminSession.setAttribute("exception",e);
				e.printStackTrace();
			}
			if(status){
				out.println("<script>alert('You Have Succesfully Added new Game !!!')</script>");
				adminSession.setAttribute("message","You Have Succesfully Added new Game !!!" );
				response.sendRedirect("admin/AdminHome.jsp");
			}else{
				out.println("<script>alert('Error !!! You Have Added duplicate Game  !!!')</script>");
				adminSession.setAttribute("message","Error !!! You Have Added duplicate Game !!!" );
				response.sendRedirect("admin/AdminHome.jsp");
			}
		}else{
			out.println("<script>alert('Write Game Details Again !!!')</script>");
			response.sendRedirect("AdminLogin.jsp");
		}


	}

}
