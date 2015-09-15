

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Huurder;
import model.KamerVerhuur;
import model.User;
import model.Verhuurder;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KamerVerhuur kamerVerhuur; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

    @Override
	public void init() throws ServletException {		
		super.init();
		kamerVerhuur = (KamerVerhuur) getServletContext().getAttribute("KamerVerhuur");
	}

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("registeer.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		KamerVerhuur kamerVerhuur = (KamerVerhuur) context.getAttribute("KamerVerhuur");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		if(kamerVerhuur.userExists(username)){
			getServletContext().getRequestDispatcher("/WEB-INF/usernameExists.html").forward(request, response);
			return;
		}
		
		if(username.isEmpty() || password.isEmpty() || type == null){
			getServletContext().getRequestDispatcher("/WEB-INF/emptyFields.html").forward(request, response);
			return;
		}
		
		User user = null;
		if(type.equals("huurder")){
			user = new Huurder(username, password);
		}else if(type.equals("verhuurder")){
			user = new Verhuurder(username, password);
		}

		kamerVerhuur.addUser(user);
		response.sendRedirect("login.html");
	}

}
