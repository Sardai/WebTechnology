

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		if(!AuthHelper.isAdminIngelogd(request, response))
		{
			return;
		}
		 		
		KamerVerhuur kamerVerhuur = (KamerVerhuur) request.getServletContext().getAttribute("KamerVerhuur");
		
		PrintWriter writer = response.getWriter();
		
		int visitCount = 0;
		String lastVisit = "";
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if(c.getName().equals("visitCount")){
				visitCount = Integer.parseInt(c.getValue());
			}
			else if(c.getName().equals("lastVisit")){
				lastVisit = c.getValue();
			}
		}
		
		writer.append("<p>Aantal keren bezocht: " + visitCount + "</p>");
		writer.append("<p>Laatste keer bezocht: " + lastVisit + "</p><br />");
		writer.append("<table>"
				+ "<tr><th>Gebruikers</th></tr>"
				); 
		for(User user : kamerVerhuur.getUsers()){
			writer.append(String.format(""
					+ "<tr>"
					+ "<td>%s</td>"
					+ "</tr>",
					user.getUsername()));
		}
		writer.append("</table>");
		
		visitCount++;
		
		Cookie newVisitCookie = new Cookie("visitCount", "" + visitCount);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Cookie lastVisitCookie = new Cookie("lastVisit", sdf.format(new Date()));
		
		newVisitCookie.setMaxAge(84600);
		lastVisitCookie.setMaxAge(84600);
		
		response.addCookie(newVisitCookie);
		response.addCookie(lastVisitCookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
