

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Kamer;
import model.KamerVerhuur;

/**
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
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
		double huurPrijs = Double.parseDouble(request.getParameter("huurPrijs"));
		int aantalPersonen = Integer.parseInt(request.getParameter("aantalPersonen"));
		int vierkanteMeters = Integer.parseInt(request.getParameter("vierkanteMeters"));
		String plaats =  request.getParameter("plaats");
		
		Kamer kamer = new Kamer(vierkanteMeters, huurPrijs, plaats, aantalPersonen);
		
		KamerVerhuur kamerVerhuur = (KamerVerhuur) request.getServletContext().getAttribute("KamerVerhuur");
		kamerVerhuur.addKamer(kamer);
		
		response.sendRedirect("ShowRoomsServlet");
	}

}
