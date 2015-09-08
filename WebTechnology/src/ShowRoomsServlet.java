

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Kamer;
import model.KamerVerhuur;
import model.User;
import model.Verhuurder;

/**
 * Servlet implementation class ShowRoomsServlet
 */
@WebServlet("/ShowRoomsServlet")
public class ShowRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.html");
		}
		
		User user = (User) session.getAttribute("User");
		
		if(!(user instanceof Verhuurder)){			 
			response.sendRedirect("login.html");	
			return;
		}
		
		KamerVerhuur kamerVerhuur = (KamerVerhuur) request.getServletContext().getAttribute("KamerVerhuur");
		
		PrintWriter writer = response.getWriter();
		
		writer.append("<a href='addRoom.html'>Kamer toevoegen</a>");
		writer.append("<table>"
				+ "<tr><th>Nummer</th><th>Aantal personen</th><th>Huur prijs</th><th>Vierkante meters</th><th>Plaats</th></tr>"
				); 
		for(Kamer kamer : kamerVerhuur.getKamers()){
			writer.append(String.format(""
					+ "<tr>"
					+ "<td>%d</td>"
					+ "<td>%d</td>"
					+ "<td>%.2f</td>"
					+ "<td>%d</td>"
					+ "<td>%s</td>"
					+ "</tr>",
					kamer.getKamerNummer(),kamer.getAantalPersonen(),
					kamer.getHuurprijs(),kamer.getVierkanteMeters(),kamer.getPlaats()));
		}
		writer.append("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
