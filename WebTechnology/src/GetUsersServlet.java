

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.AuthHelper;
import model.Kamer;
import model.KamerVerhuur;
import model.User;

/**
 * Servlet implementation class GetUsersServlet
 */
@WebServlet("/GetUsersServlet")
public class GetUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthHelper.isVerhuurderIngelogd(request, response))
		{
			return;
		}
		 		
		KamerVerhuur kamerVerhuur = (KamerVerhuur) request.getServletContext().getAttribute("KamerVerhuur");
		
		PrintWriter writer = response.getWriter();
		
		writer.append("<p>Aantal keren bezocht: </p>"); //+ iets met cookies
		writer.append("<table>"
				+ "<tr><th>Gebruikers</th></tr>"
				); 
		for(User user : kamerVerhuur.getUsers()){
			writer.append(String.format(""
					+ "<tr>"
					+ "<td>%d</td>"
					+ "</tr>",
					user.getUsername()));
		}
		writer.append("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
