

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.AuthHelper;
import model.Kamer;
import model.KamerVerhuur;
import model.User;
import model.Verhuurder;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!AuthHelper.isVerhuurderIngelogd(request, response))
		{
			return;
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/addRoom.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!AuthHelper.isVerhuurderIngelogd(request, response))
		{
			return;
		}
		
		int kamerNummer = Integer.parseInt(request.getParameter("kamerNummer"));
		double huurPrijs = Double.parseDouble(request.getParameter("huurPrijs"));
		int aantalPersonen = Integer.parseInt(request.getParameter("aantalPersonen"));
		int vierkanteMeters = Integer.parseInt(request.getParameter("vierkanteMeters"));
		String plaats =  request.getParameter("plaats");
		
		Kamer kamer = new Kamer(kamerNummer,vierkanteMeters, huurPrijs, plaats, aantalPersonen);
		
		KamerVerhuur kamerVerhuur = (KamerVerhuur) request.getServletContext().getAttribute("KamerVerhuur");
		kamerVerhuur.addKamer(kamer);
		
		response.sendRedirect("ShowRoomsServlet");
	}

}
