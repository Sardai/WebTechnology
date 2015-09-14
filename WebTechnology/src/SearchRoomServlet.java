

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchRoomServlet
 */
@WebServlet("/SearchRoomServlet")
public class SearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomServlet() {
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
		// TODO Auto-generated method stub
		int oppervlakte = Integer.parseInt(request.getParameter("oppervlakte"));
		int personen = Integer.parseInt(request.getParameter("personen"));
		double max_prijs = Double.parseDouble(request.getParameter("max_prijs"));
		String plaats = request.getParameter("plaats");
		
		System.out.println("Aantal vierkante meter: " + oppervlakte + "\n" + "Aantal personen: " + personen
				+ "\n" + "Maximale prijs: " + max_prijs + "\n" + "Plaats: " + plaats);
		
		doGet(request, response);
	}

}
