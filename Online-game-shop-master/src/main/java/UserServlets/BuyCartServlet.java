package UserServlets;

import DAO.MyDao;
import Model.Game;
import Model.Cart;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BuyCartServlet")
public class BuyCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = new Cart();
        boolean status = false;
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        User user = new User();
        Game game = new Game();
        game = (Game) request.getSession().getAttribute("game");

        String amount = request.getParameter("amount");
        String user_email = request.getParameter("user_email");

        if(game.getGameId() != 0  && user_email != null && !(user_email.equals(""))){
            try {
                game = new MyDao().selectOne(game.getGameId());
                user = new MyDao().selectUser(user_email);
                request.getSession().setAttribute("user_session", user);
            } catch (Exception e) {
                request.getSession().setAttribute("exception",e.getMessage());
            }
        }else{
            request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
            response.sendRedirect("user/Menu.jsp");
        }

        HttpSession userSession = request.getSession(false);

        if(amount != null && user.getUser_id() != 0
                && game.getGameName() != null && game.getGamePrice() != 0){
            cart.setGame_name(game.getGameName());
            cart.setCost(game.getGamePrice());
            cart.setAmount(Integer.parseInt(amount));
            cart.setTotal_cost(Double.parseDouble(String.valueOf(game.getGamePrice()*Integer.parseInt(amount))));
            cart.setUser_id(user.getUser_id());
            try {
                status = new MyDao().buyCart(cart);
            } catch (Exception e) {
                userSession.setAttribute("exception",e);
                e.printStackTrace();
            }
            if(status){
                String path = "/CartsServlet";
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
                out.println("<script>alert('You Have Succesfully Added new Game !!!')</script>");
                userSession.setAttribute("message","You Have Succesfully Added new Game !!!" );
//                response.sendRedirect("user/MyCarts.jsp");
            }else{
                out.println("<script>alert('Error !!! You Have Added duplicate Game  !!!')</script>");
                userSession.setAttribute("message","Error !!! You Have Added duplicate Game !!!" );
                response.sendRedirect("user/Menu.jsp");
            }
        }else{
            out.println("<script>alert('Write Game Details Again !!!')</script>");
            response.sendRedirect("Login.jsp");
        }
    }

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
            response.sendRedirect("user/Order.jsp");
        }else{
            request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
            response.sendRedirect("user/Menu.jsp");
        }

    }
}
