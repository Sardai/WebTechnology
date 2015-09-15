
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.Huurder;
import model.KamerVerhuur;
import model.User;
import model.Verhuurder;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KamerVerhuur kamerVerhuur;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();		
	}
	
	@Override
	public void init() throws ServletException {		
		super.init();
		kamerVerhuur = (KamerVerhuur) getServletContext().getAttribute("KamerVerhuur");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = kamerVerhuur.getUser(username, password);
		
		
		if (user != null) {			
			request.getSession().setAttribute("User", user);
			if(user instanceof Huurder){
				response.sendRedirect("huurder.html");
			}else if(user instanceof Verhuurder){
				response.sendRedirect("ShowRoomsServlet");
			}else if(user instanceof Admin){
				response.sendRedirect("GetUsersServlet");
			}
			
		} else {
			getServletContext().getRequestDispatcher("/WEB-INF/fouteInlog.html").forward(request, response);
		}
	}

}
