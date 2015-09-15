
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
	private KamerVerhuur kamerVerhuur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRoomServlet() {
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

		if (!AuthHelper.isVerhuurderIngelogd(request, response)) {
			return;
		}

		getServletContext().getRequestDispatcher("/WEB-INF/addRoom.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!AuthHelper.isVerhuurderIngelogd(request, response)) {
			return;
		}
		if (request.getParameter("kamerNummer").isEmpty() || request.getParameter("huurPrijs").isEmpty()
				|| request.getParameter("aantalPersonen").isEmpty() || request.getParameter("vierkanteMeters").isEmpty()) {
			getServletContext().getRequestDispatcher("/WEB-INF/emptyFields.html").forward(request, response);
			return;
		}

		int kamerNummer = 0;
		double huurPrijs = 0;
		int aantalPersonen = 0;
		int vierkanteMeters = 0;
		String plaats = request.getParameter("plaats");

		try {
			kamerNummer = Integer.parseInt(request.getParameter("kamerNummer"));
			huurPrijs = Double.parseDouble(request.getParameter("huurPrijs"));
			aantalPersonen = Integer.parseInt(request.getParameter("aantalPersonen"));
			vierkanteMeters = Integer.parseInt(request.getParameter("vierkanteMeters"));
		} catch (NumberFormatException e) {
			getServletContext().getRequestDispatcher("/WEB-INF/wrongDataType.html").forward(request, response);
			return;
		}

		Kamer kamer = new Kamer(kamerNummer, vierkanteMeters, huurPrijs, plaats, aantalPersonen);

		kamerVerhuur.addKamer(kamer);

		response.sendRedirect("ShowRoomsServlet");
	}

}
